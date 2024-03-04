package com.leetcode.easy;

/**
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 */
public class BalancedBinaryTree {
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return balanced;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if (Math.abs(left - right) > 1) {
            balanced = false;
        }

        return Math.max(left, right) + 1;
    }
}
