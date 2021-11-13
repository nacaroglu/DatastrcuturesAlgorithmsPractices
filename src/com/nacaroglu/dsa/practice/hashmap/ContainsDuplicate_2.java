package com.nacaroglu.dsa.practice.hashmap;

import java.util.*;

public class ContainsDuplicate_2 {

	public static void main(String[] args) {
		
		ContainsDuplicate_2  cd2= new ContainsDuplicate_2();
		int[] nums= {1,2,3,1,2,3 };
		System.out.print(cd2.containsNearbyDuplicate(nums, 2));
		
		

	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
		
		for(int i=0; i<nums.length; i++) {
			PriorityQueue<Integer> q;
			if(!map.containsKey(nums[i])) {
				q = new PriorityQueue<Integer>();				
			}else {
				q = map.get(nums[i]);
			}			
			q.add(i);
			map.put(nums[i],q);
		}
		
		for(Integer x: map.keySet()) {
			PriorityQueue<Integer> q = map.get(x);
			if(q.size()==1) {
				continue;
			}
			
			int prev = q.poll();			
			while(!q.isEmpty()) {
				int curr = q.poll();
				
				if(Math.abs(curr-prev)<=k) {
					return true;
				}
				
				prev = curr;
			}
		}		
		
		return false;        
    }

}
