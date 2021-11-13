package com.nacaroglu.dsa.practice.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ValidPath {

	public static void main(String[] args) {
	
		ValidPath vp = new ValidPath();
		int[][] edges = {{0,1},{1,2},{2,0}};
		System.out.println(vp.validPath(3, edges, 0, 2));
		
		int[][] edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
		System.out.println(vp.validPath(6, edges2, 0, 5));
		
		int[][] edges3 = {};
		System.out.println(vp.validPath(1, edges3, 0, 0));
		
		int[][] edges4 = {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};	
		System.out.println(vp.validPath(10, edges4, 7, 5));
	}
	
	public boolean validPath(int n, int[][] edges, int start, int end) {
		
		if(edges.length==0){
			return true;
		}
		
		Map<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
		
		for(int i=0; i<n;i++) {
			graph.put(i, new LinkedList<>());
		}
		
		for(int i=0; i<edges.length;i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}
		
		boolean[] visited = new boolean[n];
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(start);
		
		while(!stack.isEmpty()) {
			
			int curr = stack.pop();
			
			if(visited[curr]) {
				continue;
			}
			
			visited[curr] = true;			
			LinkedList<Integer> items = graph.get(curr);
			
			for(Integer newItem: items) {				
				if(newItem==end) {
					return true;
				}				
				stack.add(newItem);				
			}
		}		
		return false;		
    }

}
