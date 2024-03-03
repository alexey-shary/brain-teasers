package com.leetcode.easy;

import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *   - Open brackets must be closed by the same type of brackets.
 *   - Open brackets must be closed in the correct order.
 *
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        Map<Character, Character> openClosed = Map.of('(', ')', '[', ']', '{', '}');
        for (char c: s.toCharArray()) {
            if (openClosed.containsKey(c)) {
                parentheses.push(c);
            } else {
                if (parentheses.isEmpty()) {
                    return false;
                }
                char p = parentheses.pop();
                if (openClosed.get(p) == null || openClosed.get(p) != c) {
                    return false;
                }
            }
        }
        return parentheses.isEmpty();
    }

    /*
    private static final String OPENING_PARENTHESES = "({[";
    private String CLOSING_PARENTHESES = ")}]";

    public boolean isValid(String s) {
        if (s == null || s.length() < 2) return false;
        Stack<Character> parentheses = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (OPENING_PARENTHESES.contains(String.valueOf(c))) {
                parentheses.push(c);
            } else if (parentheses.isEmpty() || (OPENING_PARENTHESES.indexOf(String.valueOf(parentheses.pop())) != CLOSING_PARENTHESES.indexOf(String.valueOf(c)))) {
                return false;
            }
        }
        return parentheses.isEmpty() ? true : false;
    }
    */
}
