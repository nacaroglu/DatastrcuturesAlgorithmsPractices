package com.nacaroglu.dsa.practice.hashmap;

import java.util.HashMap;
import java.util.Hashtable;

public class PalindromePermutation {

	public static void main(String[] args) {

		PalindromePermutation pp = new PalindromePermutation();
		System.out.println(pp.canPermutePalindrome("xxxcareracx"));

	}

	public boolean canPermutePalindrome(String s) {

		if (s == null || s.length() < 1) {
			return true;
		}

		HashMap<String, Integer> table = new HashMap<>();
		
		for(int i=0; i<s.length();i++) {
			int count = 0;
			if(table.containsKey(s.substring(i,i+1))) {
				count = table.get(s.substring(i,i+1));
			}
			count += 1;
			table.put(s.substring(i,i+1), count);			
		}
		
		boolean flag = false;
		
		for(String c: table.keySet()) {
			
			if(table.get(c)%2==0) {
				continue;
			}
			
			if((table.get(c)%2==1) && flag) {
				return false;
			}else {
				flag = true;
			}
		}
		

		return true;

	}

}
