package com.nacaroglu.dsa.practice.disjoinsets;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
	
	public static void main(String[] args) {

		TheEarliestMomentWhenEveryoneBecomeFriends sol = new TheEarliestMomentWhenEveryoneBecomeFriends();
		int[][] edges = { { 20190101, 0, 1 }, { 20190104, 3, 4 }, { 20190107, 2, 3 }, { 20190211, 1, 5 },
				{ 20190224, 2, 4 }, { 20190301, 0, 3 }, { 20190312, 1, 2 }, { 20190322, 4, 5 } };
		int result = sol.earliestAcq(edges, 6);
		System.out.println(result);
	}
	
	int root[];
	int rank[];
	int count;
	
	 public int earliestAcq(int[][] logs, int n) {

		root = new int[n];
		rank = new int[n];
		count = n;

		for (int i = 0; i < n; i++) {
			root[i] = i;
			rank[i] = 1;
		}

		for (int i = 0; i < logs.length; i++) {
			union(logs[i][1], logs[i][2]);
			
			if(count==1) {
				return logs[i][0];
			}
		}

		return -1;
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
