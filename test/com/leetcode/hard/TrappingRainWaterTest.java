package com.leetcode.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrappingRainWaterTest {
    @Test
    public void testTrap() {
        TrappingRainWater trw = new TrappingRainWater();
        assertEquals(6, trw.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(1, trw.trap(new int[] {4,2,3}));
    }
}
