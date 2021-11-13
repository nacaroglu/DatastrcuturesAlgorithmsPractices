package com.nacaroglu.dsa.practice.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {
	
	final int BASE = 26;
	final int MODE = 31;

	public static void main(String[] args) {
		
		StringSegmentation ss = new StringSegmentation();
		
		String s = "applepie";
		Set<String> dictionary = buildDictinary();
		
		//System.out.println(ss.canSegmentString(s, dictionary));
		//System.out.println(ss.canSegmentString("applepeer", dictionary));
		//System.out.println(ss.canSegmentString("catsandog", dictionary));
		System.out.println(ss.wordBreak("applepenapple", dictionary));

	}

	private static Set<String> buildDictinary() {
		Set<String> dictionary = new HashSet<String>();
		/*
		dictionary.add("apple");
		dictionary.add("pie");
		dictionary.add("pear");
		dictionary.add("pier");*/
		
		//String arr[] = {"cats","dog","sand","and","cat"};
		String arr[] = {"apple","pen"};
		dictionary = new HashSet<String>(Arrays.asList(arr));
		
		return dictionary;
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		
		HashMap<Integer, String> map = createMap(wordDict);
		
		int lastIndex = 0;
		int hash=0;
		
		for(int i=0; i< s.length(); i++) {
			
			hash = reComputeHash(hash, s.charAt(i));
			
			if(map.containsKey(hash)) {
				
				if(s.substring(lastIndex, i+1).equalsIgnoreCase(map.get(hash))) {
					hash = 0;
					lastIndex = i+1;
				}				
			}
		}
		
		return lastIndex==s.length();
	}

	private HashMap<Integer, String> createMap(Set<String> dictionary) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		for (String str : dictionary) {
			map.put(computeHash(str), str);
		}
		
		return map;
	}

	private Integer computeHash(String str) {		
		
		int hash = 0;
		
		for(int i=0; i<str.length(); i++) {
			hash = hash * BASE + str.charAt(i);
		}
		
		return hash;
	}
	
	private Integer reComputeHash(int hash, char chr) {		
			
		return hash * BASE + chr;
	}
}
