package com.nacaroglu.dsa.practice.arrrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MissignRanges {

	public static void main(String[] args) {
		
		MissignRanges mr = new MissignRanges();
		
		
		int nums[] = {0,1,3,50,75};
		//int nums[] = {10,20,33,50,75};
		List<String> list =  mr.findMissingRanges(nums, 0, 99);
		printList(list);
		
		int nums2[] = new int[0]; 
		List<String> list2 =  mr.findMissingRanges(nums2, 1, 1);
		printList(list2);
		
		int nums3[] = new int[0]; 
		List<String> list3 =  mr.findMissingRanges(nums3, -3, -1);
		printList(list3);
		
		
		int nums4[] = {-1};
		List<String> list4 =  mr.findMissingRanges(nums4, -1, -1);
		printList(list4);
		
		int nums5[] = {-1};
		List<String> list5 =  mr.findMissingRanges(nums5, -2, -1);
		printList(list5);
		
		
		int nums6[] = {-1};
		List<String> list6 =  mr.findMissingRanges(nums6, -1, 0);
		printList(list6);
		

	}

	private static void printList(List<String> list) {
		for (String string : list) {
			System.out.println(string);
		}
		
		System.out.println("-----------------------");
	}
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		
		List<String> list = new ArrayList<String>();
		
		if(nums==null || nums.length==0) {			
			addAllRangetoList(lower, upper, list);			
			return list;
		}
		
		if(upper<nums[0] || lower>nums[nums.length-1]) {			
			addAllRangetoList(lower, upper, list);			
			return list;
		}	
		
		if(lower<nums[0]) {			
			if(lower==nums[0]-1) {
				list.add(String.valueOf(lower));
			}else {
				list.add(lower + "->" + (nums[0]-1));
			}				
		}		
		
		
		int lastFullIndex = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			
			if(nums[i]>lastFullIndex+1) {
				if(nums[i]-1 == lastFullIndex+1) {
					list.add(String.valueOf(lastFullIndex+1));
				}else {
					list.add(lastFullIndex+1 + "->" + (nums[i]-1));
				}				
			}
			
			lastFullIndex = nums[i];
		}
		
		
		if(upper>nums[nums.length-1]) {			
			if(upper==nums[nums.length-1]+1) {
				list.add(String.valueOf(upper));
			}else {
				list.add((nums[nums.length-1]+1) + "->" + upper );
			}				
		}
		
		return list;
		
	}

	private void addAllRangetoList(int lower, int upper, List<String> list) {
		if(lower==upper) {
			list.add(String.valueOf(lower));
		}else {
			list.add(lower + "->" + upper);
		}
	}
	
	public List<String> findMissingRanges2(int[] nums, int lower, int upper) {
        
		List<String> list = new ArrayList<String>();
		
		if(nums==null || nums.length==0) {
			
			addAllRangetoList(lower, upper, list);			
			
			return list;
		}
		
		TreeMap<Integer, Boolean> map = new TreeMap<Integer, Boolean>();
		for(int i=lower; i<=upper; i++){
			map.put(i, false);
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], true);
			}
		}
		
		int lastPresentIndex = Integer.MIN_VALUE;
		int lastMissingIndex = Integer.MIN_VALUE;
		
		if(nums[0]>map.firstKey()) {
			
			if(map.firstKey()==nums[0]-1) {
				list.add(String.valueOf(map.firstKey()));
			}else {
				list.add((map.firstKey() + "->" + (nums[0]-1)));
			}		
		}
		
		for (int i: map.keySet()) {

			
			if(i<nums[0]) {
				continue;
			}
			
			if(map.get(i)) {				
				if(lastMissingIndex+1==i) {
					
					if(lastPresentIndex+1==i-1) {
						list.add(String.valueOf(lastMissingIndex));
					}else {
						list.add((lastPresentIndex+1) + "->" + (i-1));
					}					
					//System.out.println("Range:" + (lastPresentIndex+1) + "-" + (i-1));
				}
				
				lastPresentIndex = i;				
			}
			else {	
				
				lastMissingIndex = i;			
			}
		}
		
		if(nums[nums.length-1]<map.lastKey()) {
			
			if(lastPresentIndex+1==map.lastKey()) {
				list.add(String.valueOf(lastPresentIndex+1));
			}else {
				list.add((lastPresentIndex+1) + "->" + (map.lastKey()));
			}			
		}
		
		return list;
    }

}
