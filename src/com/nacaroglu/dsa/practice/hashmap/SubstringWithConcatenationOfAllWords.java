package com.nacaroglu.dsa.practice.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {

		SubstringWithConcatenationOfAllWords sss = new SubstringWithConcatenationOfAllWords();
		String s = "barfoothefoobarman";
		String[] words = { "bar", "foo" };
		List<Integer> result = sss.findSubstring(s, words);
		for (Integer integer : result) {
			System.out.println(integer + ", ");
		}

	}

	public List<Integer> findSubstring(String s, String[] words) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		int windowSize = words[0].length() * words.length;
		int wordSize = words[0].length();
		
		if(s.length() == windowSize) {
			result.add(0);
			return result;
		}	

		Set<Integer> set = new HashSet<Integer>();
		Map<String, Integer> map = new HashMap<>();
		
		for (String w : words) {
			set.add(w.hashCode());
			
			if(!map.containsKey(w)) {
				map.put(w,1);
			}else {
				map.put(w, map.get(w)+1);
			}
		}	

		

		for (int i = 0; i <= s.length() - windowSize; i++) {
			String window = s.substring(i, i + windowSize);

			Map<String,Integer> windowMap = new HashMap<>();

			for (int j = 0; j < windowSize/wordSize; j++) {

				String item = window.substring(j * wordSize, j * wordSize + wordSize);

				if (!set.contains(item.hashCode())) {
					break;
				}

				if(!windowMap.containsKey(item)) {
					windowMap.put(item,1);
				}else {
					windowMap.put(item, windowMap.get(item)+1);
				}
			}
			
			boolean found = true;

			for(String x : map.keySet()) {
				if(!windowMap.containsKey(x) || windowMap.get(x)!= map.get(x)) {
					found = false;
					break;
				}
			}
			
			if(found) {
				result.add(i);
			}
		}

		return result;
	}

}
