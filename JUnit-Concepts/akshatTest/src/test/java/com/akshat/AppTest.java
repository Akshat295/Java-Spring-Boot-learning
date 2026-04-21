package com.akshat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testAddition() {
        App calc = new App();
        assertEquals(5, calc.add(2,3));
    }

    @Test
    void testSubtraction() {
        App calc = new App();
        assertEquals(1, calc.subtract(3,2));
    }

    @Test
    void testMultiplication() {
        App calc = new App();
        assertEquals(6, calc.multiply(2,3));
    }
}