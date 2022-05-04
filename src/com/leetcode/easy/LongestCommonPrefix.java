package com.leetcode.easy;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder("");
        int[] charSet = new int[128];
        int charIndex = 0;
        while (charIndex < strs[0].length()) {
            for (int i = 0; i < strs.length; i++) {
                if (charIndex == strs[i].length()) {
                    break;
                }
                charSet[strs[i].charAt(charIndex)]++;
            }
            if (charSet[strs[0].charAt(charIndex)] == strs.length) {
                charSet[strs[0].charAt(charIndex)] = 0;
                commonPrefix.append(strs[0].charAt(charIndex++));
            } else {
                break;
            }
        }
        return commonPrefix.toString();
    }
}
