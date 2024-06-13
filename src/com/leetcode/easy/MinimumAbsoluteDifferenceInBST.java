package com.leetcode.easy;

/**
 * 530. Minimum Absolute Difference in BST
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference
 * between the values of any two different nodes in the tree.
 */
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        int[] result = new int[] {-1, Integer.MAX_VALUE}; // keeping previous value and minimum difference
        getMinimumDifference(root, result);
        return result[1];
    }

    private void getMinimumDifference(TreeNode root, int[] result) {
        if (root == null) return;

        getMinimumDifference(root.left, result);

        if (result[0] != -1) {
            result[1] = Math.min(result[1], root.val - result[0]);
        }
        result[0] = root.val;

        getMinimumDifference(root.right, result);
    }
}
