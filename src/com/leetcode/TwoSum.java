package com.leetcode;

import java.util.HashMap;

/**
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        /* O(n^2) complexity
        boolean found = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }*/

        // O(n) complexity
        HashMap<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (indexes.containsKey(remainder)) {
                answer[0] = indexes.get(remainder);
                answer[1] = i;
                break;
            }
            indexes.put(nums[i], i);
        }

        return answer;
    }
}
