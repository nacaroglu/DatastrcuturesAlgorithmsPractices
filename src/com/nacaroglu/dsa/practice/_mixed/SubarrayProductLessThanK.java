package com.nacaroglu.dsa.practice._mixed;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {

	public static void main(String[] args) {
		
		
		
		SubarrayProductLessThanK sp = new SubarrayProductLessThanK();
		
		int[] arr = {8, 2, 6, 5};
		
		List<List<Integer>> result = sp.findSubarrays(arr, 50);
		printListOfList(result);

	}
	
	private static void printListOfList(List<List<Integer>> result) {
		for (List<Integer> list : result) {
			System.out.print("{");
			for(Integer i: list){
				System.out.print(i+ ",");
			}
			System.out.println("}");
		}
	}

	public List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> subarrays = new ArrayList();
		
		for(int windowSize=1; windowSize<=arr.length; windowSize++) {
			
			List<Integer> current = new ArrayList<Integer>();
			
			int windowProduct = 1;
			for(int i=0; i<windowSize; i++) {
				windowProduct *= arr[i];
				current.add(arr[i]);
			}
			
			if(windowProduct<target) {
				subarrays.add(new ArrayList<Integer>(current));
			}
			
			for(int i=windowSize; i<arr.length; i++) {
				windowProduct = windowProduct / arr[i-windowSize] * arr[i];
				current.remove(Integer.valueOf(arr[i-windowSize]));
				current.add(arr[i]);
				if(windowProduct<target) {
					subarrays.add(new ArrayList<Integer>(current));
				}
			}
		}

		return subarrays;
	}

}
