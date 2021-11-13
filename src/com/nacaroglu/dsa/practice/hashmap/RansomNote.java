package com.nacaroglu.dsa.practice.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

	public static void main(String[] args) {

		RansomNote pp = new RansomNote();
		System.out.println(pp.canConstruct("aaab", "aaab"));

	}

	public boolean canConstruct(String ransomNote, String magazine) {

		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < magazine.length(); i++) {
			char c = magazine.charAt(i);

			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		
		for(int i=0; i< ransomNote.length();i++) {
			char c = ransomNote.charAt(i);
			
			if(!map.containsKey(c)) {
				return false;
			}else {
				int count = map.get(c);
				
				if(count>1) {
					map.put(c, map.get(c)-1);
				}else {
					map.remove(c);
				}				
			}
		}

		return true;
	}
}
