package com.nacaroglu.dsa.practice.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class DFS {

	public static void main(String[] args) {
		
		Map<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
		
		for(int i=0; i<13;i++) {
			graph.put(i, new LinkedList<>());
		}
		
		graph.get(0).add(1);
		graph.get(0).add(9);
		
		graph.get(1).add(8);
		graph.get(9).add(8);
		
		graph.get(8).add(7);
		
		graph.get(7).add(10);
		graph.get(7).add(11);
		graph.get(7).add(6);
		graph.get(6).add(5);
		graph.get(7).add(3);
		
		graph.get(3).add(2);
		graph.get(3).add(4);
		graph.get(3).add(5);		
		graph.get(5).add(6);		
		graph.get(10).add(11);
		
		dfs(graph, 0);
		System.out.println(" ");
		dfsIterative(graph, 0);
	}

	private static void dfs (Map<Integer, LinkedList<Integer>> graph, int start) {
		
		int n = graph.size();
		boolean[] visited = new boolean[n];
		
		dfsUtil(graph, start, visited);		
	}

	private static void dfsUtil(Map<Integer, LinkedList<Integer>> graph, int node, boolean[] visited) {
		
		if(visited[node]) {
			return;
		}
		
		visited[node] = true;
		System.out.print(node + " ");
		
		LinkedList<Integer> items = graph.get(node);
		
		for(Integer curr: items) {
			dfsUtil(graph, curr, visited);
		}
	}
	
	private static void dfsIterative (Map<Integer, LinkedList<Integer>> graph, int start) {
		
		int n = graph.size();
		boolean[] visited = new boolean[n];
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(start);
		
		while(!stack.isEmpty()) {
			
			int curr = stack.pop();
			
			if(visited[curr]) {
				continue;
			}
			
			visited[curr] = true;
			
			System.out.print(curr + " ");
			
			LinkedList<Integer> items = graph.get(curr);
			
			for(Integer newItem: items) {
				stack.add(newItem);				
			}
		}
	}

}
