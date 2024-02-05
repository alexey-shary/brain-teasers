package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        subsetsWithDup(0, nums, new ArrayList(), result);
        return result;
    }

    private void subsetsWithDup(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList(current));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            subsetsWithDup(i + 1, nums, current, result);
            current.removeLast();
        }
    }
}
