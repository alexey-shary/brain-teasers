package com.leetcode.medium;

/**
 * 86. Partition List
 *
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lowerStart = null, lowerEnd = null, higherStart = null, higherEnd = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                if (lowerStart == null) {
                    lowerStart = head;
                    lowerEnd = lowerStart;
                } else {
                    lowerEnd.next = head;
                    lowerEnd = head;
                }
            } else {
                if (higherStart == null) {
                    higherStart = head;
                    higherEnd = higherStart;
                } else {
                    higherEnd.next = head;
                    higherEnd = head;
                }
            }
            head = next;
        }
        if (lowerStart == null) {
            return higherStart;
        }
        lowerEnd.next = higherStart;
        return lowerStart;
    }
}
