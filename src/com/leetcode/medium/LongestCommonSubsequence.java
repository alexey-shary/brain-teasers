package com.leetcode.medium;

/**
 * 1143. Longest Common Subsequence
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] commonMaxLength = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    commonMaxLength[i + 1][j + 1] = commonMaxLength[i][j] + 1;
                } else {
                    commonMaxLength[i + 1][j + 1] = Math.max(commonMaxLength[i + 1][j], commonMaxLength[i][j + 1]);
                }
            }
        }
        return commonMaxLength[text1.length()][text2.length()];
    }
}
