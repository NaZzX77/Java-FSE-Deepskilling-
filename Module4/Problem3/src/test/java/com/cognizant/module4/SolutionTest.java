package com.cognizant.module4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    private Solution calculator;

    @Before
    public void setUp() {
        calculator = new Solution();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAddUsingAaaPattern() {
        int firstNumber = 10;
        int secondNumber = 5;

        int result = calculator.add(firstNumber, secondNumber);

        assertEquals(15, result);
    }

    @Test
    public void testMultiplyUsingAaaPattern() {
        int firstNumber = 4;
        int secondNumber = 3;

        int result = calculator.multiply(firstNumber, secondNumber);

        assertEquals(12, result);
    }
}
