package com.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainsDuplicateTest {
    @Test
    void testContainsDuplicate() {
        ContainsDuplicate cd = new ContainsDuplicate();
        assertEquals(true, cd.containsDuplicate(new int[]{1,2,3,1}));
        assertEquals(false, cd.containsDuplicate(new int[]{1,2,3,4}));
        assertEquals(true, cd.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
