package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateParenthesesTest {
    @Test
    public void testGenerateParenthesis() {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> actual = gp.generateParenthesis(3);
        List<String> expected = Arrays.asList("((()))","(()())","(())()","()(())","()()()");
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
        actual = gp.generateParenthesis(1);
        expected = Arrays.asList("()");
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
        actual = gp.generateParenthesis(2);
        expected = Arrays.asList("()()", "(())");
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
        expected = Arrays.asList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()");
        actual = gp.generateParenthesis(4);
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
    }
}
