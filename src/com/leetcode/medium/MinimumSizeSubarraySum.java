package com.leetcode.medium;

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 *
 * If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = 0, sum = 0;
        int minLength = nums.length + 1;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= target) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == nums.length + 1 ? 0 : minLength;
    }
}
