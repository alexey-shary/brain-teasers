package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 213. House Robber II
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(Arrays.copyOfRange(nums, 0, nums.length - 1), nums.length - 2, new HashMap<>()),
                        rob(Arrays.copyOfRange(nums, 1, nums.length), nums.length - 2, new HashMap<>()));
    }

    private int rob(int[] nums, int i, Map<Integer, Integer> memo) {
        if (i < 0) {
            return 0;
        }

        if (memo.get(i) == null) {
            memo.put(i, Math.max(nums[i] + rob(nums, i - 2, memo), rob(nums, i - 1, memo)));
        }

        return memo.get(i);
    }
}
