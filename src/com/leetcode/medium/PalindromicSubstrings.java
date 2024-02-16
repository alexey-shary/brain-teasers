package com.leetcode.medium;

/**
 * 647. Palindromic Substrings
 *
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += countPalindromes(s, i, i); // potential palindrome of odd length
            result += countPalindromes(s, i, i + 1); // potential palindrome of even length
        }
        return result;
    }

    private int countPalindromes(String s, int left, int right) { // Approach: Expand From Centers
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
