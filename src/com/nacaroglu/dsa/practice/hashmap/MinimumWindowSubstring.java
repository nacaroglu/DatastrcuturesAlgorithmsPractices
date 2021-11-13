package com.nacaroglu.dsa.practice.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
	
	public static void main(String args[]) {
		
		MinimumWindowSubstring mwss = new MinimumWindowSubstring();
		System.out.println(mwss.minWindow("abc", "ac"));
	}
	
	
	public String minWindow(String s, String t) {
    
		String result = null;
		
		if(s.length()<t.length()) {
			return result;
		}
		
		Map<Character, Integer> tMap = buildMapOfString(t);
		
		HashSet<String> failedSet = new HashSet<>();
		
		for(int subStringSize=t.length(); subStringSize<=s.length(); subStringSize++) {
			
			Map<Character, Integer> subMap = buildMapOfString(s.substring(0,subStringSize));
			int i= subStringSize;
			String subString = s.substring(i-subStringSize,i);
						
			do {
				
				//System.out.println(subString);
				
				if(failedSet.contains(subString)) {
					continue;
				}
				
				if(contains(subMap, tMap)) {
					return subString;
				}else {
					failedSet.add(subString);
					
					if(i==s.length()) {
						break;
					}
					
					char newChr = s.charAt(i); 
					char oldChr = s.charAt(i-subStringSize);			
					
					adjustShiftRight(subMap, newChr, oldChr);
					
				}		
				i=i+1;
				subString = s.substring(i-subStringSize,i);
			}while(i<=s.length());
			
			
			System.out.println();
		}		
		
		return result;
    }

	private int adjustShiftRight(Map<Character, Integer> subMap, char newChr, char oldChr) {
		
		int oldCharCount = subMap.get(oldChr);
		if(oldCharCount==1) {
			subMap.remove(oldChr);
		}else {
			subMap.put(oldChr, oldCharCount-1);
		}
		
		if(!subMap.containsKey(newChr)) {
			subMap.put(newChr,1);
		}else {
			subMap.put(newChr, subMap.get(newChr)+1);
		}
		return oldCharCount;
	}

	private boolean contains(Map<Character, Integer> subMap, Map<Character, Integer> tMap) {
		
		
		Set<Character> set = tMap.keySet();
		
		
		for (Character character : set) {
			
			char c = (char)character;
			int val = tMap.get(c);		
			 
	         if(!subMap.containsKey(c)) {
	        	 return false;
	         }
	         
	         if(subMap.get(c)!=val) {
	        	 return false;
	         }
	    }	
		
		return true;
	}

	private Map<Character, Integer> buildMapOfString(String t) {
		
		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		
		for(int i=0;i<t.length(); i++) {
			char c = t.charAt(i);
			
			if(tMap.containsKey(c)) {
				tMap.put(c, tMap.get(c)+1);
			}else {
				tMap.put(c, 1);
			}
		}
		
		return tMap;
	}
}

