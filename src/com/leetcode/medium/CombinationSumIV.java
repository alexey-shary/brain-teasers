package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 377. Combination Sum IV
 *
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, new HashMap());
    }

    private int combinationSum4(int[] nums, int target, Map<Integer, Integer> memo) {
        if (target == 0) return 1;
        if (target < 0) return 0;

        if (memo.get(target) != null) return memo.get(target);
        int combinations = 0;
        for (int i = 0; i < nums.length; i++) {
            combinations += combinationSum4(nums, target - nums[i], memo);
        }

        memo.put(target, combinations);
        return combinations;
    }
}
