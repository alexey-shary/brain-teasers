package com.leetcode.easy;

/**
 * 100. Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) return false;
        if (p == null && q == null) return true;

        boolean same = false;
        if (p.val == q.val) {
            same = isSameTree(p.left, q.left);
            if (!same) return false;
            same = isSameTree(p.right, q.right);
        }
        return same;
    }
}
