package com.leetcode.medium;

/**
 * 92. Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode prev = null, temp = null, preLeft = null, start = null;
        ListNode origin = head;
        int i = 1;
        while (head != null) {
            temp = head.next;
            if (i == left) {
                preLeft = prev;
                start = head;
            }
            if (i == right) {
                if (left == 1) {
                    preLeft = head;
                } else {
                    preLeft.next = head;
                }
                start.next = head.next;
            }
            if (i >= left && i <= right) {
                head.next = prev;
            }
            prev = head;
            head = temp;
            i++;
        }

        return left > 1 ? origin : preLeft;
    }
}
