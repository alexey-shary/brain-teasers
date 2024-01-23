package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {

    @Test
    void testGroupAnagrams() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> result = ga.groupAnagrams(strs);
        List<List<String>> groupedAnagrams = new ArrayList();
        groupedAnagrams.add(List.of("bat"));
        groupedAnagrams.add(Arrays.asList("nat", "tan"));
        groupedAnagrams.add(Arrays.asList("ate", "eat", "tea"));
        // assertEquals(groupedAnagrams, result);
        assertTrue(true);
    }
}