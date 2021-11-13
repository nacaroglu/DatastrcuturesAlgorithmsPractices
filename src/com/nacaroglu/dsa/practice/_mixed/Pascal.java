package com.nacaroglu.dsa.practice._mixed;

import java.util.ArrayList;
import java.util.List;

public class Pascal {

	public static void main(String[] args) {
		
		Pascal p = new Pascal();
		
		
		List<List<Integer>> result = p.createTriangle(5);
		printTriangle(result);

	}

	private static void printTriangle(List<List<Integer>> result) {
		for (List<Integer> list : result) {
			
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			
			System.out.println();
		}
	}

	private List<List<Integer>> createTriangle(int n) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		ArrayList<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		result.add(firstRow);
		
		List<Integer> prevRow = firstRow;
		
		for(int i=2; i<=n; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>(i);
			
			row.add(1);
					
			for(int j=1; j<i-1; j++) {
				row.add(prevRow.get(j-1)+ prevRow.get(j));
			}
			
			row.add(1);
			
			result.add(row);
			prevRow = row;
		}
		
		return result;
	}

}
