package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToIntegerTest {
    @Test
    public void testRomanToInt() {
        RomanToInteger rti = new RomanToInteger();
        assertEquals(3, rti.romanToInt("III"));
        assertEquals(58, rti.romanToInt("LVIII"));
        assertEquals(1994, rti.romanToInt("MCMXCIV"));
    }
}
