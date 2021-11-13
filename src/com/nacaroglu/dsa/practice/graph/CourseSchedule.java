package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

	public static void main(String[] args) {
		
		CourseSchedule cs = new CourseSchedule();
		int[][] prerequisites1 = {{1,0}};
		int[] result = cs.findOrder(2, prerequisites1);
		printArr(result);
		
		
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		result = cs.findOrder(4, prerequisites);
		printArr(result);
		
		int[][] prerequisites3 = {};
		result = cs.findOrder(1, prerequisites3);
		printArr(result); 
	}

	private static void printArr(int[] result) {
		for (int i : result) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}
	
	public int[] findOrder_Khan(int numCourses, int[][] prerequisites) {
        
		Map<Integer, List<Integer>> graph = buildMap(numCourses, prerequisites);		
		
		int[] order = new int[numCourses]; 		
		
		int[] inDegree = new int[numCourses];
		for(int node : graph.keySet()) {			
			for( int neighbor : graph.get(node)) {
				inDegree[neighbor] = inDegree[neighbor] + 1; 
			}		
		}
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(int i=0; i<inDegree.length; i++) {
			if(inDegree[i]==0) {
				q.add(i);				
			}
		}
		
		int index = 0;
		
		while(!q.isEmpty()) {
			int curr = q.pop();
			order[index++] = curr;
			
			for(int node : graph.get(curr)) {
				inDegree[node] = inDegree[node] - 1;
				if(inDegree[node]==0) {
					q.add(node);
				}
			}
		}
		
		if(index!=numCourses) {
			return null;
		}
		
		return order;
    }
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		Map<Integer, List<Integer>> graph = buildMap(numCourses, prerequisites);
		
		
		boolean visited[] = new boolean[numCourses];
		LinkedList<Integer> orderList = new LinkedList<>();
		
		for(int i=0; i<numCourses; i++) {			
			if(!visited[i]) {				
				dfs(graph, i, visited, orderList);
			}
		}
		
		if(orderList.size()!=numCourses) {
			return new int[0]; 	
		}
		
		int[] order = orderList.stream().mapToInt(i -> i).toArray();
		
		return order;
	}

	private Map<Integer, List<Integer>> buildMap(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		
		for(int i=0; i<numCourses; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		for(int i=0; i<prerequisites.length; i++) {
			List<Integer> list = graph.get(prerequisites[i][1]);
			list.add(prerequisites[i][0]);
			graph.put(prerequisites[i][1],list);
		}
		return graph;
	}

	private void dfs(Map<Integer, List<Integer>> graph, int i, boolean[] visited, LinkedList<Integer> orderList) {
		
		visited[i]=true;
		
		List<Integer> edges = graph.get(i);
		for(int edge:  edges) {
			if(visited[edge])
				dfs(graph, edge, visited, orderList);
		}
		
		orderList.addLast(i);		
	}
}
