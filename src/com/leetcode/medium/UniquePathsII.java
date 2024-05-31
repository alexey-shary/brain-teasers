package com.leetcode.medium;

/**
 * 63. Unique Paths II
 *
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid.
 * A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1 || obstacleGrid[0][0] == 1) return 0;

        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (int j = i; j < obstacleGrid.length; j++) {
                    obstacleGrid[j][0] = -1;
                }
                break;
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                for (int j = i; j < obstacleGrid[0].length; j++) {
                    obstacleGrid[0][j] = -1;
                }
                break;
            }
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        return uniquePathsWithObstacles(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j) {
        if (obstacleGrid[i][j] == -1) {
            return 0;
        }
        if (i == 0 || j == 0) return 1;
        if (obstacleGrid[i][j] > 0) return obstacleGrid[i][j];
        obstacleGrid[i][j] = uniquePathsWithObstacles(obstacleGrid, i - 1, j) + uniquePathsWithObstacles(obstacleGrid, i, j - 1);
        return obstacleGrid[i][j];
    }
}
