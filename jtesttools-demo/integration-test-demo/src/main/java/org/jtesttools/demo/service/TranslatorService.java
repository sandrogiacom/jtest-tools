package org.jtesttools.demo.service;

import org.jtesttools.demo.Translate;
import org.jtesttools.demo.model.Data;
import org.jtesttools.demo.model.Languages;
import org.jtesttools.mockit.JsonConverter;
import org.springframework.stereotype.Service;

@Service
public class TranslatorService {

    private Translate translate;

    public TranslatorService(Translate translate) {
        this.translate = translate;
    }

    public Languages getLanguages() {
        String json = translate.getLanguages();
        Data data = JsonConverter.of().toObject(json, Data.class);
        return null;
    }

}
