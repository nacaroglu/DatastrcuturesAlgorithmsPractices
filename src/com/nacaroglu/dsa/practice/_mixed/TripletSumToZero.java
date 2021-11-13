package com.nacaroglu.dsa.practice._mixed;

import java.util.ArrayList;
import java.util.List;

public class TripletSumToZero {

	public static void main(String[] args) {
		
		TripletSumToZero ts = new TripletSumToZero();
		int[] arr = {-5, 2, -1, -2, 3};
		List<List<Integer>> triplets = ts.searchTriplets(arr);
		
		printListOfList(triplets);
	}
	
	private static void printListOfList(List<List<Integer>> result) {
		for (List<Integer> list : result) {
			System.out.print("{");
			for(Integer i: list){
				System.out.print(i+ ",");
			}
			System.out.println("}");
		}
	}
	
	public List<List<Integer>> searchTriplets(int[] arr) {
	    
		List<List<Integer>> triplets = new ArrayList();
	    
	    List<Integer> list = new ArrayList<Integer>();
	    for (Integer x : arr) {
			list.add(x);
		} 
	    
	    
	    helper(3, 1, 0, list, new ArrayList<Integer>(), triplets);

	    return triplets;
	  }
	
	public void helper(int targetLevel, int level, int targetSum, List<Integer> list, List<Integer> result, List<List<Integer>> triplets ) {
		
		if(level==targetLevel) {
			if(list.contains(targetSum)) {
				result.add(targetSum);
				triplets.add(new ArrayList<Integer>(result));
			}
			
			return;
		}
		
		for(int i=0; i<list.size(); i++) {
			
			int newTargetSum = targetSum-list.get(i);
			ArrayList<Integer> newResult = new ArrayList<Integer>(result);
			newResult.add(list.get(i));
			ArrayList<Integer> newList = new ArrayList<Integer>(list);
			newList.remove(list.get(i));
			helper(targetLevel, level+1, newTargetSum, newList, newResult, triplets);
		}
	}
	

}
