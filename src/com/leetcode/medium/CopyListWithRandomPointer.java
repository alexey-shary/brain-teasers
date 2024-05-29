package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 *
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *  - val: an integer representing Node.val
 *  - random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 *
 * Your code will only be given the head of the original linked list.
 */
public class CopyListWithRandomPointer {
    public ListNodeRandom copyRandomList(ListNodeRandom head) {
        if (head == null) return null;
        Map<ListNodeRandom, List<ListNodeRandom>> path = new HashMap();
        Map<ListNodeRandom, ListNodeRandom> oldNew = new HashMap();
        ListNodeRandom prev = null, newHead = null;
        while (head != null) {
            ListNodeRandom newNode = new ListNodeRandom(head.val);
            if (head.random != null) {
                if (oldNew.get(head.random) != null) {
                    newNode.random = oldNew.get(head.random);
                } else {
                    path.computeIfAbsent(head.random, k -> new ArrayList<>()).add(newNode);
                }
            }
            if (prev != null) {
                prev.next = newNode;
            } else {
                newHead = newNode;
            }
            oldNew.put(head, newNode);
            if (path.get(head) != null) {
                for (ListNodeRandom n: path.get(head)) {
                    n.random = newNode;
                }
            }
            prev = newNode;
            head = head.next;
        }
        return newHead;
    }
}

class ListNodeRandom {
    int val;
    ListNodeRandom next;
    ListNodeRandom random;

    public ListNodeRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}