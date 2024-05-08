package com.leetcode.medium;

/**
 * 11. Container With Most Water
 *
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int mostWater = 0;

        /* O(n^2) complexity
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = height[i] < height[j] ? height[i] : height[j];
                if (mostWater < (j - i) * minHeight) {
                    mostWater = (j - i) * minHeight;
                }
            }
        }*/

        // O(n) complexity
        int i = 0, j = height.length - 1;
        while (i < j) {
            int water = (j - i) * Math.min(height[i], height[j]);
            if (water > mostWater) {
                mostWater = water;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return mostWater;
    }
}
