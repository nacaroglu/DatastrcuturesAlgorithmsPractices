package com.nacaroglu.dsa.practice.arrrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSumLessThanK {

	public static void main(String[] args) {

		// [358,898,450,732,672,672,256,542,320,573,423,543,591,280,399,923,920,254,135,952,115,536,143,896,411,722,815,635,353,486,127,146,974,495,229,21,733,918,314,670,671,537,533,716,140,599,758,777,185,549]
		//1800
		
		int nums[] = {358,898,450,732,672,672,256,542,320,573,423,543,591,280,399,923,920,254,135,952,115,536,143,896,411,722,815,635,353,486,127,146,974,495,229,21,733,918,314,670,671,537,533,716,140,599,758,777,185,549};
		TwoSumLessThanK ts = new TwoSumLessThanK();
		System.out.println(ts.twoSumLessThanK(nums, 1800));
		
		HashMap<Integer, List<Integer>> scores = new HashMap<Integer, List<Integer>>();
		

	}
	

	
	public int twoSumLessThanK(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int endIndex = nums.length;
        int max = -1;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>k){
                endIndex = i;            
                break;
            }
        }
        
        if(endIndex<=1){
            return max;
        }
        
        for(int i=0; i< endIndex; i++){
            for(int j=i+1; j< endIndex; j++){
                int sum = nums[i] + nums[j];
                if(sum<k){
                    max = Math.max(max, sum);
                }
            }
        }
        
        return max;
    }

}
