package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) { // overlapping
                if (current[1] < intervals[i][1]) {
                    current[1] = intervals[i][1];
                }
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);

        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}