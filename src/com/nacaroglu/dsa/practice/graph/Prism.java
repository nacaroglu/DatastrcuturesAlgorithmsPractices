package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prism {

	static class Edge implements Comparable<Edge> {

		int from;
		int to;
		int cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) {

		Prism k = new Prism();
		int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
		System.out.println(k.minCostConnectPoints(points));

		int[][] points2 = { { 0, 0 }, { 1, 1 }, { 1, 0 }, { -1, 1 } };
		System.out.println(k.minCostConnectPoints(points2));

		//

		int[][] points3 = { { -1000000, -1000000 }, { 1000000, 1000000 } };
		System.out.println(k.minCostConnectPoints(points3));

	}

	public int minCostConnectPoints(int[][] points) {

		int sum = 0;

		if (points.length < 2)
			return sum;

		int n = points.length;

		List<List<Edge>> graph = buildGraph(points, n);

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[n];

		addEdges(0, visited, graph, pq);

		Edge curr = null;
		int edgeCount = 0;
		int m = n - 1;

		while (!pq.isEmpty() && edgeCount != m) {

			curr = pq.poll();

			int nodeIndex = curr.to;

			if (visited[nodeIndex])
				continue;

			edgeCount++;
			sum += curr.cost;

			addEdges(nodeIndex, visited, graph, pq);
		}

		if ((edgeCount != m))
			return 0;		

		return sum;
	}

	private void addEdges(int nodeIndex, boolean[] visited, List<List<Edge>> graph, PriorityQueue<Edge> pq) {
		visited[nodeIndex] = true;

		// edges will never be null if the createEmptyGraph method was used to build the
		// graph.
		List<Edge> edges = graph.get(nodeIndex);
		for (Edge e : edges)
			if (!visited[e.to]) {
				// System.out.printf("(%d, %d, %d)\n", e.from, e.to, e.cost);
				pq.offer(e);
			}
	}

	private List<List<Edge>> buildGraph(int[][] points, int n) {

		List<List<Edge>> graph = new ArrayList<>();

		for (int from = 0; from < n; from++) {

			List<Edge> neighbors = new ArrayList<Edge>();

			for (int to = 0; to < n; to++) {

				if (from == to)
					continue;

				Edge e = new Edge(from, to,
						Math.abs(points[from][0] - points[to][0]) + Math.abs(points[from][1] - points[to][1]));
				neighbors.add(e);
			}

			graph.add(neighbors);
		}

		return graph;
	}
}
