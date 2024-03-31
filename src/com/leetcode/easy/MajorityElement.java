package com.leetcode.easy;

/**
 * 169. Majority Element
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        // Moore Voting Algorithm - https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
        int candidate = 0, count = 0;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
