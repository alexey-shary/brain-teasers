package com.ctci.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public int[] asArray() {
        List<Integer> list = new ArrayList<>();
        list.add(data);
        Node pointer = next;
        while (pointer != null) {
            list.add(pointer.data);
            pointer = pointer.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void addFromArray(int[] array) {
        for (int element: array) {
            appendToTail(element);
        }
    }

    public Node returnKth(int k) {
        Node n = this;
        for (int i = 1; i < k; i++) {
            n = n.next;
        }
        return n;
    }
}
