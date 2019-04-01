package org.jtesttools.demo.config;

import org.jtesttools.demo.Translate;
import org.jtesttools.demo.impl.TranslateClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TranslatorConfig {

    @Bean
    public Translate getDemoMockIt() {
        return new TranslateClient();
    }

}
