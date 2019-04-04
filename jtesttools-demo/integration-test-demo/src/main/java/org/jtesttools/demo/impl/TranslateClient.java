package org.jtesttools.demo.impl;


import org.jtesttools.demo.Translate;
import org.jtesttools.demo.config.GoogleConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class TranslateClient implements Translate {

    @Autowired
    private GoogleConfig config;

    @Override
    public String getLanguages() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(config.getServerUrl() + "/language/translate/v2/languages?key=" + config.getApiKey()))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response.body();
    }

}
