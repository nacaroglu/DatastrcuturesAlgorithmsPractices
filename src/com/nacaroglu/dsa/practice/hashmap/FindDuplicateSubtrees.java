package com.nacaroglu.dsa.practice.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class FindDuplicateSubtrees {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);

		Set<String> s = new HashSet<String>();
		List al = Arrays.asList(s.toArray());

		FindDuplicateSubtrees f = new FindDuplicateSubtrees();

		/*
		
		System.out.println(f.lengthOfLongestSubstring("pwwkew"));

		System.out.println(f.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(f.lengthOfLongestSubstring("bbbbb"));

		System.out.println(f.lengthOfLongestSubstring(" "));
		System.out.println(f.lengthOfLongestSubstring("au")); 
		
		System.out.println(f.lengthOfLongestSubstring("aabaab!bb"));
		System.out.println(f.lengthOfLongestSubstring("aab")); */
		
		int[] arr = {1,1,1,2,2,3};
		
		f.topKFrequent(arr, 2);
		
		int[] arr2 = {1,2};
		
		f.topKFrequent(arr2, 2);
		

	}
	
	public int[] topKFrequent(int[] nums, int k) {
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        for(int i=0; i< nums.length; i++){
	            if(map.containsKey(nums[i])){
	                map.put(nums[i], map.get(nums[i])+1);
	            }else{
	                map.put(nums[i], 1);
	            }            
	        }     
	        
	        Queue<Integer> heap = new PriorityQueue<>(
	                (n1, n2) -> map.get(n1) - map.get(n2));
	        
	        for (int n: map.keySet()) {
	            heap.add(n);
	            if (heap.size() > k) heap.poll();    
	          }
	        
	        HashSet<Integer> set = new HashSet<Integer>();
	       
	      
	        
	       int[] result = new int[k];
	       
	       
	       for(int i=0; i<k; i++) {
	    	   result[i] = heap.poll();
	       }
	       
	       
	       return result;
    }

	public int lengthOfLongestSubstring(String s) {

		Set<Character> set = new HashSet<Character>();

		char[] charArr = s.toCharArray();

		for (int i = 0; i < charArr.length; i++) {
			set.add(charArr[i]);
		}

		for (int max = set.size(); max > 0; max--) {

			for (int start = 0; start < s.length(); start++) {

				Set<Character> tmpSet = new HashSet<Character>();

				for (int j = start; j < s.length(); j++) {

					char current = charArr[j];

					if (tmpSet.contains(current)) {					
						break;
					} else {
						tmpSet.add(current);
					}
				}

				if (max == tmpSet.size()) {
					// System.out.println(tmpSet.size());
					return max;
				}
			}
		}

		return set.size();
	}

	private Queue<Character> getList(Set<Character> set) {

		Queue<Character> list = new LinkedList<Character>();

		for (Character character : set) {
			list.add(character);
		}

		return list;
	}

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		return null;
	}

	private void calculateChildSum(TreeNode root, Set<Integer> sums, int pathSum) {

		pathSum = pathSum + root.val;

		if (root.left == null && root.right == null) {
			sums.add(pathSum);
			return;
		}

		if (root.left != null) {
			calculateChildSum(root.left, sums, pathSum);
		}

		if (root.right != null) {
			calculateChildSum(root.right, sums, pathSum);
		}
	}

}
