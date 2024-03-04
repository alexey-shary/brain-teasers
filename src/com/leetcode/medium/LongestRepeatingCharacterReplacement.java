package com.leetcode.medium;

/**
 * 424. Longest Repeating Character Replacement
 *
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] frequencies = new int[128];
        int left = 0, maxFrequency = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentLetter = s.charAt(right);
            frequencies[currentLetter]++;
            maxFrequency = Math.max(maxFrequency, frequencies[currentLetter]); // maximum count of the same letter in the current sliding window, e.g. AABABBA ---> 4 ('A')
            int currentLength = right - left + 1; // length of the current sliding window, e.g. AABABBA ---> 7
            int lettersToBeReplaced = currentLength - maxFrequency; // e.g. AABABBA ---> 3
            if (lettersToBeReplaced > k) {
                char leftLetter = s.charAt(left);
                frequencies[leftLetter]--; // reduce the frequency for that letter because window is sliding from the left
                left++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
