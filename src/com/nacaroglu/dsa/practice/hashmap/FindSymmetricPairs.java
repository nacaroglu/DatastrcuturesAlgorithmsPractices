package com.nacaroglu.dsa.practice.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSymmetricPairs {

	public static void main(String[] args) {

		int arr[][] = {{1, 2}, {3, 4}, {5, 9}, {9, 5}, {4, 3}};
		System.out.println(findSymmetric(arr));
	}

	public static String findSymmetric(int[][] arr) {

		String result = "";
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i][0], arr[i][1]);
		}
		
		List<List<Integer>> list = new ArrayList();
		
		for(Integer key: map.keySet()) {
			if(map.containsKey((map.get(key))) &&  map.get(map.get(key))==key) {
				List<Integer> subList = new ArrayList<Integer>();
				subList.add(key);
				subList.add(map.get(key));
				list.add(subList);
			}
		}
				
		for(int i=0; i<list.size(); i++) {
			if(i%2==1) {
				continue;
			}
			List<Integer> subList = list.get(i);
			result += "{" + subList.get(0) + ", " + subList.get(1) + "} ";
		}

		// Write - Your - Code
		return result;
	}

}
