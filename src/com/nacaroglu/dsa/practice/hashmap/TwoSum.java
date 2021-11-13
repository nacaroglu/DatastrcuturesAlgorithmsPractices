package com.nacaroglu.dsa.practice.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		
		TwoSum ts = new TwoSum();
		
		int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
		//System.out.println(findSum(arr, 27));
		
		int[] arr2 = {2,7,11,15};
		System.out.println(ts.twoSum(arr2, 9));

	}

	public static int[] findSum(int[] arr, int n) {
		
		int[] result = new int[2];
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			int rem = n-arr[i];
			if(set.contains(arr[i])) {
				result[0] = rem;
				result[1] = arr[i];
			}else {
				set.add(rem);
			}
		}
		
		return result; 
	}
	
	public int[] twoSum(int[] arr, int target) {
		
		int[] result = new int[2];
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++) {
			int rem = target-arr[i];
			if(map.containsKey(arr[i])) {
				result[0] = map.get(arr[i]);
				result[1] = i;
			}else {
				map.put(rem, i);
			}
		}
		
		return result; 
	}

}
