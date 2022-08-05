package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {
    @Test
    void testMaxSubArray() {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        assertEquals(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6); // [4,-1,2,1] has the largest sum = 6
        assertEquals(maximumSubarray.maxSubArray(new int[]{ 1 }), 1);
        assertEquals(maximumSubarray.maxSubArray(new int[]{ 5, 4, -1, 7, 8 }), 23);
    }
}