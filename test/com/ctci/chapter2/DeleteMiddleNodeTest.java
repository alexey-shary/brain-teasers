package com.ctci.chapter2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteMiddleNodeTest {
    @Test
    public void testDelete() {
        DeleteMiddleNode dmn = new DeleteMiddleNode();
        Node actual = new Node(5);
        actual.addFromArray(new int[] {1, 2, 3, 5, 4, 2});
        dmn.delete(actual.returnKth(4));
        assertTrue(Arrays.equals(new int[] {5, 1, 2, 5, 4, 2}, actual.asArray()));
    }
}
