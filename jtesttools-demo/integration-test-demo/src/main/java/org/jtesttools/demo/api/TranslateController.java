package org.jtesttools.demo.api;

import org.jtesttools.demo.model.Languages;
import org.jtesttools.demo.service.TranslatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {

    private TranslatorService service;

    public TranslateController(TranslatorService service) {
        this.service = service;
    }

    @GetMapping({"/languages"})
    public Languages getLanguages() {
        return service.getLanguages();
    }

    @GetMapping({"/translate/{value}"})
    public String translate(@PathVariable(value = "value") String value) {
        return service.translate(value);
    }

}
