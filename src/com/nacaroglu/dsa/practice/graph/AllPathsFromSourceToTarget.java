package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		
		AllPathsFromSourceToTarget all = new AllPathsFromSourceToTarget();
		
		List<List<Integer>> result;
		
		int[][] graph = {{1,2},{3},{3},{}};		
		//result = all.allPathsSourceTarget(graph);
		//printResult(result);
		
		int[][] graph2 = {{4,3,1},{3,2,4},{3},{4},{}};	
		result = all.allPathsSourceTarget(graph2);
		
		printResult(result);
		
		int[][] graph3 =  {{1,2,3},{2},{3},{}};
		//result = all.allPathsSourceTarget(graph3);
		//printResult(result);

	}



	private static void printResult(List<List<Integer>> result) {
		for(List<Integer> list: result) {
			
			System.out.print("[");
			for(Integer i: list) {
				System.out.print(i + ", ");
			}
			System.out.print("]");			
			System.out.print(", ");
		}
		
		System.out.println("\n");
	}

	
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {      
   
		int start = 0;
		int end = graph.length-1;	
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Queue<ArrayList<Integer>> q = new ArrayDeque<ArrayList<Integer>>();
		ArrayList<Integer> startList = new ArrayList<Integer>();
		startList.add(start);		
		q.add(startList);

		boolean[] visited = new boolean[graph.length];

		while (!q.isEmpty()) {

			ArrayList<Integer> currList = q.poll();
			Integer currItem = currList.get(currList.size()-1);

			/*
			if (visited[currItem]) {
				continue;
			}*/

			
			if (graph[currItem].length==0) {
				continue;
			}

			for (Integer val : graph[currItem]) {
				
				ArrayList<Integer> newCurr = new ArrayList<Integer>(currList);
				newCurr.add(val);
				
				if (val == end) {
					result.add(newCurr);
				}else {								
					q.add( newCurr);
				}
			}

			visited[currItem] = true;
		}

		return result;
	}



}
