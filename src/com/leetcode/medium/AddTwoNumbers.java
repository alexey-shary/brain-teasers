package com.leetcode.medium;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode start = result;

        int addOne = 0;
        while (l1 != null || l2 != null) {
            if (result.next != null) {
                result = result.next;
            }
            if (l1 != null) {
                result.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result.val += l2.val;
                l2 = l2.next;
            }
            result.val += addOne;
            if (result.val / 10 == 1) {
                addOne = 1;
                result.val -= 10;
            } else {
                addOne = 0;
            }
            result.next = new ListNode();
        }

        if (addOne == 1) {
            result = result.next;
            result.val = addOne;
        } else {
            result.next = null;
        }

        return start;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
