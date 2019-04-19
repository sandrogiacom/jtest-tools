package org.jtesttools.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Language {
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public static final class LanguageBuilder {
        private Language language;

        private LanguageBuilder() {
            language = new Language();
        }

        public static LanguageBuilder of() {
            return new LanguageBuilder();
        }

        public LanguageBuilder language(String lang) {
            language.setLanguage(lang);
            return this;
        }

        public Language build() {
            return language;
        }
    }
}
