package com.leetcode.medium;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
    private final Map<Integer, List<Integer>> levels = new TreeMap();

    public List<List<Integer>> levelOrder(TreeNode root) {
        treeLevels(root, 1);
        return new ArrayList<>(levels.values());
    }

    private void treeLevels(TreeNode node, int level) {
        if (node == null) return;

        levels.computeIfAbsent(level, n -> new ArrayList<>()).add(node.val);

        treeLevels(node.left, level + 1);
        treeLevels(node.right, level + 1);
    }
}
