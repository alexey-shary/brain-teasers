package com.leetcode.medium;

/**
 * 48. Rotate Image
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 1) return;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                int top = matrix[i][j];
                int right = matrix[j][matrix.length - i - 1];
                int bottom = matrix[matrix.length - i - 1][matrix.length - j - 1];
                int left = matrix[matrix.length - j - 1][i];

                matrix[i][j] = left;
                matrix[j][matrix.length - i - 1] = top;
                matrix[matrix.length - i - 1][matrix.length - j - 1] = right;
                matrix[matrix.length - j - 1][i] = bottom;
            }
        }
    }

    /*
    public void rotate(int[][] matrix) {
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int end = matrix.length - 1 - layer;
            for (int i = layer; i < end; i++) {
                int offset = i - layer;
                int top = matrix[layer][i];
                // left -> top
                matrix[layer][i] = matrix[end - offset][layer];
                // bottom -> left
                matrix[end - offset][layer] = matrix[end][end - offset];
                // right -> bottom
                matrix[end][end - offset] = matrix[i][end];
                // top -> right
                matrix[i][end] = top;
            }
        }
    }
    */
}
