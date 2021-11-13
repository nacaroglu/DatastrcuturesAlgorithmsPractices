package com.nacaroglu.dsa.practice.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TracePath {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("NewYork", "Chicago");
		map.put("Boston", "Texas");
		map.put("Missouri", "NewYork");
		map.put("Texas", "Missouri");
		
		//System.out.println(tracePath(map));
		
		TracePath tp = new TracePath();
		
		String[][] paths = {{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}};		
		List<List<String>> pathList = buildPathList(paths);	
		//System.out.println(tp.destCity(pathList));
		
		String[][] letterPaths = {{"B","C"},{"D","B"},{"C","A"}};
		System.out.println(tp.destCity(buildPathList(letterPaths)));
	}

	private static List<List<String>> buildPathList(String[][] paths) {
		List<List<String>> pathList = new ArrayList<List<String>>();
		
		for (String[] path : paths) {
			List<String> pList = new ArrayList<>();
			pList.add(path[0]);
			pList.add(path[1]);
			pathList.add(pList);
		}
		return pathList;
	}
	
	public static String tracePath(Map<String,String> map) {

	    String result = "";
	    
	    String startCity = "";
	    
	    for(String city : map.keySet()) {
	    	if(!map.containsValue(city)) {
	    		startCity = city;
	    		break;		
	    	}
	    }
	    
	    result += startCity + "->" + map.get(startCity)+ ", ";
	    startCity = map.get(startCity);
	    
	    while(map.containsKey(startCity)) {
	    	result += startCity + "->" + map.get(startCity)+ ", ";
		    startCity = map.get(startCity);
	    }

	    // Write - Your - Code        
	    return result;	    
	  }
	
	public String destCity(List<List<String>> paths) {       
		
		Map<String,String> map = new HashMap<String, String>();
		
		for (List<String> list : paths) {
			map.put(list.get(0), list.get(1));
		}
		
		String destCity = "";

		for (String city : map.values()) {
			if (!map.containsKey(city)) {
				destCity = city;
				break;
			}
		}
		
		return destCity;
    }
	

}
