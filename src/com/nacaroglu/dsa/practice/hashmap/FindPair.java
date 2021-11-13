package com.nacaroglu.dsa.practice.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {3, 4, 7, 1, 12, 9};
		System.out.println(findPair(arr));

	}

	public static String findPair(int[] arr) {

		String result = "";
		
		Map<Integer, ArrayList<Integer>> mainMap = new HashMap<Integer, ArrayList<Integer>>();
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++) {
			
			ArrayList<Integer> list = new ArrayList<>();
			int current = arr[i];
			mainMap.put(current, list);
			
			for(int j=0; j<arr.length; j++) {
				if(i==j) {
					continue;
				}
				
				int sum = current + arr[j];				
				countMap.put(sum, countMap.getOrDefault(sum, 0)+1);				
				list.add(sum);
			}			
		}
		
		int targetSum = 0;
		for(Integer ts: countMap.keySet()) {
			if(countMap.get(ts)>=4) {
				targetSum = ts;
				break;
			}
		}
		
		int count = 0;
		
		for(Integer key : mainMap.keySet()) {
			if(mainMap.get(key).contains(targetSum) && count<2) {
				result += "{" + key + ", " + (targetSum-key) + "}";
				count++;
			}
		}

		// Write - Your - Code
		return result;
	}

}
