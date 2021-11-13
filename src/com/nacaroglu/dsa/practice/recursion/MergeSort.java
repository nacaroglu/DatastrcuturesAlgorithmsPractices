package com.nacaroglu.dsa.practice.recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {

		MergeSort ms = new MergeSort();
		int[] nums = {5,1,1,2,0,0};
		ms.sortArray(nums);
	}

	public int[] sortArray(int[] nums) {
		
		List<Integer> list = new ArrayList<Integer>();
		for (Integer x : nums) {
			list.add(x);
		}
		
		List<Integer> result = mergeSort(list);
		
		for(int i=0; i< nums.length; i++) {
			nums[i] = result.get(i);
		}
		
		return nums;
		
	}

	private List<Integer> mergeSort(List<Integer> list) {
		
		if(list.size()<=1) {
			return list;
		}
		
		int mid = 0 + (list.size())/2;
		
		List<Integer> left =  mergeSort(list.subList(0, mid));
		List<Integer>  right = mergeSort(list.subList(mid,list.size()));
		
		return merge(left,right);		
	}

	private List<Integer> merge(List<Integer> left, List<Integer> right) {
		
		List<Integer> result = new ArrayList<Integer>(left.size()+right.size());
		
		int i=0, j=0;			
		
		while(i<left.size() && j<right.size()) {
			
			if(left.get(i)<right.get(j)) {
				result.add(left.get(i));
				i++;
			}else {
				result.add(right.get(j));
				j++;
			}			
		}
		
		while(i<left.size()) {
			result.add(left.get(i));
			i++;
		}
		
		while(j<right.size()) {
			result.add(right.get(j));
		}
		
		return result;
	}

}
