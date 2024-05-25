package com.leetcode.medium;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class ConstructBinaryTreeFromPreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);

        int nodeIndexInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                nodeIndexInorder = i;
            }
        }

        node.left = buildTree(preStart + 1, inStart, nodeIndexInorder - 1, preorder, inorder);
        node.right = buildTree(preStart + nodeIndexInorder - inStart + 1, nodeIndexInorder + 1, inEnd, preorder, inorder);

        return node;
    }
}
