package com.nacaroglu.dsa.practice.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SortAnIncreasingAndDecreasingArray {

	public static void main(String[] args) {

		SortAnIncreasingAndDecreasingArray sss = new SortAnIncreasingAndDecreasingArray();
		List<Integer> nums = new ArrayList<>();
		int[] arr1 = { 57, 131, 493, 294, 221, 339, 418, 452, 442, 190 };
		sss.addToList(nums, arr1);
		sss.sortKIncreasingDecreasingArray(nums);

	}

	private void addToList(List<Integer> list, int[] arr1) {

		for (Integer e : arr1) {
			list.add(e);
		}
	}

	public List<Integer> sortKIncreasingDecreasingArray(List<Integer> nums) {

		List<List<Integer>> sortedLists = partitionList(nums);
		
		List<Integer> result = new ArrayList<Integer>();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=0; i<sortedLists.size(); i++) {
			
			List<Integer> curr = sortedLists.get(i);
			
			if(i%2==1) {
				Collections.reverse(curr);
			}
		}
		
		
		for(int i=0; i<sortedLists.size(); i++) {
			for(int j=0; j<sortedLists.get(i).size(); j++) {
				q.add(sortedLists.get(i).get(j));
			}
		}
		
		while(!q.isEmpty()) {
			result.add(q.poll());
		}

		return result;
	}

	private List<List<Integer>> partitionList(List<Integer> nums) {
		List<List<Integer>> sortedLists = new ArrayList<List<Integer>>();
		List<Integer> myList = new ArrayList();

		for (int i = 0; i < nums.size(); i++) {

			myList.add(nums.get(i));

			if (i > 0 && (i+1)<nums.size() && nums.get(i) > nums.get(i + 1) && nums.get(i) > nums.get(i - 1)) {
				sortedLists.add(myList);
				myList = new ArrayList<>();
			}
			
			if (i > 0 && (i+1)<nums.size() && nums.get(i) < nums.get(i + 1) && nums.get(i) < nums.get(i - 1)) {
				sortedLists.add(myList);
				myList = new ArrayList<>();
			}
		}
		
		sortedLists.add(myList);
		return sortedLists;
	}
}
