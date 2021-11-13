package com.nacaroglu.dsa.practice.backtracking;

import java.util.ArrayList;
import java.util.List;import org.hamcrest.core.Is;

import com.nacaroglu.dsa.practice.binarysearch.CountOfSmallerNumbersAfterSelf;

public class NQueens {
	
	public static class Point{
		
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			
			return "Row: " + r + " Column: " + c;
		}	
	}

	public static void main(String[] args) {
		
		NQueens q = new NQueens();
		
		List<Point> points = new ArrayList<NQueens.Point>();
		
		q.NQueen(4,0, points );
		
		System.out.println(q.count);
	}
	
	int count=0;
	
	public void NQueen(int n, int row, List<Point> points) {
		
		if(points.size()==n) {
			count++;			
			return;
		}
		
		for(int col=0; col<n; col++) {
			
			if(isSafePlace(row, col, points)) {
				points.add(new Point(row, col));
				NQueen(n, row+1, points);
		        points.remove(points.size()-1);
			}
		}
		
    }	


	private boolean isSafePlace(int row, int column, List<Point> points) {
		
		//System.out.println("row: " + row +  ", col: " +column);
		
		if(points.isEmpty()) {
			return true;
		}
		
		for (int queen =0; queen <points.size(); queen++) {
			
			// same row or column
			if (points.get(queen).c == column || points.get(queen).r == row) {
				return false;
			}
			
			//saga yatik kosegen
			if(points.get(queen).r + points.get(queen).c == row + column) {
				return false;
			}
					
			if(points.get(queen).r - points.get(queen).c == row - column) {
				return false;
			}
		}

		return true;
	}
}
