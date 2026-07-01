package com.cognizant.module4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testMessage() {
        Solution solution = new Solution();

        assertEquals("JUnit is ready", solution.message());
    }
}
