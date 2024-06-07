package com.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 207. Course Schedule
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi]
 * indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prereq = new HashMap<>();
        for (int[] p: prerequisites) {
            prereq.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
        }

        // TODO: Coloring Algorithm (DFS)
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCycle(i, prereq, visited)) {
                return false;
            }
        }
        return true;
    }

    /*
     * 0 - used for node which is not yet visited
     * 1 - used for the node which is visited and currently its child nodes are being visited
     * 2 - done when all the child nodes of a node
     */
    private boolean isCycle(int course, Map<Integer, Set<Integer>> prereq, int[] visited) {
        if (visited[course] == 1) {
            return true;
        }

        if (visited[course] == 0) {
            visited[course] = 1;
            Set<Integer> preCourses = prereq.get(course);
            if (preCourses != null) {
                for (int i: preCourses) {
                    if (isCycle(i, prereq, visited)) {
                        return true;
                    }
                }
            }
        }

        visited[course] = 2;
        return false;
    }
}
