package com.leetcode.medium;

/**
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int maxProductOverall = nums[0];
        int currentMaxProduct = nums[0];
        int currentMinProduct = nums[0]; // Need to keep it because negative * negative can be positive maximum
        for (int i = 1; i < nums.length; i++) {
            int temp = currentMaxProduct;
            currentMaxProduct = Math.max(Math.max(currentMaxProduct * nums[i], currentMinProduct * nums[i]), nums[i]);
            currentMinProduct = Math.min(Math.min(temp * nums[i], currentMinProduct * nums[i]), nums[i]);

            if (maxProductOverall < currentMaxProduct) {
                maxProductOverall = currentMaxProduct;
            }
        }
        return maxProductOverall;
    }
}
