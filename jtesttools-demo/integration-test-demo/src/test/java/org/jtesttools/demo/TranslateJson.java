package org.jtesttools.demo;

import java.io.FileReader;
import java.util.HashMap;

import org.jtesttools.demo.impl.TranslateClient;
import org.jtesttools.demo.model.GoogleTranslate;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TranslateJson {

    @Test
    public void translateJsonFile() throws Exception {

        FileReader fileReader = new FileReader("resources/portuguese.json");
        StringBuilder content = new StringBuilder();
        int nextChar;
        while ((nextChar = fileReader.read()) != -1) {
            content.append((char) nextChar);
        }
        HashMap<String, String> input =
                new ObjectMapper().readValue(content.toString(), HashMap.class);

        HashMap<String, String> output = new HashMap<>();

        Translate translate = new TranslateClient();

        for (String s : input.keySet()) {
            String phrase = input.get(s);
            System.out.println("Traduzir: " + phrase);
            String translated = translate.translate(phrase);
            ObjectMapper objectMapper = new ObjectMapper();

            GoogleTranslate t = objectMapper.readValue(translated, GoogleTranslate.class);

            String translatedText = t.getData().getTranslations().get(0).getTranslatedText();
            System.out.println("Traduzido: " + translatedText);

            output.put(s, translatedText);
        }
        String json = new ObjectMapper().writeValueAsString(output);
        System.out.println(json);
    }

}
