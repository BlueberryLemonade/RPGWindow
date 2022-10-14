package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void isInteger() {

        assertTrue(Utilities.isInteger("3"));
        assertFalse(Utilities.isInteger("d"));
        assertFalse(Utilities.isInteger(" "));
    }

    @Test
    public void isValidStringWithSpaces() {
        assertTrue(Utilities.isValidStringWithSpaces("The Dragon"));
        assertTrue(Utilities.isValidStringWithSpaces("Dragon"));
        assertFalse(Utilities.isValidStringWithSpaces("The 6th Dragon"));
    }
}