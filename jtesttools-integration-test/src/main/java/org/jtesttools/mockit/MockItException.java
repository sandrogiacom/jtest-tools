package org.jtesttools.mockit;

public class MockItException extends RuntimeException {

    public MockItException(String s, Exception e) {
        super(s, e);
    }

    public MockItException(String s) {
        super(s);
    }
}
