package org.jtesttools.mockit;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.MockServerContainer;

@TestConfiguration
public class MockItTestConfiguration {

	private static MockServerContainer mockServerContainer;
	private MockServerContainer mockServer;

	public MockItTestConfiguration() {
		mockServer = startMockServer();
		MockItServerConfiguration.MOCK_HOST = mockServer.getContainerIpAddress();
		MockItServerConfiguration.MOCK_PORT = mockServer.getServerPort();
	}

	private MockServerContainer startMockServer() {
		if (mockServerContainer == null) {
			mockServerContainer = new MockServerContainer();
			mockServerContainer.start();
			System.setProperty("mock.server", "http://localhost:" + mockServerContainer.getServerPort());
			System.out.println("*******************************");
			System.out.println("mock.server = " + System.getProperty("mock.server"));
			System.out.println("*******************************");
		}

		return mockServerContainer;
	}
}
