package org.jtesttools.demo;

import java.io.FileReader;

import org.jtesttools.demo.impl.TranslateClient;
import org.jtesttools.demo.model.GoogleTranslate;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PoTranslator {

    @Test
    public void translatePoFile() throws Exception {
        FileReader fileReader = new FileReader("/resources/pt_BR.po");
        StringBuilder content = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int nextChar;
        while ((nextChar = fileReader.read()) != -1) {
            content.append((char) nextChar);
        }

        Translate translate = new TranslateClient();

        String[] lines = content.toString().split("\n");
        String term = "";
        for (String line : lines) {
            if (line != null && line.startsWith("msgid ")) {
                term = line.substring(7, line.length() - 1);
            }
            if (line != null && line.startsWith("msgstr ")) {
                if (term != null && !term.startsWith("http") && term.length() < 200) {
                    String translatedJson = translate.translate(term);
                    ObjectMapper objectMapper = new ObjectMapper();
                    GoogleTranslate t = null;
                    try {
                        t = objectMapper.readValue(translatedJson, GoogleTranslate.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (t != null) {
                        String translatedText = t.getData().getTranslations().get(0).getTranslatedText();
                        line = "msgstr \"" + translatedText + "\"";
                    } else {
                        line = "msgstr \"" + term + "\"";
                    }
                } else {
                    line = "msgstr \"" + term + "\"";
                }
            }
            System.out.println(line);
            result.append(line).append("\n");
            Thread.sleep(200);
        }
        System.out.println(result);
    }

}
