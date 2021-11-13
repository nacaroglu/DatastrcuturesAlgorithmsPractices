package com.nacaroglu.dsa.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		
		  int dec = 25;
	      // converting to binary and representing it in a string
	      String bin = Integer.toBinaryString(dec);
	      System.out.println(bin);
	      
	      String str2 = String.format("%10s", bin).replace(' ', '0');
	      System.out.println(str2);
		
		Subsets ss = new Subsets();
		
		int nums[] = {1,2,3};
		
		ss.subsets(	nums);

	}
	
	public List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i= 0; i< (int)Math.pow(2, nums.length); i++) {
			//System.out.print("{ ");
			ArrayList<Integer> lInner = new ArrayList<Integer>();
			 for(int j = 0;j < nums.length;++j)
				 if ((i & (1 << j)) > 0)	  {
					   //System.out.print(nums[j] + " ");
					   lInner.add(nums[j]);
				 }
	                 
			 //System.out.println("}"); 
			 result.add(lInner);
		}
		
		
		return result;        
    }

}
