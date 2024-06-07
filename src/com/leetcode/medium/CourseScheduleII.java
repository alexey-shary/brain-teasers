package com.leetcode.medium;

import java.util.*;

/**
 * 210. Course Schedule II
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi]
 * indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them.
 * If it is impossible to finish all courses, return an empty array.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incomingDependencies = new int[numCourses];
        Map<Integer, Set<Integer>> nextAvailableCourses = new HashMap<>();
        for (int[] p: prerequisites) {
            nextAvailableCourses.computeIfAbsent(p[1], k -> new HashSet<>()).add(p[0]);
            incomingDependencies[p[0]]++;
        }

        // TODO: Topological sort order of a DAG (BFS)
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (incomingDependencies[i] == 0) { // course does not have any dependencies
                toVisit.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int fromCourse = toVisit.poll();
            order[visited] = fromCourse;
            visited++;
            Set<Integer> toCourses = nextAvailableCourses.get(fromCourse);
            if (toCourses != null) {
                for (int toCourse: toCourses) {
                    incomingDependencies[toCourse]--;
                    if (incomingDependencies[toCourse] == 0) {
                        toVisit.offer(toCourse);
                    }
                }
            }
        }
        return visited == numCourses ? order : new int[0];
    }
}
