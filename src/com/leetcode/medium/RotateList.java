package com.leetcode.medium;

/**
 * 61. Rotate List
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        int length = 1;
        while (p.next != null) {
            p = p.next;
            length++;
        }
        p.next = head;
        k = k % length;
        for (int i = 0; i < length - k; i++) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
