package com.leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfTwoSortedArraysTest {
    @Test
    public void testFindMedianSortedArrays() {
        MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
        assertEquals(2d, motsa.findMedianSortedArrays(new int[] {1, 3}, new int[] { 2 }));
        assertEquals(2.5d, motsa.findMedianSortedArrays(new int[] {1, 2}, new int[] { 3, 4 }));
    }
}
