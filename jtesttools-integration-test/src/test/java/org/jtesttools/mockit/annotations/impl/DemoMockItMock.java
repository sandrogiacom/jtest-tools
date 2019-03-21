package org.jtesttools.mockit.annotations.impl;

import org.jtesttools.mockit.annotations.DemoMockIt;

public class DemoMockItMock implements DemoMockIt {

    @Override
    public void hello(String message) {
        System.out.println("This is a mock it !!");
    }

}
