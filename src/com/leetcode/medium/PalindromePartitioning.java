package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partition(String s, int start, List<String> subStrings, List<List<String>> result) {
        if (s.length() == start) {
            result.add(new ArrayList<>(subStrings));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    subStrings.add(s.substring(start, i + 1));
                    partition(s, i + 1, subStrings, result);
                    subStrings.removeLast();
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
