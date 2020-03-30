package org.jtesttools.demo;

public interface Translate {

    String getLanguages() throws Exception;

    String translate(String phrase) throws Exception;

    void updateSomething();

}
