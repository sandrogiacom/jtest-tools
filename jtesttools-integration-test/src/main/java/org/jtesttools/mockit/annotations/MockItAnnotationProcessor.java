package org.jtesttools.mockit.annotations;

import java.lang.reflect.Field;
import java.util.Set;

import org.jtesttools.mockit.MockItException;
import org.jtesttools.mockit.MockWebIt;
import org.reflections.Reflections;

@SuppressWarnings("deprecation")
public class MockItAnnotationProcessor {

    public void process(Object testClass) throws Exception {
        Class<?> context = testClass.getClass();
        Field[] fields = context.getDeclaredFields();
        int mockInstances = 0;
        for (Field field : fields) {
            if (field.isAnnotationPresent(MockIt.class)) {
                field.setAccessible(true);
                Object instance;
                if (field.getType().isInterface()) {
                    instance = getMockImplementation(field);
                    mockInstances++;
                } else {
                    instance = field.getType().newInstance();
                    mockInstances++;
                }
                field.set(testClass, instance);
            }
        }
        if (mockInstances == 0) {
            throw new MockItException("No instance of MockIt found!");
        }
    }

    private Object getMockImplementation(Field field) throws Exception {
        Reflections reflections = new Reflections(field.getType());
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(MockItImpl.class);
        if (annotated.size() == 0) {
            throw new Exception("mock implementation not found!");
        }
        if (annotated.size() > 1) {
            throw new Exception("found more than one mock implementation!");
        }
        Class<?> clazz = annotated.iterator().next();
        Object instance = clazz.newInstance();
        MockWebIt.instance = (MockWebIt) instance;
        return instance;
    }

}
