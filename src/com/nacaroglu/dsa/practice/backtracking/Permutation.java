package com.nacaroglu.dsa.practice.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Permutation pt = new Permutation();
		int[] nums = {1,2,3};
		pt.permute(nums);
		
		

	}
	
	public List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
							
		
		backtrack(nums,list,0);
        
        return null;
        
    }

	private void backtrack(int[] nums, List<List<Integer>> list, int i) {
		
		if(i==nums.length) {
			return;
		}
		
		for(int x=0; x<nums.length; x++) {
			
			System.out.println(nums[i]);			
		}
	}

	

	

}
