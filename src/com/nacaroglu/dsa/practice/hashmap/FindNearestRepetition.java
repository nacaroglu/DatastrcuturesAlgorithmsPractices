package com.nacaroglu.dsa.practice.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNearestRepetition {

	public static void main(String[] args) {

		
		String[] arr = { "All", "work", "and", "no", "play",
				"makes", "for", "no", "work", "no", "fun", "and", "no", "results" };
		
		List<String> paragraph = Arrays.asList(arr);
		
		System.out.println(findNearestRepetition(paragraph));

	}
	
	public static int findNearestRepetition(List<String> paragraph){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int result = Integer.MAX_VALUE;
		
		for(int i=0; i<paragraph.size(); i++) {
			
			if(map.containsKey(paragraph.get(i))) {				
				int prevIndex = map.get(paragraph.get(i));
				result = Math.min(result, i-prevIndex);				
			}
			
			map.put(paragraph.get(i), i);
			
		}		
		
		return result;
	}

}
