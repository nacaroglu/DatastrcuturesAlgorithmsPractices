package com.nacaroglu.dsa.practice._mixed;

import java.util.Arrays;
import java.util.Collections;

public class PermuteArray {
	
	public static void main(String[] args) {	
		
		
		//int[] P = {2,0,1,3};		
		//char[] A = {'a', 'b', 'c', 'd'};
		
		//int[] P = {4,2,3,5,1,0};		
		//char[] A = {'a', 'b', 'c', 'd', 'e', 'f'};
		
		//char[] result = permute2(A, P);
		
		
		//int nums[] = {8,3,9,4,2};
		int nums[] = {6,2,1,5, 4,3,0};
		nextPermutation(nums);
		
	}

	private static char[] permute(char[] a, int[] p) {
		
		for(int i=0; i<a.length; i++) {
			
			if(a[i]==a[p[i]]) {
				continue;
			}
			
			char sourceVal = a[i];
			char destinationVal = a[p[i]];
			
			a[p[i]]= sourceVal;
			a[i] = destinationVal;			
		}
		
		return a;
	}
	
	private static char[] permute2(char[] a, int[] p) {
		
		for(int i=0; i<a.length; i++) {
			
			while(p[i]!=i) {
				
				char sourceVal = a[i];
				char destinationVal = a[p[i]];
				
				a[p[i]]= sourceVal;
				a[i] = destinationVal;
				
				int sourceIndex = p[i];
				int destIndex = p[p[i]];
				p[i] = destIndex;
				p[sourceIndex] = sourceIndex;
			}						
		}
		
		return a;
	}
	
	public static int[] nextPermutation(int[] nums) {
		
		for(int i=nums.length-1; i>0; i--) {
			
			if(nums[i]>nums[i-1]) {								
				int greaterThanPrevIndex = findGreaterThanPrev(nums,i, nums[i-1]);
				
				int current = nums[i-1];
				int temp = nums[greaterThanPrevIndex];
				nums[greaterThanPrevIndex] =current;
				nums[i-1] = temp;				
				
				return nums;
			}			
		} 
		
		return null;
    }

	private static int findGreaterThanPrev(int[] nums, int index, int prev) {
		
		Arrays.sort(nums,index, nums.length);
		
		for(; index<nums.length; index++) {
			if(nums[index]>prev) {
				return index;
			}
		}
		
		return 0;
	}
}
