package com.ctci.chapter2;

import java.util.LinkedList;

/**
 * 2.1 -- Remove Dups -- page 94
 */
public class RemoveDups {
    public void removeDuplicates(Node head) {
        // temporary buffer is not allowed
        Node current = head;
        while (current != null) {
            Node runner = current.next;
            Node prev = current;
            while (runner != null) {
                if (current.data == runner.data) {
                    prev.next = runner.next;
                }
                prev = runner;
                runner = runner.next;
            }
            current = current.next;
        }
    }
}
