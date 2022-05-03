package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {
    @Test
    void testTwoSum() {
        TwoSum twoSum = new TwoSum();
        assertArrayEquals(twoSum.twoSum(new int[] {2, 7, 11, 15}, 9), new int[] {0, 1});
        assertArrayEquals(twoSum.twoSum(new int[] {3, 2, 4}, 6), new int[] {1, 2});
        assertArrayEquals(twoSum.twoSum(new int[] {3, 3}, 6), new int[] {0, 1});
    }
}
