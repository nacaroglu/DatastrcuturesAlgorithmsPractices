package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Permutations {

	public static void main(String[] args) {		
		Permutations p = new Permutations();
		int[] nums = {1,2,3};
		//p.permute(nums);
		
		int[] nums2 = {1,1,2};
		List<List<Integer>> result =  p.permuteUnique(nums2);
		System.out.println("Bitti...");
	}
	
	public List<List<Integer>> permute(int[] nums) { 
			
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean[] used = new boolean  [nums.length];
		backtrack(nums,result, new LinkedList<Integer>(), used);		
		return result;
    }

	private void backtrack(int[] nums, List<List<Integer>> result, LinkedList<Integer> current, boolean[] used) {
		
		
		if(current.size()==nums.length) {
			result.add(new LinkedList<>(current));
			return;
		}

		for(int i=0; i<nums.length; i++) {
			
			if(used[i]) {
				continue;
			}
			
			used[i] = true;
			current.addLast(nums[i]);			
			backtrack(nums, result, current, used);			
			used[i] = false;
			current.removeLast();
		}		
	}
	
	
	public List<List<Integer>> permuteUnique(int[] nums) {    
        
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);    
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		backtrack2(nums,result, new LinkedList<Integer>(), map, 0);		
		return result;
    }

	private void backtrack2(int[] nums, List<List<Integer>> result, LinkedList<Integer> current, Map<Integer, ArrayList<Integer>> map, int level) 
    {
		
		
		if(current.size()==nums.length) {
			result.add(new LinkedList<>(current));
			return;
		}

		for(int i=0; i<nums.length; i++) {
			
			if(isUsed(map, i, level)) {
				continue;
			}
			
			//used[i] = true;
			
			if(!(i>0 && nums[i]==nums[i-1])) {
				current.addLast(nums[i]);
			}		
			
			//backtrack2(nums, result, current, used, level++);
			
			//used[i] = false;
			
			if(!(i>0 && nums[i]==nums[i-1])) {
				current.removeLast();
			}
			
		}	
	}

	private boolean isUsed(Map<Integer, ArrayList<Integer>> map, int i, int level) {
		
		//TODO
		
		return false;
	}
}