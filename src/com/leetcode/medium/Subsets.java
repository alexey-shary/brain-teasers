package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        backtracking(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> working, int[] nums, int index) {
        if (nums.length == index) {
            result.add(new ArrayList<>(working));
            return;
        }
        // For each element we have two choices, either to take in a subset or not - call the recursive method based on these choices
        working.add(nums[index]);
        backtracking(result, working, nums, index + 1);
        working.remove(Integer.valueOf(nums[index]));
        backtracking(result, working, nums, index + 1);
    }
}
