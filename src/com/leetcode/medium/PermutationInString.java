package com.leetcode.medium;

/**
 * 567. Permutation in String
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[128];
        for (char c: s1.toCharArray()) {
            freq[c]++;
        }
        int left = 0, right = 0;
        while (right < s2.length()) {
            freq[s2.charAt(right)]--;
            while (freq[s2.charAt(right)] < 0) {
                freq[s2.charAt(left)]++;
                left++;
            }
            if (right - left + 1 == s1.length()) {
                return true;
            }
            right++;
        }
        return false;
    }
}
