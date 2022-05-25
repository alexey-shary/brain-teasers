package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *   - Each row must contain the digits 1-9 without repetition.
 *   - Each column must contain the digits 1-9 without repetition.
 *   - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> alreadySeen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!alreadySeen.add(c + "in row " + i) ||
                            !alreadySeen.add(c + " in column " + j) ||
                            !alreadySeen.add(c + " in square " + (i / 3) + " - " + (j / 3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
