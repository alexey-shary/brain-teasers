package com.leetcode.easy;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return addArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode addArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int middle = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = addArrayToBST(nums, start, middle - 1);
        node.right = addArrayToBST(nums, middle + 1, end);

        return node;
    }
}
