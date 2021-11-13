package com.nacaroglu.dsa.practice.disjoinsets;

import java.util.*; 

public class NumberOfProvinces {

	public static void main(String[] args) {

		NumberOfProvinces provs = new NumberOfProvinces();
		int[][] matrix = { { 1, 1, 0, 0, 0, 1 }, { 1, 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 0, 1 } };
		System.out.println(provs.findCircleNum(matrix));
	}

	int[] root;

	public int findCircleNum(int[][] matrix) {

		int n = matrix.length;

		root = new int[n+1];
		for (int i = 1; i <= n; i++) {
			root[i] = i;
		}

		for (int r = 0; r < n; r++) {
			for (int c = r; c < n; c++) {
				if (r != c && matrix[r][c] == 1) {
					int x = r + 1;
					int y = c + 1;
					//System.out.println(" pair: " + x + ", " + y);					
					union(x,y);
				}
			}
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=1; i<root.length; i++) {
			set.add(root[i]);
		}

		return set.size();
	}

	public int find(int x) {
		return root[x];
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			for (int i = 1; i < root.length; i++) {
				if (root[i] == rootY) {
					root[i] = rootX;
				}
			}
		}
	}

}
