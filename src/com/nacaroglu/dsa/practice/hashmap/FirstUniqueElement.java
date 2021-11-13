package com.nacaroglu.dsa.practice.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueElement {

	public static void main(String[] args) {
		
		

	}

	public static int findFirstUnique(int[] arr) {
		
		int result = 0;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if(!map.containsKey(i)) {
				map.put(i, 1);
			}else {
				map.put(i, map.get(i)+1);
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(map.get(arr[i])==1) {
				return arr[i];
			}
		}

		return result;
	}
	
	public int firstUniqChar(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}else {
				map.put(c, map.get(c)+1);
			}
		}
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(map.get(c)==1) {
				return i;
			}
		}
		
		return -1;
    }

}
