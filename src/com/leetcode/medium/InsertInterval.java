package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 *
 * You are given an array of non-overlapping intervals where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
 * intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[] toAdd = newInterval;
        for (int[] current: intervals) {
            if (current[0] > toAdd[1]) {
                result.add(toAdd);
                toAdd = current;
            } else if (current[1] < toAdd[0]) {
                result.add(current);
            } else {
                toAdd[0] = Math.min(toAdd[0], current[0]);
                toAdd[1] = Math.max(toAdd[1], current[1]);
            }
        }
        result.add(toAdd);
        return result.toArray(new int[result.size()][2]);
    }
}
