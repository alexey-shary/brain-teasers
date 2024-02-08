package com.leetcode.medium;

import java.util.*;

/**
 * 322. Coin Change
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int min = coinChange(coins, amount, new HashMap());
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.get(amount) != null) return memo.get(amount);
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }

        int minimum = Integer.MAX_VALUE;

        for (int coin : coins) {
            int numberOfCoins = coinChange(coins, amount - coin, memo) + 1;
            if (0 < numberOfCoins && numberOfCoins < minimum) {
                minimum = numberOfCoins;
            }
        }

        memo.put(amount, minimum);
        return minimum;
    }
}
