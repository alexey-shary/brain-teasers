package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 *
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexes.containsKey(nums[i]) && Math.abs(indexes.get(nums[i]) - i) <= k) {
                return true;
            }
            indexes.put(nums[i], i);
        }
        return false;
    }
}
