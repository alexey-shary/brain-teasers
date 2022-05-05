package com.ctci.chapter2;

public class DeleteMiddleNode {
    public void delete(Node node) {
        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
    }
}
