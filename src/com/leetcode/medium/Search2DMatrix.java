package com.leetcode.medium;

/**
 * 74. Search a 2D Matrix
 *
 * You are given an m x n integer matrix `matrix` with the following two properties:
 *  - Each row is sorted in non-decreasing order.
 *  - The first integer of each row is greater than the last integer of the previous row.
 *  - Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top < down) {
            int middle = top + (down - top) / 2; // doing in that way, to handle overflow instead of (top + down) / 2
            if (matrix[middle][0] == target || matrix[middle][right] == target) return true;

            if (matrix[middle][0] > target) {
                down = middle - 1;
            } else if (matrix[middle][right] > target) {
                top = down = middle;
            } else {
                top = middle + 1;
            }
        }
        while (left <= right) {
            int middle = left + (right - left) / 2; // doing in that way, to handle overflow instead of (left + right) / 2
            if (matrix[top][middle] == target) return true;

            if (matrix[top][middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }
}
