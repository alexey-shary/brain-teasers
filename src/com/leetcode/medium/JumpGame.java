package com.leetcode.medium;

/**
 * 55. Jump Game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastReachableIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastReachableIndex) {
                lastReachableIndex = i;
            }
        }
        return lastReachableIndex == 0;
    }
}
