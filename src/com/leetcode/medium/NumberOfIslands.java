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
                if (grid[i][j] == '1' && !islands.contains(i + "," + j)) {
                    numberOfIslands++;
                    exploreIsland(grid, i, j, islands);
                }
            }
        }
        return numberOfIslands;
    }

    private void exploreIsland(char[][] grid, int i, int j, Set<String> islands) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || islands.contains(i + "," + j) || grid[i][j] != '1') {
            return;
        }

        islands.add(i + "," + j); // TODO: can mark visited square as '0' or '#' but it will change input grid

        exploreIsland(grid, i + 1, j, islands);
        exploreIsland(grid, i - 1, j, islands);
        exploreIsland(grid, i, j + 1, islands);
        exploreIsland(grid, i, j - 1, islands);
    }
}
