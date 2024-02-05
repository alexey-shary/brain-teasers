package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        combine(1, k, n, new LinkedList(), result);
        return result;
    }

    private void combine(int start, int limit, int n, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == limit) {
            result.add(new ArrayList(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);
            combine(i + 1, limit, n, combination, result);
            combination.pollLast();
        }
    }
}
