package com.leetcode.medium;

/**
 * 130. Surrounded Regions
 *
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 *  - Connect: A cell is connected to adjacent cells horizontally or vertically.
 *  - Region: To form a region connect every 'O' cell.
 *  - Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 *
 * A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    markRegionAsNonCapturable(board, i + 1, j);
                    markRegionAsNonCapturable(board, i, j + 1);
                    markRegionAsNonCapturable(board, i - 1, j);
                    markRegionAsNonCapturable(board, i, j - 1);
                }
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markRegionAsNonCapturable(char[][] board, int i, int j) {
        if (i <= 0 || j <= 0 || i >= board.length - 1 || j >= board[0].length - 1 || board[i][j] != 'O') {
            return;
        }
        // Cannot capture this region because it is connected to the edge's 'O'
        board[i][j] = '-';
        markRegionAsNonCapturable(board, i + 1, j);
        markRegionAsNonCapturable(board, i, j + 1);
        markRegionAsNonCapturable(board, i - 1, j);
        markRegionAsNonCapturable(board, i, j - 1);
    }
}
