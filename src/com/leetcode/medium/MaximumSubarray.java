package com.leetcode.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

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

    // Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
    private int maxSubArray(int[] nums, int max) {
        if (nums.length == 1) {
            return nums[0] > max ? nums[0] : max;
        }
        int left = maxSubArray(Arrays.copyOfRange(nums, 0, nums.length - 1), max);
        int right = maxSubArray(Arrays.copyOfRange(nums, 1, nums.length), max);
        int own = Arrays.stream(nums).sum();
        return IntStream.of(left, right, own, max).max().getAsInt();
    }
}
