package com.nacaroglu.dsa.practice.recursion;

import java.util.LinkedList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Combinations c = new Combinations();
		/*List<List<Integer>> result = c.combine(4, 4);
		for (List<Integer> list : result) {
			System.out.print("{");
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println("}");
		}*/
		
		int[] nums = {3,5,7};
		List<List<Integer>> result = c.subsets(nums);
		for (List<Integer> list : result) {
			System.out.print("[");
			for (Integer integer : list) {
				System.out.print(integer + ",");
			}
			System.out.println("],");
		}
	}
	
	 public List<List<Integer>> subsets(int[] nums) {
	        
		 List<List<Integer>> subSets = new LinkedList<List<Integer>>();
		 
		 for (int i = 0; i < nums.length+1; ++i) {
			subSets.addAll(combine(nums.length, i, nums));
		}	
		 
		return subSets; 
	 }
	
	public List<List<Integer>> combine(int n, int k, int[] nums) {
		
		List<List<Integer>> result = new LinkedList<List<Integer>>();		
		backtrack(nums,n,k,0,result, new LinkedList<Integer>() );        
        return result;
    }

	private void backtrack(int[] nums, int n, int k, int start, List<List<Integer>> result, LinkedList<Integer> inner) {			
		
		if(inner.size()==k) {
			result.add(new LinkedList<>(inner));			
		}		
		
		for(int i=start; i<n; i++) {			
			inner.add(nums[i]);
			backtrack(nums,n, k, i+1, result, inner);
			inner.remove(inner.size() - 1);
		}	
	}

}
