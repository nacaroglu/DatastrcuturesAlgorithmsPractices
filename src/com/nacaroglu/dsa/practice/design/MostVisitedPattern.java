package com.nacaroglu.dsa.practice.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MostVisitedPattern {

	public static void main(String[] args) {
		
		/*
		 * username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], 
		 * timestamp = [1,2,3,4,5,6,7,8,9,10], 
		 * website = ["home","about","career","home","cart","maps","home","home","about","career"]
			Output: ["home","about","career"]
		 */
		
		String[] userName = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
		String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
		int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
		
		MostVisitedPattern mvp = new MostVisitedPattern();
		System.out.println(mvp.mostVisitedPattern(userName, timestamp, website));
		
		Arrays.sort(userName);
	}

	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		
		

		List<String> result = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < website.length; i++) {
			if (map.containsKey(website[i])) {
				map.put(website[i], map.get(website[i]) + 1);
			} else {
				map.put(website[i], 1);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(map.values());
		Collections.sort(list);
		Collections.reverse(list);
		
		int listIndex = 0;
		while(result.size()<3  && listIndex<list.size()) {
			
			int val = list.get(listIndex);
			List<String> countList = getFromMap(map, val);
			
			if(countList.size()==1) {
				result.add(countList.get(0));
			}else {
				Collections.sort(countList);
				for (String s : countList) {
					result.add(s);
				}
			}
			
			listIndex++;
		}
		
		result = result.subList(0, 3);

		return result.subList(0, 3);
	}

	private List<String> getFromMap(HashMap<String, Integer> map, int count) {
		
		List<String> coutList = new ArrayList<String>();
		
		for(String s : map.keySet()) {
			if(map.get(s)== count) {
				coutList.add(s);
			}
		}
		
		return coutList;
	}

}
