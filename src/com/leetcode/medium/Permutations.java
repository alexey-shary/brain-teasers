package com.leetcode.medium;

import java.util.*;

/**
 * 46. Permutations
 *
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permute(result, nums, nums.length);
        return result;
    }

    private void permute(List<List<Integer>> result, int[] nums, int size) {
        if (size == 1) {
            result.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        permute(result, nums, size - 1);

        for (int i = 0; i < size - 1; i++) {
            if (size % 2 == 0) {
                int buff = nums[i];
                nums[i] = nums[size - 1];
                nums[size - 1] = buff;
            } else {
                int buff = nums[0];
                nums[0] = nums[size - 1];
                nums[size - 1] = buff;
            }
            permute(result, nums, size - 1);
        }
    }
}
