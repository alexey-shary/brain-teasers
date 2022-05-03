package com.leetcode.hard;

import java.util.ArrayList;

/**
 * 4. Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> resulting = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                resulting.add(nums1[i++]);
            } else if (nums1[i] == nums2[j]) {
                resulting.add(nums1[i++]);
                resulting.add(nums2[j++]);
            } else {
                resulting.add(nums2[j++]);
            }
        }
        while (i < nums1.length) {
            resulting.add(nums1[i++]);
        }
        while (j < nums2.length) {
            resulting.add(nums2[j++]);
        }
        int midIndex = resulting.size() / 2;
        return resulting.size() % 2 == 1 ? resulting.get(midIndex) : (double) (resulting.get(midIndex) + resulting.get(midIndex - 1)) / 2;
    }
}
