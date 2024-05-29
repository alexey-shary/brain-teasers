package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. Clone Graph
 *
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 */
public class CloneGraph {
    private final Map<Integer, Node> alreadyCloned = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node clone = new Node(node.val);

        alreadyCloned.put(node.val, clone);

        for (Node n: node.neighbors) {
            if (alreadyCloned.containsKey(n.val)) {
                clone.neighbors.add(alreadyCloned.get(n.val));
            } else {
                clone.neighbors.add(cloneGraph(n));
            }
        }

        return clone;
    }

    // TODO: solve using BFS (map and queue)
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}