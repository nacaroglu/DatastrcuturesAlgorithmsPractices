package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		
		GrayCode gc = new GrayCode();
		List<Integer> result = gc.grayCode(3);
		
		for (Integer r : result) {
			System.out.println(r);
		}
	}
	
	public List<Integer> grayCode(int n) {
		
		List<String> strResult = new ArrayList<String>();		
		backtrack(0, n, new StringBuffer(), strResult);
		
		List<Integer> result = new ArrayList<>();
		
		for (String str : strResult) {			
			result.add(Integer.parseInt(str, 2));
		}
		
		
				
		//Collections.sort(result);
        
        return result;
    }

	private void backtrack(int level, int n, StringBuffer sb, List<String> result) {
		
		if(level == n) {
			result.add(new String(sb.toString()));
			return;
		}
		
		for(int i=0; i<2; i++) {
			sb.append(i);
			backtrack(level+1, n, sb, result);
			sb.deleteCharAt(sb.length()-1);
		}		
	}
}
