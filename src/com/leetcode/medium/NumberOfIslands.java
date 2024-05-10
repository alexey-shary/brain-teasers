package com.leetcode.medium;

import java.util.Set;
import java.util.HashSet;

/**
 * 200. Number of Islands
 *
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    if (!islands.contains(i + "," + j)) {
                        numberOfIslands++;
                        islands.add(i + "," + j);
                        exploreIsland(grid, i, j, islands);
                    }
                }
            }
        }
        return numberOfIslands;
    }

    private void exploreIsland(char[][] grid, int i, int j, Set<String> islands) {
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && islands.add((i + 1) + "," + j)) {
            exploreIsland(grid, i + 1, j, islands);
        }
        if (0 < i && grid[i - 1][j] == '1' && islands.add((i - 1) + "," + j)) {
            exploreIsland(grid, i - 1, j, islands);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && islands.add(i + "," + (j + 1))) {
            exploreIsland(grid, i, j + 1, islands);
        }
        if (0 < j && grid[i][j - 1] == '1' && islands.add(i + "," + (j - 1))) {
            exploreIsland(grid, i, j - 1, islands);
        }
    }
}
