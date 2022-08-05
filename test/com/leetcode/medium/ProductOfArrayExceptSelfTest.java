package com.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductOfArrayExceptSelfTest {
    @Test
    void testProductExceptSelf() {
        ProductOfArrayExceptSelf poaes = new ProductOfArrayExceptSelf();
        Assertions.assertArrayEquals(new int[]{24,12,8,6}, poaes.productExceptSelf(new int[]{1,2,3,4}));
        Assertions.assertArrayEquals(new int[]{0,0,9,0,0}, poaes.productExceptSelf(new int[]{-1,1,0,-3,3}));
    }
}
