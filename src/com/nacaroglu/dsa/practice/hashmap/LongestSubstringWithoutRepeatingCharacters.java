package com.nacaroglu.dsa.practice.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongestSubstringWithoutRepeatingCharacters x = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(x.lengthOfLongestSubstring("pwwkew"));		
		System.out.println(x.lengthOfLongestSubstring("bbbbb"));
		System.out.println(x.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(x.lengthOfLongestSubstring(""));		
		System.out.println(x.lengthOfLongestSubstring("aab"));

	}
	
	public int lengthOfLongestSubstring(String s) {
        
		if (s == null || s.length() == 0)
			return 0;
		
		int result = 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		
		
		for(int size=1; size<=s.length(); size++) {
			
			map = new HashMap<Character, Integer>();				
			
			for(int i=0; i< size; i++) {				
				char c = s.charAt(i);			
				
				addToMap(map, c);
			}
			
			if(map.size()==size) {
				result = Math.max(result, size);
			}		
			
			for(int i= size; i<s.length(); i++) {
				char oldChar = s.charAt(i-size);
				char newChar = s.charAt(i);	
				
				if(oldChar==newChar) {
					continue;
				}
				
				addToMap(map, newChar);				
				removeFromMap(map, oldChar);			
				
				if(map.size()==size) {
					result = Math.max(result, size);
				}	
			}			
		}
		
		return result;
    }

	private void removeFromMap(Map<Character, Integer> map, char oldChar) {
		if(map.get(oldChar)==1) {
			map.remove(oldChar);
		}else {
			map.put(oldChar, map.get(oldChar)-1);
		}
	}

	private void addToMap(Map<Character, Integer> map, char c) {
		if(!map.containsKey(c)) {
			map.put(c, 1);
		}else {
			map.put(c, map.get(c)+1);
		}
	}

}
