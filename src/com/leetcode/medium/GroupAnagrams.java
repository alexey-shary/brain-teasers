package com.leetcode.medium;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // O(n) solution
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);
            groups.computeIfAbsent(String.valueOf(sChars), k -> new ArrayList<>()).add(s); // use sorted anagram as key
        }
        return new ArrayList<>(groups.values());

        // O(n^2) solution
        /*
        List<List<String>> groupedAnagrams = new ArrayList();
        List<String> group = new ArrayList();
        group.add(strs[0]);
        groupedAnagrams.add(group);
        for (int i = 1; i < strs.length; i++) {
            boolean foundGroup = false;
            for (List grAn : groupedAnagrams) {
                if (belongsToGroup(grAn, strs[i])) {
                    grAn.add(strs[i]);
                    foundGroup = true;
                    continue;
                }
            }
            if (!foundGroup) {
                group = new ArrayList();
                group.add(strs[i]);
                groupedAnagrams.add(group);
            }
        }
        return groupedAnagrams;
        */
    }

    private boolean belongsToGroup(List<String> group, String a) {
        return isAnagram(group.get(0), a);
    }

    private boolean isAnagram(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        return Arrays.equals(aChars, bChars);
    }
}
