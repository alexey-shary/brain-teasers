package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 746. Min Cost Climbing Stairs
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost, cost.length, new HashMap<>());
    }

    private int minCostClimbingStairs(int[] cost, int n, Map<Integer, Integer> memo) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return cost[n];
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int costOneStep = minCostClimbingStairs(cost, n - 1, memo);
        int costTwoSteps = minCostClimbingStairs(cost, n - 2, memo);
        int minCost = Math.min(costOneStep, costTwoSteps);
        if (n < cost.length) {
            minCost += cost[n];
        }
        memo.put(n, minCost);

        return minCost;
    }
}
