package com.nacaroglu.dsa.practice.recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

	public static void main(String[] args) {
		
		ClimbingStairs cs = new ClimbingStairs();
		
		System.out.println(cs.climbStairs(10));

	}
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public int climbStairs(int n) {
		
		if(map.containsKey(n)) {
			return map.get(n);
		}
		
		int result = 0;
		
		if(n==1) {
			result = 1;		
		}else if (n==2) {
			result = 2;
		}else {
			result = climbStairs(n-2) + climbStairs(n-1);
		}	
				
		map.put(n, result);	
        
        return result;
    }

}
