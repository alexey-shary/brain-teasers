package com.leetcode.medium;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *   - The left subtree of a node contains only nodes with keys less than the node's key.
 *   - The right subtree of a node contains only nodes with keys greater than the node's key.
 *   - Both the left and right subtrees must also be binary search trees.
 *
 * NOTE FROM MYSELF - DUPLICATES ARE NOT ALLOWED IN THIS CASE!
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // Iterative solution
        /*
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
        */

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) { // duplicates are not allowed
            return false;
        }

        if (!isValidBST(node.left, min, node.val) || !isValidBST(node.right, node.val, max)) {
            return false;
        }

        return true;
    }

    /*
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
    */
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}