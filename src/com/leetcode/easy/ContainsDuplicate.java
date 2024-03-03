package com.leetcode.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 217. Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> result = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return result.size() != nums.length;
    }

    /*
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinctValues = new HashSet<Integer>();
        for (int n: nums) {
            if (!distinctValues.add(n)) return true;
        }
        return false;
    }
    */
}
