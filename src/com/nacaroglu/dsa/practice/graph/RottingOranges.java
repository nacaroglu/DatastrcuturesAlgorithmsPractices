package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayDeque;
import java.util.Queue;

class Cell {

	int r;
	int c;

	public Cell(int x, int y) {
		super();
		this.r = x;
		this.c = y;
	}
	
	@Override
	public String toString() {
		return "Cell [r=" + r + ", c=" + c + "]";
	}
}

public class RottingOranges {

	public static void main(String[] args) {

		RottingOranges ro = new RottingOranges();
		int[][] grid =  {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(ro.orangesRotting(grid));
		
		int[][] grid2 =  {{1}};
		System.out.println(ro.orangesRotting(grid2));
		
		
		// [[2,1,1],[1,1,1],[0,1,2]]
		
		int[][] grid3=  {
							{2,1,1},
							{1,1,1},
							{0,1,2}
						};
		System.out.println(ro.orangesRotting(grid3));
		

	}

	public int orangesRotting(int[][] grid) {

		/*
		 * 0 representing an empty cell, 
		 * 1 representing a fresh orange, or 
		 * 2 representing a rotten orange.
		 */

		int freshCount = 0;

		Cell startCell = null;
		int rowCount = grid.length;
		int colCount = grid[0].length;

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 2) {

					if (startCell == null) {
						startCell = new Cell(r, c);
					}	
				}
				
				if(grid[r][c]==1) {
					freshCount++;
				}
			}
		}

		if (freshCount == 0) {
			return 0;
		}
		
		if (startCell == null) {
			return -1;
		}
		
		freshCount += 1;

		int timer = 0;

		Queue<Cell> q = new ArrayDeque<Cell>();
		q.add(startCell);

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		while (!q.isEmpty()) {

			
			int size = q.size();
			boolean added = false;

			for (int i = 0; i < size; i++) {
				Cell curr = q.poll();

				if (visited[curr.r][curr.c]) {
					continue;
				}

				// go down
				if (curr.r + 1 < rowCount && grid[curr.r + 1][curr.c] == 1) {
					q.add(new Cell(curr.r + 1, curr.c));
					added = true;
				}

				// go up
				if (curr.r - 1 >= 0 && grid[curr.r - 1][curr.c] == 1) {
					q.add(new Cell(curr.r - 1, curr.c));
					added = true;
				}

				// go left
				if (curr.c + 1 < colCount && grid[curr.r][curr.c + 1] == 1) {
					q.add(new Cell(curr.r, curr.c + 1));
					added = true;
				}

				// go left
				if (curr.c - 1 >= 0 && grid[curr.r][curr.c - 1] == 1) {
					q.add(new Cell(curr.r, curr.c - 1));
					added = true;
				}

				grid[curr.r][curr.c] = 2;
				freshCount -= 1;
				visited[curr.r][curr.c] = true;
			}
			
			if(added)
				timer++;
		}

		if (freshCount != 0) {
			return -1;
		} else {
			return timer;
		}
	}
}
