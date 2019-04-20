package org.jtesttools.mockit;

import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class MockWebIt {

    public static final int HTTP_STATUS_OK = 200;
    public static MockWebIt instance;
    protected HttpRequest request;

    public static <T> MockWebIt when(T methodCall) {
        return instance;
    }

    public static <T> T mock(T mock) {
        return mock;
    }

    public void thenReturn(Object response) {
        thenReturn(response, HTTP_STATUS_OK);
    }

    public void thenReturn(Object response, Integer code) {
        String json;
        if (response instanceof String) {
            json = (String) response;
        } else {

            json = JsonConverter.of().toString(response);
        }

        new MockServerClient(MockItServerConfiguration.MOCK_HOST, MockItServerConfiguration.MOCK_PORT)
                .when(request)
                .respond(HttpResponse.response(json).withStatusCode(code));
    }

    public void thenClear() {
        new MockServerClient(MockItServerConfiguration.MOCK_HOST, MockItServerConfiguration.MOCK_PORT).clear(request);
    }

}
