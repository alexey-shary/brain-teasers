package com.leetcode.easy;

/**
 * 572. Subtree of Another Tree
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree `tree` is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        boolean result = false;
        if (root.val == subRoot.val) {
            result = checkSubtree(root.left, subRoot.left) && checkSubtree(root.right, subRoot.right);
        }
        return result ? result : isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean checkSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return checkSubtree(root.left, subRoot.left) && checkSubtree(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
