package com.nacaroglu.dsa.practice.arrrays;

public class TwoSum2 {

	public static void main(String[] args) {
		
		TwoSum2 ts = new TwoSum2();
		
		int[] numbers = {2,7,11,15};
		
		System.out.println(ts.twoSum(numbers, 9));
		
		int[] numbers2 = {2,3,4};
		
		System.out.println(ts.twoSum(numbers2, 6));
		
		int[] numbers3 = {-1,0};
		
		System.out.println(ts.twoSum(numbers3, -1));
		
	}
	
	public int[] twoSum(int[] numbers, int target) {
		
		int firstIndex = 0;
		
		int secondIndex = 0;
		
		for (firstIndex = 0; firstIndex < numbers.length; firstIndex++) {
			
			int remaining = target - numbers[firstIndex];
			
			secondIndex = findSecondIndex(numbers, remaining, firstIndex);
			
			if(secondIndex!=-1) {
				int[] result = {firstIndex+1, secondIndex+1};
				return result;
			}
		}
        
		
		return null;
    }

	private int findSecondIndex(int[] numbers, int remaining, int firstIndex) {
		
		for (int i = firstIndex+1; i < numbers.length; i++) {
			
			if(numbers[i]==remaining) {
				return i;
			}
		}
		
		return -1;
	}
}
