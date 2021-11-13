package com.nacaroglu.dsa.practice.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		
		SubarraySumEqualsK s = new SubarraySumEqualsK();

		int[] arr = {6, 4, -7, 3, 12, 9};
		System.out.println(findSubZero(arr));
		
		//System.out.println(s.subarraySum(arr,3));
	}

	public static boolean findSubZero(int[] arr) {
		
		HashMap < Integer,Integer > hMap = new HashMap < >();

		
		 int sum = 0;

		    // Traverse through the given array
		    for (int i = 0; i < arr.length; i++) {
		      sum += arr[i];

		      if (arr[i] == 0 || sum == 0 || hMap.get(sum) != null) return true;

		      hMap.put(sum, i);
		    }

		    return false;
	}
	
	public int subarraySum(int[] arr, int k) {
        
		Map<Integer, Integer> map;
		int resultCount = 0;
		
		for(int j=0; j<arr.length; j++) {
			
			int sum = 0;
			map = new HashMap<Integer, Integer>();
		
			for(int i=j; i<arr.length; i++) {
				sum += arr[i];
				
				map.put(i, sum);
				
				if(sum==k) {
					resultCount++;
				}						
			}		
		}		

		return resultCount;
    }

}
