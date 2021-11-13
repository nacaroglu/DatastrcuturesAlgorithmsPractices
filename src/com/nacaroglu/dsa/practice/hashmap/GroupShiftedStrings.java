package com.nacaroglu.dsa.practice.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {

	public static void main(String[] args) {

		String strings[] =  {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		
		//String strings[] =  {"az", "ba"};
		
		GroupShiftedStrings g = new GroupShiftedStrings();
		List resultList = g.groupStrings(strings);
		
		System.out.println(resultList.size());

	}

	public List<List<String>> groupStrings(String[] strings) {

		HashMap<String, List> map = buildMap(strings);

		List resultList = new ArrayList<>();

		for (String key : map.keySet()) {
			resultList.add(map.get(key));
		}

		return resultList;

	}

	public HashMap<String, List> buildMap(String strings[]) {

		HashMap<String, List> map = new HashMap<String, List>();

		for (int i = 0; i < strings.length; i++) {

			char[] chars = strings[i].toCharArray();

			String hash = "";

			for (int j = chars.length - 1; j > 0; j--) {

				int localDiff = chars[j] - chars[j - 1];
				
				if (localDiff < 0) {
					localDiff = 26 + localDiff;
				}

				if (j == chars.length - 1) {
					hash = String.valueOf(localDiff);
					continue;
				}			

				hash = hash+String.valueOf(localDiff);
			}

			

			List<String> list = null;
			if (!map.containsKey(hash)) {
				list = new ArrayList<String>();
			} else {
				list = map.get(hash);
			}

			list.add(strings[i]);
			map.put(hash, list);
			
		}

		return map;

	}

}
