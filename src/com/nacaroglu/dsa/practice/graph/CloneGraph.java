package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
		;
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}
}

public class CloneGraph {

	public static void main(String[] args) {

		// adjList = [[2,4],[1,3],[2,4],[1,3]]

		Node node_1 = new Node(1);
		Node node_2 = new Node(2);
		Node node_3 = new Node(3);
		Node node_4 = new Node(4);

		node_1.neighbors.add(node_2);
		node_1.neighbors.add(node_4);

		node_3.neighbors.add(node_2);
		node_3.neighbors.add(node_4);

		node_2.neighbors.add(node_1);
		node_2.neighbors.add(node_3);

		node_4.neighbors.add(node_1);
		node_4.neighbors.add(node_3);

		CloneGraph cg = new CloneGraph();
		cg.cloneGraph(node_1);
	}

	public Node cloneGraph(Node node) {

		if (node == null) {
			return null;
		}

		Map<Node, Node> map = new HashMap<Node, Node>();
		map.put(node, new Node(node.val));

		Stack<Node> stack = new Stack<>();
		stack.add(node);

		while (!stack.isEmpty()) {

			Node curr = stack.pop();

			for (Node neighbor : curr.neighbors) {
				if (!map.containsKey(neighbor)) {
					// clone the neighbor
					map.put(neighbor, new Node(neighbor.val));
					// add it to the next level
					stack.push(neighbor);
				}

				// copy the neighbor
				map.get(curr).neighbors.add(map.get(neighbor));
			}
		}
		
		Node result = map.get(node);

		return result;
	}
}
