package com.leetcode.medium;

/**
 * 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 1 && head.next == null) return null;
        ListNode fast = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) { // Remove the first element (head)
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
