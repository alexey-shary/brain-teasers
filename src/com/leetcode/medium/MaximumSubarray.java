package com.leetcode.medium;

/**
 * 53. Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int maximumOverall = nums[0];
        int maximumCurrent = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Decide whether include current element to Maximum Subarray or start a new subarray
            if (maximumCurrent + nums[i] < nums[i]) {
                maximumCurrent = nums[i];
            } else {
                maximumCurrent += nums[i];
            }
            if (maximumOverall < maximumCurrent) {
                maximumOverall = maximumCurrent;
            }
        }
        return maximumOverall;
    }
}
