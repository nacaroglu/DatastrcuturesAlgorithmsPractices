package com.nacaroglu.dsa.practice._mixed;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		
		Subsets ss = new Subsets();

		int[] nums = {1,3,3,5};
		
		List<List<Integer>> subsets = ss.subsets(nums); 
		
		for (List<Integer> list : subsets) {
			System.out.print("{");
			for (Integer integer : list) {
				
				System.out.print(integer+ ", ");
			}
			System.out.print("}");
			System.out.println();
		}

	}
	
	public List<List<Integer>> subsets(int nums[]){
		List<List<Integer>> subsets = new ArrayList();
		helper(0,nums, subsets, new ArrayList<Integer>());
		
		return subsets;
	}

	private void helper(int index, int[] nums, List<List<Integer>> subsets, ArrayList<Integer> current) {
		
		subsets.add(new ArrayList<Integer>(current));
		
		for(int i=index; i<nums.length; i++) {
			current.add(nums[i]);
			helper(i+1, nums, subsets, current);
			current.remove(current.size()-1);
		}		
	}
}
