package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AllPathsSourceTarget {

	public static void main(String[] args) {		

		// [[1,2],[3],[3],[]]
		AllPathsSourceTarget apst = new AllPathsSourceTarget();
		int[][] edges = {{1,2},{3},{3},{}};
		apst.allPathsSourceTarget(edges);
		
		int[][] edges2 =  {{4,3,1},{3,2,4},{3},{4},{}};
		apst.allPathsSourceTarget(edges2);
		
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] edges) {
		
        List<List<Integer>> result = new ArrayList<>();        
        int n = edges.length;
        
        Map<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
        
        for(int i=0; i<edges.length; i++) {
        	
        	LinkedList<Integer> list = new LinkedList<Integer>();
        	
        	for(int j=0; j<edges[i].length; j++ ) {
        		list.add(edges[i][j]);
        	}
        	
        	graph.put(i, list);
        }
        
		Stack<LinkedList<Integer>> stack = new Stack<LinkedList<Integer>>();
		LinkedList<Integer> first = new LinkedList<Integer>();
		first.add(0);
		stack.add(first);		
		
		while(!stack.isEmpty()) {
			
			LinkedList<Integer> curr = stack.pop();
			LinkedList<Integer> items = graph.get(curr.getLast());
			
			if(items.size()==0) {
				continue;
			}
			
			for(Integer newItem: items) {
				
				LinkedList<Integer> myList = new LinkedList<>(curr);
				myList.addLast(newItem);
								
				if(newItem==n-1) {					
					result.add(myList);
				}				
				stack.add(myList);				
			}
		}		
        
        return result;
    }
}
