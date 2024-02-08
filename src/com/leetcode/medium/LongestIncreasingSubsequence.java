package com.leetcode.medium;

import java.util.*;

/**
 * 300. Longest Increasing Subsequence
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */
public class LongestIncreasingSubsequence {

    // TODO: Top-Down approach with Memoization
    public int lengthOfLIS(int[] nums) {
        int[] dP = new int[nums.length];
        Arrays.fill(dP, -1);
        return lengthOfLIS(nums, 0, -1, dP);
    }

    private int lengthOfLIS(int[] nums, int i, int previousIndex, int[] dP) {
        if (i >= nums.length) return 0;

        if (dP[previousIndex + 1] != -1) return dP[previousIndex + 1];

        // Two choices - pick the current element for a subsequence or not to pick it
        int pick = 0;
        int notPick = lengthOfLIS(nums, i + 1, previousIndex, dP);
        if (previousIndex == -1 || nums[i] > nums[previousIndex]) {
            pick = lengthOfLIS(nums, i + 1, i, dP) + 1;
        }
        int max = Math.max(pick, notPick);
        dP[previousIndex + 1] = max;
        return max;
    }

    // TODO: Iterative approach with Tabulation
    /*
    public int lengthOfLIS(int[] nums) {
        int[] dP = new int[nums.length];
        Arrays.fill(dP, 1);
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int length = dP[j] + 1;
                    if (length > dP[i]) {
                        dP[i] = length;
                    }
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }
        return maxLength;
    }
     */
}
