package com.leetcode.medium;

/**
 * 45. Jump Game II
 *
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *   1) 0 <= j <= nums[i] and
 *   2) i + j < n
 *
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int[] dP = new int[nums.length];
        dP[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    if (dP[i] == 0) {
                        dP[i] = dP[j] + 1;
                    } else {
                        dP[i] = Math.min(dP[j] + 1, dP[i]);
                    }
                }
            }
        }
        return dP[nums.length - 1];
    }
}
