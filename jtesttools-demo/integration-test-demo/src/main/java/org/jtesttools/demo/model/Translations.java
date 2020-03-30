package org.jtesttools.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Translations {

    private String translatedText;

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Translations{");
        sb.append("translatedText='").append(translatedText).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
