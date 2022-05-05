package com.ctci.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KtoLastTest {
    @Test
    public void testReturnKtoLast() {
        KtoLast ktl = new KtoLast();
        Node head = new Node(5);
        head.addFromArray(new int[] {1, 2, 3, 5, 4, 2});
        assertEquals(5, ktl.returnKtoLast(head, 3).data);
    }
}
