package org.jtesttools.demo.impl;


import org.jtesttools.demo.Translate;
import org.jtesttools.mockit.MockWebIt;
import org.jtesttools.mockit.annotations.MockItImpl;
import org.mockserver.model.HttpRequest;

@MockItImpl
public class TranslatetClientMock extends MockWebIt implements Translate {

    @Override
    public String getLanguages() {
        request = HttpRequest.request("/language/translate/v2/languages");
        return null;
    }

    @Override
    public String translate(String phrase) throws Exception {
        return null;
    }

    @Override
    public void updateSomething() {
        System.out.println("TranslatetClientMock > updateSomething");
    }

}
