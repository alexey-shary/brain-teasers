package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTwoNumbersTest {
    @Test
    public void testAddTwoNumbers() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        assertTrue(assertEqualsListNodes(addTwoNumbers.addTwoNumbers(createListNodeFromArray(new int[] {2, 4, 3}), createListNodeFromArray(new int[] {5, 6, 4})), createListNodeFromArray(new int[] {7, 0 ,8})));
        assertTrue(assertEqualsListNodes(addTwoNumbers.addTwoNumbers(createListNodeFromArray(new int[] { 0 }), createListNodeFromArray(new int[] { 0 })), createListNodeFromArray(new int[] { 0 })));
        assertTrue(assertEqualsListNodes(addTwoNumbers.addTwoNumbers(createListNodeFromArray(new int[] { 9, 9, 9, 9, 9, 9, 9 }), createListNodeFromArray(new int[] { 9, 9, 9, 9 })), createListNodeFromArray(new int[] { 8, 9, 9, 9, 0, 0, 0, 1 })));
    }

    private boolean assertEqualsListNodes(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null || l2 != null) {
            return false;
        }
        return true;
    }

    private ListNode createListNodeFromArray(int[] array) {
        ListNode listNode = new ListNode();
        ListNode start = listNode;
        for (int i: array) {
            if (listNode.next != null) {
                listNode = listNode.next;
            }
            listNode.val = i;
            listNode.next = new ListNode();
        }
        listNode.next = null;
        return start;
    }
}
