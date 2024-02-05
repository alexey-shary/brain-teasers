package com.leetcode.easy;

/**
 * 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] sChars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        for (int i = 0; i < sChars.length / 2; i++) {
            if (sChars[i] != sChars[sChars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
