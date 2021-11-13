package com.nacaroglu.dsa.practice.dynamicprogramming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.HashMap;

public class MaximumSubarray {

	public static void main(String[] args) {

		MaximumSubarray ms = new MaximumSubarray();

		int[] nums = { -2,1,-3,4,-1,2,1,-5,4 };
		//System.out.println(ms.maxSubArray(nums));
		
		/*
		try {
			String s = ms.foo("sArr.txt");
			String t = ms.foo("tArr.txt"); 
			System.out.println(ms.isAnagram(s, t));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//System.out.println(ms.isAnagram("anagram", "nagaram"));
		//System.out.println(ms.isAnagram("rat", "car"));
		
		System.out.println(ms.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(ms.isPalindrome("race a car"));
		
	}
	
	String foo(String fileName) throws IOException {
		InputStream inputStream       = new FileInputStream("d:\\"+ fileName);
		Reader      inputStreamReader = new InputStreamReader(inputStream);
		
		StringBuffer sb = new StringBuffer();

		int data = inputStreamReader.read();
		while(data != -1){
		    char theChar = (char) data;
		    sb.append(theChar);
		    data = inputStreamReader.read();
		}

		inputStreamReader.close();
		
		return sb.toString();
		
	}
	

	public int maxSubArray(int[] nums) {
		
		if(nums==null || nums.length==0) {
			return 0;
		}		
		
		int max = Integer.MIN_VALUE;		
		int prev = 0;
		
		for(int i=0; i<nums.length; i++) {
			
			prev = 0;
			
			for(int j=i; j<nums.length; j++) {
				
				//System.out.println("i:" + i + " j: " + j + " value: " + nums[j]);
				
				int val = nums[j];
				
				if(j>0 && i!=j) {
					val = val + prev;
				}
				
				max = Math.max(val, max);

				prev = val;			
			}			
			
			//System.out.println("------");
		}		
		
		
		
		return max;
	}
	
	
	public boolean isAnagram(String s, String t) {
		 
		 if(s==null && t==null ) { return true; }
		 else {
			 if(s==null || t==null) {
				 return false;
			 }
		 }
		 
		 if(s.length()!= t.length()) {
			 return false;
		 }
		 
		 char[] sArr = s.toCharArray();
		 char[] tArr = t.toCharArray();
		 
		 HashMap<Character, Integer> sMap= buildHash(sArr);
		 HashMap<Character, Integer> tMap= buildHash(tArr);
		 
		 for (Character c : sMap.keySet()) {
			
			 if(!tMap.containsKey(c)) {
				 return false;
			 }
			 
			 if(tMap.get(c).intValue()!=sMap.get(c).intValue()) {
				 return false;
			 }
		}
		 
		 return true;	        
	 }

	 private HashMap<Character, Integer> buildHash(char[] sArr) {
		
		 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 
		 for (int i = 0; i < sArr.length; i++) {
			if(map.containsKey(sArr[i])) {
				map.put(sArr[i], map.get(sArr[i])+1);
			}
			else {
				map.put(sArr[i], +1);
			}
		}
		 
		return map;
	}
	
	public boolean isPalindrome(String s) {
					
		if(s==null ) { return true; }		
		
		s = cleanStr(s);
		
		char sArr[] = s.substring(0, s.length()/2).toCharArray();
		char tArr[];
		
		if(s.length()%2==0) {
			tArr = s.substring(s.length()/2).toCharArray(); 
		}else {
			tArr = s.substring(s.length()/2+1).toCharArray();
		}
		
		 for(int i=0; i< sArr.length; i++) {
			 if(sArr[i]!= tArr[sArr.length-1-i]){
				 return false;
			 }
		 } 
		 
		 return true;	
    }

	private String cleanStr(String s) {
		/*
		 *    if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            System.out.println(c + " is an alphabet.");
        else
            System.out.println(c + " is not an alphabet.");
		 */		
    
		char[] sArr = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for (char c : sArr) {
			if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9' )) {
				
				if((c >= 'A' && c <= 'Z')) {
					 c = (char) ((int) c | 32); // ch is now uppercase
				}
				
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
