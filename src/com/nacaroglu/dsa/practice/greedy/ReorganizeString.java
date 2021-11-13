package com.nacaroglu.dsa.practice.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ReorganizeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReorganizeString ro = new ReorganizeString();
		 System.out.println(ro.reorganizeString("aaabbbccdddd"));
		System.out.println(ro.reorganizeString("vvvlo"));

	}

	public String reorganizeString(String S) {

		StringBuilder result = new StringBuilder();

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < S.length(); i++) {
			if (map.containsKey(S.charAt(i))) {
				map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
			} else {
				map.put(S.charAt(i), 1);
			}
		}	

		char prev = '.';

		while (!map.isEmpty()) {
			
			Character c = findNextChar(map,  prev);			

			if (prev != '.' && c== '.') {
				return "";
			}

			result = result.append(c);

			prev = c;

			int rem = map.get(c);
			if (rem == 1) {
				map.remove(c);
			} else {
				map.put(c, rem - 1);
			}

		}

		return result.toString();
	}

	private Character findNextChar(HashMap<Character, Integer> map, Character prev) {
		
		int max = 0;		
		Character selected = '.';
		
		for(Character c : map.keySet()) {
			
			if(c==prev) {
				continue;
			}
			
			int val = map.get(c);
			
			if(val>max) {
				selected = c;
				max = val;
			}
		}
		
		return selected;
	}

}
