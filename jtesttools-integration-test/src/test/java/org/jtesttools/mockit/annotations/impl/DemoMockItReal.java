package org.jtesttools.mockit.annotations.impl;

import org.jtesttools.mockit.annotations.DemoMockIt;

public class DemoMockItReal implements DemoMockIt {

	@Override
	public void hello(String message) {
		System.out.println("Hello " + message);
	}

}
