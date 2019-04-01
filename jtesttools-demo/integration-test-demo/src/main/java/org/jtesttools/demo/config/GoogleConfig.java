package org.jtesttools.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleConfig {

    @Value("${google.api.url}")
    private String serverUrl;

    @Value("${google.api.key}")
    private String apiKey;

    public String getServerUrl() {
        return serverUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
