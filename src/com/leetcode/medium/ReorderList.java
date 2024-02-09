package com.leetcode.medium;

/**
 * 143. Reorder List
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 *
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, temp = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        while (head != null && head.next != prev) {
            temp = head.next;
            head.next = prev;
            fast = prev.next;
            prev.next = temp;
            head = temp;
            prev = fast;
        }
    }
}
