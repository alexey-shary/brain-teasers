package com.ctci.chapter2;

public class KtoLast {
    public Node returnKtoLast(Node head, int k) {
        Node current = head;
        int counter = 0;
        while (current != null) {
            counter++;
            current = current.next;
        }
        int fromStart = counter - k + 1;
        current = head;
        counter = 1;
        while (counter++ != fromStart) {
            current = current.next;
        }
        return current;
    }
}
