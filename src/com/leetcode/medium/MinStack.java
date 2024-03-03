package com.leetcode.medium;

import java.util.Stack;

/**
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *  - MinStack() initializes the stack object.
 *  - void push(int val) pushes the element val onto the stack.
 *  - void pop() removes the element on the top of the stack.
 *  - int top() gets the top element of the stack.
 *  - int getMin() retrieves the minimum element in the stack.
 *
 * You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
    private static class Entry {
        int value;
        int min;
    }

    private final Stack<Entry> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }

    public void push(int val) {
        Entry e = new Entry();
        e.value = val;
        if (minStack.isEmpty()) {
            e.min = val;
        } else {
            e.min = Math.min(val, minStack.peek().min);
        }
        minStack.push(e);
    }

    public void pop() {
        minStack.pop();
    }

    public int top() {
        return minStack.peek().value;
    }

    public int getMin() {
        return minStack.peek().min;
    }
}
