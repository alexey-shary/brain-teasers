package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void testLengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
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
