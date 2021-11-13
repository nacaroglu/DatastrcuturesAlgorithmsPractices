package com.nacaroglu.dsa.practice.graph;

import java.util.Arrays;

public class Kruskal {

	static class UnionFind {

		private int[] id, sz;

		public UnionFind(int n) {
			id = new int[n];
			sz = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i;
				sz[i] = 1;
			}
		}

		public int find(int p) {
			int root = p;
			while (root != id[root])
				root = id[root];
			while (p != root) { // Do path compression
				int next = id[p];
				id[p] = root;
				p = next;
			}
			return root;
		}

		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		public int size(int p) {
			return sz[find(p)];
		}

		public void union(int p, int q) {
			int root1 = find(p);
			int root2 = find(q);
			if (root1 == root2)
				return;
			if (sz[root1] < sz[root2]) {
				sz[root2] += sz[root1];
				id[root1] = root2;
			} else {
				sz[root1] += sz[root2];
				id[root2] = root1;
			}
		}
	}

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

		Kruskal k = new Kruskal();
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

		Edge[] graph = buildGraph(points, n);
		Arrays.sort(graph);

		UnionFind uf = new UnionFind(n);

		Edge curr = null;

		for (int i = 0; i < graph.length; i++) {

			curr = graph[i];

			if (!uf.connected(curr.from, curr.to)) {
				uf.union(curr.from, curr.to);
				sum += curr.cost;
			}

			if (uf.size(0) == n)
				break;
		}

		if (uf.size(0) != n)
			return 0;

		return sum;
	}

	private Edge[] buildGraph(int[][] points, int n) {

		Edge[] graph = new Edge[(n) * (n - 1)];

		int counter = 0;
		for (int from = 0; from < n; from++) {

			for (int to = 0; to < n; to++) {

				if (from == to)
					continue;

				Edge e = new Edge(from, to,
						Math.abs(points[from][0] - points[to][0]) + Math.abs(points[from][1] - points[to][1]));
				graph[counter++] = e;
			}
		}

		return graph;
	}

}
