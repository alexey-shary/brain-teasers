package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringTest {
    @Test
    public void testLengthOfLongestSubstring() {
        LongestSubstring ls = new LongestSubstring();
        assertEquals(ls.lengthOfLongestSubstring("abcabcbb"), 3);
        assertEquals(ls.lengthOfLongestSubstring("bbbbb"), 1);
        assertEquals(ls.lengthOfLongestSubstring("pwwkew"), 3);
        assertEquals(ls.lengthOfLongestSubstring("abcdefg"), 7);
        assertEquals(ls.lengthOfLongestSubstring(""), 0);
        assertEquals(ls.lengthOfLongestSubstring("abedeba"), 4);
        assertEquals(ls.lengthOfLongestSubstring("abcdeba"), 5);
        assertEquals(ls.lengthOfLongestSubstring("aab"), 2);
    }
}
