package com.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i: nums) {
            freq.merge(i, 1, Integer::sum);
        }
        // Min heap here
        PriorityQueue<Integer> topK = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b)); // TODO: Comparator.comparingInt(freq::get)
        for (int i: freq.keySet()) {
            topK.offer(i);
            if (topK.size() > k) {
                topK.poll();
            }
        }
        IntStream.range(0, 10).parallel().forEach(i -> System.out.println(i));
        return topK.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : nums) {
            counts.merge(i, 1, Integer::sum);
        }
        List<Integer> sorted = counts.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).toList();
        for (int i = 0; i < k; i++) {
            result[i] = sorted.get(sorted.size() - 1 - i);
        }
        return result;
    }
    */

    /*
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequences.put(nums[i], frequences.getOrDefault(nums[i], 0) + 1);
        }
        // Max heap here
        PriorityQueue<Integer> topK = new PriorityQueue<>((a, b) -> frequences.get(b) - frequences.get(a));
        for (Integer num : frequences.keySet()) {
            topK.add(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.poll();
        }
        return result;
    }
    */
}