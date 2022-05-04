package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {
    @Test
    public void testLongestCommonPrefix() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        assertEquals("fl", lcp.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        assertEquals("", lcp.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
        assertEquals("a", lcp.longestCommonPrefix(new String[] {"ab", "a"}));
        assertEquals("aa", lcp.longestCommonPrefix(new String[] {"aa", "aa"}));
    }
}
