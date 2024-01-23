package com.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class IsAnagramTest {

    @Test
    void testIsAnagram() {
        IsAnagram ia = new IsAnagram();
        assertEquals(true, ia.isAnagram("abc", "cab"));
    }
}