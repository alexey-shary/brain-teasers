package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    private static final Map<Integer, Integer> memo = new HashMap();

    static {
        memo.put(1, 1);
        memo.put(2, 2);
    }

    public int climbStairs(int n) {
        if (memo.get(n) == null) {
            memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return memo.get(n);
    }
}
