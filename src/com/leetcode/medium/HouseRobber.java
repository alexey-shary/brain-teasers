package com.leetcode.medium;

import java.util.*;

/**
 * 198. House Robber
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected, and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    private final Map<Integer, Integer> memo = new HashMap<>();

    /**
     * TODO: Step 1. Figure out recursive relation.
     * A robber has 2 options: a) rob current house i; b) don't rob current house.
     * If an option "a" is selected it means he can't rob previous i-1 house but can safely proceed to the one before previous i-2 and gets all cumulative loot that follows.
     * If an option "b" is selected the robber gets all the possible loot from robbery of i-1 and all the following buildings.
     * So it boils down to calculating what is more profitable:
     *  - robbery of current house + loot from houses before the previous
     *  - loot from the previous house robbery and any loot captured before that
     */
    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

        if (memo.get(i) == null) {
            memo.put(i, Math.max(nums[i] + rob(nums, i - 2), rob(nums, i - 1)));
        }

        return memo.get(i);
    }
}
