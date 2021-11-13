package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayDeque;
import java.util.Queue;

class Model {

	int r, c;
	int count;

	public Model(int r, int c, int count) {
		super();
		this.r = r;
		this.c = c;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Model [r=" + r + ", c=" + c + ", count=" + count + "]";
	}
	
	
}

public class ShortestPathInBinaryMatrix {

	public static void main(String[] args) {

		ShortestPathInBinaryMatrix sp = new ShortestPathInBinaryMatrix();
		
		/*
		int[][] grid = {{0,1},{1,0}};
		System.out.println(sp.shortestPathBinaryMatrix(grid));
		int[][] grid2 =  {{0,0,0},{1,1,0},{1,1,0}};
		System.out.println(sp.shortestPathBinaryMatrix(grid2));
		int[][] grid3 = {{1,0,0},{1,1,0},{1,1,0}};
		System.out.println(sp.shortestPathBinaryMatrix(grid3));
		*/
		
		int[][]  grid4= {{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}};
		//System.out.println(sp.shortestPathBinaryMatrix(grid4));
		
		int[][] grid5 = {{0,1,1,0,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,1,1,0},{1,1,1,1,0}};
		System.out.println(sp.shortestPathBinaryMatrix(grid5));
		
		int[][] grid6 = {
						{0,1,1,1,1,1,1,1},
						{0,1,1,0,0,0,0,0},
						{0,1,0,1,1,1,1,0},
						{0,1,0,1,1,1,1,0},
						{0,1,1,0,0,1,1,0},
						{0,1,1,1,1,0,1,0},
						{0,0,0,0,0,1,1,0},
						{1,1,1,1,1,1,1,0}
						};
		System.out.println(sp.shortestPathBinaryMatrix(grid6));
	}

	public int shortestPathBinaryMatrix(int[][] grid) {

		Queue<Model> q = new ArrayDeque<Model>();
		Integer result = Integer.MAX_VALUE;

		int n = grid.length;

		if (n == 1) {
			if (grid[0][0] == 1) {
				return -1;
			} else {
				return 1;
			}
		}		
		
		if(grid[0][0]==1) {
			return -1;
		}
		
		boolean visited[][] = new boolean[n][n]; 

		q.add(new Model(0, 0, 1));

		while (!q.isEmpty()) {

			Model curr = q.poll();
			
			if(visited[curr.r][curr.c]) {
				continue;
			}

			if (curr.r == n-1 && curr.c == n-1) {
				result = Math.min(result, curr.count);
			} else {

				if ( curr.c+1<n && grid[curr.r][curr.c + 1] == 0) {
					Model newItem = new Model(curr.r, curr.c + 1, curr.count + 1);
					q.add(newItem);
					System.out.println("Going right: " + newItem.toString()  );
				}

				if ( curr.r+1<n && grid[curr.r + 1][curr.c] == 0) {					
					Model newItem = new Model(curr.r + 1, curr.c, curr.count + 1);
					q.add(newItem);
					System.out.println("Going down: " + newItem.toString()  );
				}

				if (curr.r+1<n && curr.c+1 < n && grid[curr.r + 1][curr.c + 1] == 0) {					
					Model newItem = new Model(curr.r + 1, curr.c + 1, curr.count + 1);
					q.add(newItem);
					System.out.println("Going down right: " + newItem.toString()  );
				}
				
				if (curr.r-1>=0&& curr.r-1<n && curr.c+1 < n && grid[curr.r - 1][curr.c + 1] == 0) {
					Model newItem =new Model(curr.r - 1, curr.c + 1, curr.count + 1);
					q.add(newItem);					
					System.out.println("Going upper right: " + newItem.toString()  );
				}
				
				if (curr.r-1>=0&& curr.r-1<n && curr.c < n && grid[curr.r - 1][curr.c] == 0) {
					Model newItem =new Model(curr.r - 1, curr.c, curr.count + 1);
					q.add(newItem);					
					System.out.println("Going upper: " + newItem.toString()  );
				}
				
				if (curr.r>=0&& curr.r<n && curr.c-1>=0 && curr.c-1 < n && grid[curr.r][curr.c-1] == 0) {
					Model newItem =new Model(curr.r, curr.c-1, curr.count + 1);
					q.add(newItem);					
					System.out.println("Going left: " + newItem.toString()  );
				}
				
				if (curr.r-1>=0&& curr.c-1>=0 && curr.r-1<n && curr.c-1 < n && grid[curr.r - 1][curr.c - 1] == 0) {
					Model newItem =new Model(curr.r - 1, curr.c -1, curr.count + 1);
					q.add(newItem);					
					System.out.println("Going upper left: " + newItem.toString()  );
				}
			}
			
			visited[curr.r][curr.c] = true;
		}

		if (result == Integer.MAX_VALUE) {
			return -1;
		} else {
			return result;
		}
	}

}
