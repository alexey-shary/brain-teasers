package com.leetcode.medium;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {
    // TODO: Approach - expand around center
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String longestPalindrome = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String oddLengthPalindrome = expandAroundCenter(s, i, i, longestPalindrome);
            String evenLengthPalindrome = expandAroundCenter(s, i, i + 1, longestPalindrome);

            if (oddLengthPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = oddLengthPalindrome;
            }
            if (evenLengthPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = evenLengthPalindrome;
            }
        }

        return longestPalindrome;
    }

    private String expandAroundCenter(String s, int left, int right, String longestPalindrome) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    /* TODO: Approach - Dynamic Programming (tabulation)
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
                if (s.charAt(i) == s.charAt(j) && palindromes[i + 1][j - 1] == true) {
                    palindromes[i][j] = true;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return s.substring(result[0], result[1] + 1);
    }
    */
}
