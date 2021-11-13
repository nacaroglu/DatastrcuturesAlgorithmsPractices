package com.nacaroglu.dsa.practice.arrrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ProductExceptSelf {

	public static void main(String[] args) {

		ProductExceptSelf ps = new ProductExceptSelf();

		int nums[] = { 1, 2, 3, 4 };
	//	ps.productExceptSelf(nums);
		
		String str = "ahmet";
		
		
		String strs[] = {"duh","ill"};
		//ps.groupAnagrams(strs);
		
		ps.lengthOfLongestSubstring("dvdf");

	}

	public int lengthOfLongestSubstring(String s) {

		HashSet<Character> set = new HashSet<Character>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		int startIndex = 0;

		for (int i = 0; i < s.length(); i++) {

			startIndex = i;

			for (int j = i; j < s.length(); j++) {

				if (set.contains(s.charAt(j))) {
					String subStr = s.substring(startIndex, j);
					map.put(subStr, subStr.length());
					set.clear();
					startIndex = j;
				}

				set.add(s.charAt(j));
			}
			
			Character[] chars = new Character[set.size()]; 
			set.toArray(chars);

			//String x = String.copyValueOf(chars);			
			//map.put(x.toString(), x.toString().length());
			//set.clear();
		}

		int maxSize = set.size();

		for (String str : map.keySet()) {
			if (map.get(str) > maxSize) {
				maxSize = map.get(str);
			}
		}

		return maxSize;
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i=0; i<strs.length; i++){
            
        	String hashValue = calculateHash(strs[i]);
            
            if(map.containsKey(hashValue)){
                List<String> list = map.get(hashValue);
                list.add(strs[i]);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(hashValue, list);
            }
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        for(String key: map.keySet()) {
        	result.add(map.get(key));
        }
        
        return result;
    }
    
    private static String calculateHash( String str) {    	    	    	
		
		char[] chars = str.toCharArray();		
		Arrays.sort(chars);
		
		return String.valueOf(chars);
	}

	
	public int[] productExceptSelf(int[] nums) {

		int result[] = new int[nums.length];

		
		
		for (int i = 0; i < result.length; i++) {
						
			int carpim = 1;
			for(int j=0; j< nums.length; j++) {
				
				if(i==j) {
					continue;
				}
				
				carpim = carpim * nums[j];
			}
			
			result[i] = carpim;			
		}

		return result;
	}

}
