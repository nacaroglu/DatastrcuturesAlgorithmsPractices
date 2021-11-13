package com.nacaroglu.dsa.practice.arrrays;

import java.util.HashMap;
import java.util.Map;

public class SortColors {

	public static void main(String[] args) {
		
		SortColors s = new SortColors();
		int[] nums = {2, 0, 0, 1, 2, 1, 0};
		printArr(nums);
		s.sortColors(nums);		
		printArr(nums);

	}

	private static void printArr(int[] nums) {
		for (int i : nums) {
			System.out.print(i + ", ");
		}
		
		System.out.println();
	}
	
	public void sortColors(int[] nums) {
        
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int n: nums) {
			map.put(n, map.getOrDefault(n, 0)+1);
		}
		
		int index = 0;
		for(int i=0; i<3; i++) {
			
			int count = map.get(i);
			
			for(int j=0; j<count; j++) {
				nums[index] = i;
				index++;
			}
		}
		
		
    }

}
