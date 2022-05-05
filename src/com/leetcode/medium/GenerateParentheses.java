package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * TODO: Explore https://en.wikipedia.org/wiki/Backtracking and https://en.wikipedia.org/wiki/Heap%27s_algorithm
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, n);
        return result;
    }

    private void generateParenthesis(List<String> result, String working, int left, int right) {
        if (left > right) {
            return;
        }
        if (left > 0) {
            generateParenthesis(result, working + "(", left - 1, right);
        }
        if (right > 0) {
            generateParenthesis(result, working + ")", left, right - 1);
        }
        if (left == 0 && right == 0) {
            result.add(working);
        }
    }
}
