package com.nacaroglu.dsa.practice.disjoinsets;

public class NumberOfConnectedComponents {

	public static void main(String[] args) {

		NumberOfConnectedComponents sol = new NumberOfConnectedComponents();
		int[][] edges = { { 0, 1 }, { 2, 3 }, { 1, 2 } };
		int result = sol.countComponents(4, edges);
		System.out.println(result);
	}

	int root[];
	int rank[];
	int count;

	public int countComponents(int n, int[][] edges) {

		root = new int[n];
		rank = new int[n];
		count = n;

		for (int i = 0; i < n; i++) {
			root[i] = i;
			rank[i] = 1;
		}

		for (int i = 0; i < edges.length; i++) {
			union(edges[i][0], edges[i][1]);
		}

		return count;
	}

	private void union(int x, int y) {

		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			if (rank[rootX] > rank[rootY]) {
				root[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {
				root[rootX] = rootY;
			} else {
				root[rootY] = rootX;
				rank[rootX] += 1;
			}

			count -= 1;
		}
	}

	private int find(int x) {
		if (x == root[x]) {
			return x;
		}
		return root[x] = find(root[x]);
	}

}
