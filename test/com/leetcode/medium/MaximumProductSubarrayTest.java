package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductSubarrayTest {
    @Test
    void testMaxProduct() {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        assertEquals(6, mps.maxProduct(new int[]{2,3,-2,4}));
        assertEquals(0, mps.maxProduct(new int[]{-2,0,-1}));
        assertEquals(24, mps.maxProduct(new int[]{-2,3,-4}));
        assertEquals(12, mps.maxProduct(new int[]{-2,3,4}));
        assertEquals(3, mps.maxProduct(new int[]{-2,3,0,-4}));
        assertEquals(0, mps.maxProduct(new int[]{0,0,0,0,0}));
    }
}
