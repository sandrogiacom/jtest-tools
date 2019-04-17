package org.jtesttools.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalcDemoTest {

    @Test
    void whenMultiplyingThenCheckResult() {
        //Given
        CalcDemo calc = new CalcDemo();

        //When
        double result = calc.multiply(4, 5);

        //Then
        assertThat(result).isEqualTo(20);
    }

    @Test
    void sub() {
        CalcDemo calc = new CalcDemo();
        assertThat(calc.sub(30, 2)).isEqualTo(28);
    }

    @Test
    void div() {
        CalcDemo calc = new CalcDemo();
        assertThat(calc.div(9, 3)).isEqualTo(3);
    }

    @Test
    void sum() {
        CalcDemo calc = new CalcDemo();
        assertThat(calc.sum(1, 2)).isEqualTo(3);
    }
}
