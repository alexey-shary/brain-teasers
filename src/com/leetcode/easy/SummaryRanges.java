package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 *
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        boolean single = true;
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (single) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
                single = true;
            } else {
                single = false;
            }
        }
        if (start != nums[nums.length - 1]) {
            result.add(start + "->" + nums[nums.length - 1]);
        } else {
            result.add(String.valueOf(start));
        }
        return result;
    }
}
