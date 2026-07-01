package com.cognizant.module4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void testAssertions() {
        String name = "JUnit";
        String emptyValue = null;
        int total = 2 + 3;

        assertEquals(5, total);
        assertTrue(total > 0);
        assertFalse(total < 0);
        assertNotNull(name);
        assertNull(emptyValue);
    }
}
