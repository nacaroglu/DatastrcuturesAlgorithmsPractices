package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {

	public static void main(String[] args) {

		Map<Integer, List<Integer>> g = new HashMap<Integer, List<Integer>>();
		
		ArrayList<Integer> v = new ArrayList<Integer>();
		v.add(2);		
		g.put(0, v);
		
		v = new ArrayList<Integer>();
		v.add(0);
		v.add(3);
		v.add(5);
		g.put(1, v);
		
		v = new ArrayList<Integer>();
		g.put(2,v);
		
		v = new ArrayList<Integer>();
		v.add(0);
		v.add(4);
		g.put(3,v);
		
		v = new ArrayList<Integer>();
		v.add(2);
		g.put(4, v);
		
		v = new ArrayList<Integer>();
		v.add(4);
		g.put(5, v);	
		
		TopologicalSort ts = new TopologicalSort();
		List<Integer> order = ts.findTopologicalOrder(g);
		for (Integer node : order) {
			System.out.println(node);
		}

	}
	
	public List<Integer> findTopologicalOrder(Map<Integer, List<Integer>> g) {
		
		List<Integer> order = new ArrayList<Integer>();
		
		int n = g.size();
		int[] inDegree = new int[n];
		for(int node : g.keySet()) {			
			for( int neighbor : g.get(node)) {
				inDegree[neighbor] = inDegree[neighbor] + 1; 
			}		
		}
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(int i=0; i<inDegree.length; i++) {
			if(inDegree[i]==0) {
				q.add(i);				
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.pop();
			order.add(curr);
			
			for(int node : g.get(curr)) {
				inDegree[node] = inDegree[node] - 1;
				if(inDegree[node]==0) {
					q.add(node);
				}
			}
		}
		
		if(order.size()!=n) {
			return null;
		}
		
		return order;
	}
}
