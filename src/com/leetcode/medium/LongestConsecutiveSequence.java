package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maxSeq = 0;
        Set<Integer> sequences = new HashSet<>();
        for (int num : nums) {
            sequences.add(num);
        }
        for (int num : nums) {
            int nextInSeq = num + 1;
            int prevInSeq = num - 1;
            int currentSequence = 1;
            while (sequences.remove(prevInSeq--)) {
                currentSequence++;
            }
            while (sequences.remove(nextInSeq++)) {
                currentSequence++;
            }
            if (currentSequence > maxSeq) {
                maxSeq = currentSequence;
            }
        }
        return maxSeq;
    }
}
