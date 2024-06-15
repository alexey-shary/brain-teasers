package com.leetcode.medium;

/**
 * 1448. Count Good Nodes in Binary Tree
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X
 * there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 */
public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
    }

    private int goodNodes(TreeNode node, int max) {
        if (node == null) return 0;

        int counter = 0;
        if (node.val >= max) {
            max = node.val;
            counter++;
        }

        return counter + goodNodes(node.left, max) + goodNodes(node.right, max);
    }
}
