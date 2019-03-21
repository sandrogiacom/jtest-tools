package org.jtesttools.mockit.annotations;

import org.jtesttools.mockit.MockItException;

public class MockItAnnotations {

	public static void initMocks(Object testClass) {
		if (testClass == null) {
			throw new MockItException("testClass cannot be null.");
		}
		MockItAnnotationProcessor mockItProcessor = new MockItAnnotationProcessor();
		try {
			mockItProcessor.process(testClass);
		} catch (Exception e) {
			throw new MockItException("error on create mock instance.", e);
		}
	}

}
