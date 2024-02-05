package com.leetcode.medium;

import java.util.*;

/**
 * 39. Combination Sum
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet();
        for (int i = 0; i < candidates.length; i++) {
            addCandidate(i, candidates, target, new LinkedList(), result);
        }
        return new ArrayList(result);
    }

    private void addCandidate(int i, int[] candidates, int target, LinkedList<Integer> combination, Set<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList(combination));
        } else if (target < 0) {
            return;
        }
        while (i < candidates.length) {
            combination.add(candidates[i]);
            addCandidate(i, candidates, target - candidates[i], combination, result);
            combination.removeLast();
            i++;
        }
    }
}
