package com.leetcode.medium;

/**
 * 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n >= 1) return null;

        if (n == 1) { // Special case - need to remove the very last node
            ListNode prev = head, current = head;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = null;
        } else {
            ListNode behinder = head, frontRunner = head;
            for (int i = 0; i < n; i++) {
                frontRunner = frontRunner.next;
            }
            while (frontRunner != null) {
                behinder = behinder.next;
                frontRunner = frontRunner.next;
            }
            ListNode next = behinder.next;
            behinder.val = next.val;
            behinder.next = next.next;
        }
        return head;
    }
}
