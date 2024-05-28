package com.leetcode.easy;

import java.util.LinkedList;

/**
 * 101. Symmetric Tree
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class SymmetricTree {
    // TODO: Iterative solution
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> tree = new LinkedList<>();
        tree.offer(root.left);
        tree.offer(root.right);
        while (!tree.isEmpty()) {
            TreeNode left = tree.poll();
            TreeNode right = tree.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            tree.offer(left.left);
            tree.offer(right.right);
            tree.offer(left.right);
            tree.offer(right.left);
        }
        return true;

        // return isSymmetric(root.left, root.right);
    }

    // TODO: Recursive solution
    // public boolean isSymmetric(TreeNode root) {
        // return isSymmetric(root.left, root.right);
    // }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null || left.val != right.val) return false;

        boolean result = isSymmetric(left.left, right.right);
        if (!result) return false;
        return isSymmetric(left.right, right.left);
    }
}
