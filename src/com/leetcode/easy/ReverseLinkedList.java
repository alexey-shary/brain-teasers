package com.leetcode.easy;

/**
 * 206. Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = reverse(head.next, head);
        head.next = null;
        return newHead;
    }

    private ListNode reverse(ListNode node, ListNode prev) {
        if (node.next == null) {
            node.next = prev;
            return node;
        }
        ListNode head = reverse(node.next, node);
        node.next = prev;
        return head;
    }

    /*
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, temp = null;
        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    */
}
