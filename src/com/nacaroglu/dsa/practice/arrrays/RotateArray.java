package com.nacaroglu.dsa.practice.arrrays;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RotateArray ra = new RotateArray();
		
		int[] nums = {1,2,3,4,5,6,7};
		ra.rotate(nums, 3);
		
		int[] nums2 = {-1,-100,3,99};
		ra.rotate(nums2, 2);
		
		

	}
	
	public void rotate(int[] nums, int k) {
		
		if(nums==null || nums.length==0 || nums.length == 1) {
			return;
		}
		
		k=k%nums.length;
		
		for (int i = 0; i < k; i++) {
			rotateOne(nums);  
		}		
    }

	private void rotateOne(int[] nums) {
		int first = nums[nums.length-1];
		
		for (int i = nums.length-1; i >0; i--) {
			nums[i] = nums[i-1];
		}
		
		nums[0] = first;
	}
}
