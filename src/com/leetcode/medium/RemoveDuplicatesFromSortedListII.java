package com.leetcode.medium;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (slow.val == fast.val) {
                while (fast != null && fast.val == slow.val) {
                    fast = fast.next;
                }
                if (prev == null) {
                    head = fast;
                } else {
                    prev.next = fast;
                }
                slow = fast;
            } else {
                prev = slow;
                slow = fast;
            }
        }
        return head;
    }
}