package com.leetcode.hard;

/**
 * 76. Minimum Window Substring
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
 * every character in t (including duplicates) is included in the window.
 *
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freqT = new int[128];
        for (char c: t.toCharArray()) {
            freqT[c]++;
        }

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int counter = t.length();
        String minWindow = "";

        while (right < s.length()) {
            freqT[s.charAt(right)]--;
            if (freqT[s.charAt(right)] >= 0) {
                counter--;
            }
            right++;

            while (counter == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minWindow = s.substring(left, right); // TODO: This slows it down - keep track of startIndex only and do substring on return
                }

                freqT[s.charAt(left)]++;
                if (freqT[s.charAt(left)] > 0) {
                    counter++;
                }
                left++;
            }
        }
        return minWindow;
    }
}
