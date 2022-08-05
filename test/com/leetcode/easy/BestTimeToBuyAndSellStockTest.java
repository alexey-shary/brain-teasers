package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockTest {
    @Test
    void testMaxProfit() {
        BestTimeToBuyAndSellStock bttbass = new BestTimeToBuyAndSellStock();
        assertEquals(5, bttbass.maxProfit(new int[] {7,1,5,3,6,4}));
        assertEquals(0, bttbass.maxProfit(new int[] {7,6,4,3,1}));
        assertEquals(8, bttbass.maxProfit(new int[] {5,2,10,1,8}));
    }
}
