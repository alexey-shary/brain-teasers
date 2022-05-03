package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWaterTest {
    @Test
    public void testMaxArea(){
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        assertEquals(49, cwmw.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(1, cwmw.maxArea(new int[] {1, 1}));
    }
}
