package com.nacaroglu.dsa.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {

		GroupAnagrams ga = new GroupAnagrams();
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		/*List<List<String>> result = ga.groupAnagrams(strs);
		for (List<String> list : result) {
			for (String s : list) {
				System.out.print(s + ", ");
			}
			System.out.println();
		}
		*/
		System.out.println(ga.groupAnagrams2(strs));
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<List<String>>();
		
		Map<String, List<String>> map = new HashMap();
		
		for (String str: strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String newString = new String(chars);
			if(map.containsKey(newString)) {
				map.get(newString).add(str);
			}else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(newString, list);
			}
		}
		
		for(String s: map.keySet()) {
			List<String> list = map.get(s);
			result.add(list);
		}

		return result;
	}
	
	public String groupAnagrams2(String[] arr) {

		List<List<String>> result = groupAnagrams(arr);
		StringBuilder sb = new StringBuilder();
		
		for (List<String> list : result) {
			sb.append("[");
			for (String s : list) {
				sb.append(s).append(", ");
			}
			
			sb.delete(sb.length()-2, sb.length());
			sb.append("]");
		}
		
		
		return sb.toString();
	}
}
