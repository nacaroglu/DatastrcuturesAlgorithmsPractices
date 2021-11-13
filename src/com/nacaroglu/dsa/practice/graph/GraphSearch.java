package com.nacaroglu.dsa.practice.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphSearch {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	GraphSearch(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// prints BFS traversal from a given source s
	void doBFS(int s) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[V];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			
			for (Integer n : adj[s]) {
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}		
			}		
		}
	}
	
	void doDFS(int s) {
		
		boolean visited[] = new boolean[V];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		visited[s] = true;
		stack.add(s);
		
		DFS_visit(s, visited, stack);	
	}

	private void DFS_visit(int s, boolean[] visited, Stack<Integer> stack) {
		
		while (!stack.isEmpty()) {
			
			int item  = stack.pop();
			System.out.println(item);
			
			for (Integer n : adj[s]) {
				
				if(!visited[n]) {
					visited[n]=true;
					stack.add(n);
					DFS_visit(n, visited, stack);
				}
			}
			
		}
	}

	// Driver method to
	public static void main(String args[]) {
		GraphSearch g = new GraphSearch(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		//g.doBFS(2);
		g.doDFS(2);
		

	}
}
