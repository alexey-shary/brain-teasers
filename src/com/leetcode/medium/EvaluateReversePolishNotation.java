package com.leetcode.medium;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *  - The valid operators are '+', '-', '*', and '/'.
 *  - Each operand may be an integer or another expression.
 *  - The division between two integers always truncates toward zero.
 *  - There will not be any division by zero.
 *  - The input represents a valid arithmetic expression in a reverse polish notation.
 *  - The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String t: tokens) {
            switch (t) {
                case "+":
                    numbers.push(numbers.pop() + numbers.pop());
                    break;
                case "-":
                    numbers.push(-numbers.pop() + numbers.pop());
                    break;
                case "*":
                    numbers.push(numbers.pop() * numbers.pop());
                    break;
                case "/":
                    int second = numbers.pop();
                    numbers.push(numbers.pop() / second);
                    break;
                default:
                    numbers.push(Integer.valueOf(t));
            }
        }
        return numbers.pop();
    }
}
