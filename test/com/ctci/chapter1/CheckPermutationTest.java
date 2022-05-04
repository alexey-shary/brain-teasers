package com.ctci.chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPermutationTest {
    @Test
    public void testIsPermutation() {
        CheckPermutation cp = new CheckPermutation();
        assertTrue(cp.isPermutation("asdf", "adsf"));
        assertTrue(cp.isPermutationOptimized("asdf", "adsf"));

        assertFalse(cp.isPermutation("asdf", "qwer"));
        assertFalse(cp.isPermutationOptimized("asdf", "qwer"));

        assertFalse(cp.isPermutation("asdf", "as df"));
        assertFalse(cp.isPermutationOptimized("asdf", "as df"));
    }
}
