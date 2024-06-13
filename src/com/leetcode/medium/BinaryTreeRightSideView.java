package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        rightSideView(root, rightSide, 0);
        return rightSide;

        // TODO: BFS using iterative approach, i.e. queue and for loop
    }

    private void rightSideView(TreeNode node, List<Integer> rightSide, int level) {
        if (node == null) return;

        if (level == rightSide.size()) {
            rightSide.add(node.val);
        }

        rightSideView(node.right, rightSide, level + 1);
        rightSideView(node.left, rightSide, level + 1);
    }
}
