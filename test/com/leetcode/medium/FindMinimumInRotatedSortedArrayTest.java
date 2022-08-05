package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMinimumInRotatedSortedArrayTest {
    @Test
    void testFindMin() {
        FindMinimumInRotatedSortedArray fmirsa = new FindMinimumInRotatedSortedArray();
        assertEquals(1, fmirsa.findMin(new int[]{3,4,5,1,2}));
        assertEquals(0, fmirsa.findMin(new int[]{4,5,6,7,0,1,2}));
        assertEquals(1, fmirsa.findMin(new int[]{2,1}));
        assertEquals(1, fmirsa.findMin(new int[]{1}));
        assertEquals(1, fmirsa.findMin(new int[]{2,3,1}));
        assertEquals(1, fmirsa.findMin(new int[]{5,1,2,3,4}));
        assertEquals(11, fmirsa.findMin(new int[]{11,13,15,17}));
    }
}
