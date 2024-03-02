package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int leftColumn = 0, topRow = 0;
        int rightColumn = matrix[0].length - 1;
        int bottomRow = matrix.length - 1;
        while (leftColumn <= rightColumn && topRow <= bottomRow) {
            for (int i = leftColumn; i <= rightColumn; i++) { // going right
                result.add(matrix[topRow][i]);
            }
            topRow++;
            for (int i = topRow; i <= bottomRow; i++) { // going down
                result.add(matrix[i][rightColumn]);
            }
            rightColumn--;
            for (int i = rightColumn; i >= leftColumn && topRow <= bottomRow; i--) { // going left (if there is a row available)
                result.add(matrix[bottomRow][i]);
            }
            bottomRow--;
            for (int i = bottomRow; i >= topRow && leftColumn <= rightColumn; i--) { // going up (if there is a column available)
                result.add(matrix[i][leftColumn]);
            }
            leftColumn++;
        }
        return result;
    }
}
