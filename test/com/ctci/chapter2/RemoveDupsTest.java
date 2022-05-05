package com.ctci.chapter2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveDupsTest {
    @Test
    public void testRemoveDuplicates() {
        RemoveDups rd = new RemoveDups();
        Node actual = new Node(5);
        actual.addFromArray(new int[] {1, 2, 3, 5, 4, 2});
        rd.removeDuplicates(actual);
        Node expected = new Node(5);
        expected.addFromArray(new int[] {1, 2, 3, 4});
        assertTrue(Arrays.equals(expected.asArray(), actual.asArray()));
    }
}
