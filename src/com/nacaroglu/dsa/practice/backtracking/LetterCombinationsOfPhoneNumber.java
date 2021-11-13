package com.nacaroglu.dsa.practice.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		
		LetterCombinationsOfPhoneNumber lcpn = new LetterCombinationsOfPhoneNumber();
		List<String> result = lcpn.letterCombinations("79");
		
		System.out.println(result.size());
		System.out.println(result);

	}
	
	public List<String> letterCombinations(String digits) {
		
		List<String> result = new ArrayList<String>();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");		
        
		result = backtrack(digits.toCharArray(),0, map, result);
		
		return result;
    }

	private List<String> backtrack(char[] digitsArr, int index, HashMap<String, String> map, List<String> result ) {
		
		if(index==digitsArr.length) {
			return result;
		}
		
		char newChars[] = map.get(String.valueOf(digitsArr[index])).toCharArray();
		
		List<String> newList = new ArrayList<String>();
		
		if(index==0) {
			for(int j=0; j<newChars.length; j++) {
				newList.add(String.valueOf(newChars[j]));
			}
		}else{
			for(int i=0; i<result.size();i++) {
				
				for(int j=0; j<newChars.length; j++) {
					newList.add(result.get(i)+newChars[j]);
				}			
			}
		}	
		
		return backtrack(digitsArr, index+1, map, newList);
	}

}
