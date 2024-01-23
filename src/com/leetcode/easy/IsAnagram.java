package com.leetcode.easy;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        for (int i = 0; i < s.length(); i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true; // or return Arrays.equals(sChars, tChars)
    }
}