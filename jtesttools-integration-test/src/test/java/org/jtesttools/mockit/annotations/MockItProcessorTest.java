package org.jtesttools.mockit.annotations;

import org.jtesttools.mockit.annotations.impl.DemoMockItMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MockItProcessorTest {

	//TODO nao deveria informar a impl
	@MockIt(impl = DemoMockItMock.class)
	private DemoMockIt demoMockIt;

	@BeforeEach
	public void initMockIt() {
		MockItAnnotations.initMocks(this);
	}

	@Test
	void process() {
		demoMockIt.hello("I'm here!");
	}
}
