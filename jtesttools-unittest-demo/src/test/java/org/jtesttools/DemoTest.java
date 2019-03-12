package org.jtesttools;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DemoTest {

    @Test
    public void sum() {
        Demo demo = new Demo();
        Assertions.assertThat(demo.sum(1, 2)).isEqualTo(3);
    }
}
