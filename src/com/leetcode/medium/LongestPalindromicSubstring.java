package com.leetcode.medium;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] palindromes = new boolean[n][n];
        int[] result = new int[]{0, 0};

        for (int i = 0; i < n; i++) {
            palindromes[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindromes[i][i + 1] = true;
                result[0] = i;
                result[1] = i + 1;
            }
        }

        for (int length = 2; length < n; length++) {
            for (int i = 0; i < n - length; i++) {
                int j = i + length;
                if (s.charAt(i) == s.charAt(j) && palindromes[i + 1][j - 1] == true) { // Approach: Dynamic Programming (tabulation)
                    palindromes[i][j] = true;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return s.substring(result[0], result[1] + 1);
    }
}
