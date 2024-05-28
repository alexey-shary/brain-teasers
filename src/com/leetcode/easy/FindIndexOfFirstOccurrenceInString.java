package com.leetcode.easy;

/**
 * 28. Find the Index of the First Occurrence in a String
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class FindIndexOfFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean fullMatch = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                        fullMatch = false;
                        break;
                    }
                }
                if (fullMatch) {
                    return i;
                }
            }
        }
        return -1;
    }

    // TODO: there is also KMP (Knuth Morris Pratt) pattern searching algorithm
    //  (https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/12956/c-brute-force-and-kmp/)
    //  https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
}