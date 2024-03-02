package com.leetcode.medium;

import java.util.Set;
import java.util.HashSet;

/**
 * 73. Set Matrix Zeroes
 *
 * Given an m x n integer matrix `matrix`, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 * Follow up:
 * - A straightforward solution using O(mn) space is probably a bad idea.
 * - A simple improvement uses O(m + n) space, but still not the best solution.
 * - Could you devise a constant space solution?
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
