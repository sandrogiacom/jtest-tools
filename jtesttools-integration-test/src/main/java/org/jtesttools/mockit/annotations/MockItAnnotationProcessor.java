package org.jtesttools.mockit.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MockItAnnotationProcessor {

	public void process(Object testClass) throws Exception {
		Class<?> context = testClass.getClass();
		Field[] fields = context.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(MockIt.class)) {
				field.setAccessible(true);
				Object instance;
				if (field.getType().isInterface()) {
					instance = getMockImplementation(field);
				} else {
					instance = field.getType().newInstance();
				}
				field.set(testClass, instance);
			}
		}
	}

	private Object getMockImplementation(Field field) throws Exception {
		Annotation annotation = field.getAnnotation(MockIt.class);
		//deveria descobrir a subclasse
		Class<?> clazz = ((MockIt) annotation).impl();
		return clazz.newInstance();
	}

}
