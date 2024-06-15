package com.leetcode.medium;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
    // BFS approach
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                currentLevel.add(node.val);
            }
            result.add(currentLevel);
        }
        return result;
    }

    // DFS approach
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> levels = new TreeMap<>();
        treeLevels(root, levels, 1);
        return new ArrayList<>(levels.values());
    }

    private void treeLevels(TreeNode node, Map<Integer, List<Integer>> levels, int level) {
        if (node == null) return;

        levels.computeIfAbsent(level, n -> new ArrayList<>()).add(node.val);

        treeLevels(node.left, levels, level + 1);
        treeLevels(node.right, levels, level + 1);
    }
    */
}
