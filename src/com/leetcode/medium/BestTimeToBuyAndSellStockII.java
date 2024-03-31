package com.leetcode.medium;

/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int bought, sold;
        for (int i = 0; i < prices.length - 1; i++) {
            while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            bought = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            sold = prices[i];
            profit += sold - bought;
        }
        return profit;
    }
}
