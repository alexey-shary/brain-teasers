package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();

        int[] freq = new int[128];
        int[] currentFreq = new int[128];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i)]++;
            currentFreq[s.charAt(i)]++;
        }

        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(freq, currentFreq)) {
            result.add(0);
        }
        for (int i = 0; i + p.length() < s.length(); i++) {
            // Sliding window
            currentFreq[s.charAt(i)]--;
            currentFreq[s.charAt(i + p.length())]++;

            if (Arrays.equals(freq, currentFreq)) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
