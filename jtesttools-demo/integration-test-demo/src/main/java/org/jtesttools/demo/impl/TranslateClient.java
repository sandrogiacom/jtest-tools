package org.jtesttools.demo.impl;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.jtesttools.demo.Translate;
import org.jtesttools.demo.config.GoogleConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class TranslateClient implements Translate {

    @Autowired
    private GoogleConfig config;

    @Override
    public String getLanguages() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(config.getServerUrl() + "/language/translate/v2/languages?key=" + config.getApiKey()))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            throw e;
        }

        return response.body();
    }

    @Override
    public String translate(String phrase) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        // json formatted data
        String json = new StringBuilder()
                .append("{")
                .append("\"q\":\"" +  phrase + "\",")
                .append("\"target\":\"pt\"")
                .append("}").toString();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("https://translation.googleapis.com" + "/language/translate/v2?key=AIzaSyCptMknvTR-Eosry2Hfv_PXQgZYygtQKSM"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            throw e;
        }

        return response.body();
    }

    @Override
    public void updateSomething() {
        System.out.println("TranslateClient > updateSomething");
    }

}
