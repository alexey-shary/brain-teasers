package com.leetcode;

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastCharacterPosition = new HashMap<>();
        int max = 0;
        int maxLengthCounter = 0;
        int lastDuplicatePosition = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer lastPosition = lastCharacterPosition.get(c);
            if (lastPosition != null) {
                if (maxLengthCounter > max) {
                   max = maxLengthCounter;
                }
                if (lastPosition < lastDuplicatePosition) {
                    maxLengthCounter++;
                } else {
                    maxLengthCounter = i - lastPosition;
                    lastDuplicatePosition = lastPosition;
                }
            } else {
                maxLengthCounter++;
            }
            lastCharacterPosition.put(c, i);
        }
        if (maxLengthCounter > max) {
            max = maxLengthCounter;
        }
        return max;
    }
}
