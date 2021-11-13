package com.nacaroglu.dsa.practice.hashmap;

import java.util.HashSet;
import java.util.Set;

public class IsSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = {9,4,7,1,-2,6,5};
		int[] arr2 = {7,1,-2};
		
		System.out.println(isSubset(arr1, arr2));
		
		int[] arr3 = {9,4,3,1,-2,6,5};
		int[] arr4 = {4,7,10,8};
		
		System.out.println(isDisjoint(arr3, arr4));
		
	}
	

	public static boolean isSubset(int[] arr1, int[] arr2) {
		
		if(arr1==null || arr2==null) {
			return true;
		}
		
		int big[] = arr1;
		int small[] = arr2;
		
		if(arr1.length<arr2.length) {
			big = arr2;
			small = arr1;
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (Integer x : big) {
			set.add(x);
		}
		
		for(Integer y: small) {
			if(!set.contains(y)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static Object isDisjoint(int[] arr1,int[] arr2) {

		if(arr1==null || arr2==null) {
			return true;
		}
		
		int big[] = arr1;
		int small[] = arr2;
		
		if(arr1.length<arr2.length) {
			big = arr2;
			small = arr1;
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (Integer x : big) {
			set.add(x);
		}
		
		for(Integer y: small) {
			if(set.contains(y)) {
				return false;
			}
		}
		
		return true;    
	 } 

}
