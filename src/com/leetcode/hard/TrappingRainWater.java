package com.leetcode.hard;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int result = 0, tempResult = 0;
        int start = 0, end = 1;
        while (end < height.length) {
            if (height[start] <= height[end]) {
                start = end;
                result += tempResult;
                tempResult = 0;
            } else {
                tempResult += height[start] - height[end];
            }
            end++;
        }
        // Edge case when doing the last part of the elevation map & it's open
        tempResult = 0;
        int lastStart = start;
        start = end - 1;
        end = start - 1;
        while (end >= lastStart) {
            if (height[start] <= height[end]) {
                start = end;
                result += tempResult;
                tempResult = 0;
            } else {
                tempResult += height[start] - height[end];
            }
            end--;
        }
        return result;
    }

    /*
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = -1, maxRight = -1;
        int totalRain = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalRain += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    totalRain += maxRight - height[right];
                }
                right--;
            }

        }
        return totalRain;
    }
    */
}
