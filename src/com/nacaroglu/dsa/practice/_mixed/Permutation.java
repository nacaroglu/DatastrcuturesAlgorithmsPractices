package com.nacaroglu.dsa.practice._mixed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		
		Permutation pm = new Permutation();
		int[] arr = {1,2,3};
		List<List<Integer>> result = pm.findPermutations(arr);
		
		printListOfList(result);

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
	
	public  List<List<Integer>> findPermutations(int[] nums) {
	   
		List<List<Integer>> result = new ArrayList();
		
		List<Integer> list = new ArrayList<Integer>();
		for (Integer x : nums) {
			list.add(x);
		}
	   
	    backtrack(nums.length, list, result, 0);
	    
	    return result;
	  }
	
	public  void backtrack(int n, List<Integer> nums, List<List<Integer>> result, int currentIndex) {
		
	   
		if(currentIndex==n) {
			result.add(new ArrayList<Integer>(nums));
		}
	    
	    for(int i=currentIndex; i<n; i++) {
	    	
	    	Collections.swap(nums, currentIndex, i);
	    	backtrack(n, nums, result, currentIndex+1);
	    	Collections.swap(nums, currentIndex, i);
	    }   
	  }
	}
