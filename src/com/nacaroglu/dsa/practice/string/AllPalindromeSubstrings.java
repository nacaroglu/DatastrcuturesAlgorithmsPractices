package com.nacaroglu.dsa.practice.string;

import java.util.HashSet;
import java.util.Set;

public class AllPalindromeSubstrings {

	public static void main(String[] args) {

		System.out.println(isPalindrome("aabbbaa"));
		System.out.println(isPalindrome("aabbbaar"));
		
		System.out.println(findAllPalindromeSubstrings("aabbbaa"));

	}
	
	 public static int findAllPalindromeSubstrings(String input) {
		 
		 int counter = 0;
		 Set<String> set = new HashSet<String>();
	     
		 for(int i=0; i< input.length(); i++) {
			 for(int j=i; j<input.length(); j++) {
				 //System.out.println(input.substring(i, j+1));
				 String subStr = input.substring(i, j+1);
				 if(subStr.length()>1 && set.contains(subStr)) {					 
					 counter++;
				 }
				 else if(subStr.length()>1 && isPalindrome(subStr)) {
					 counter++;
					 set.add(subStr);
				 }
			 }			 
		 }
	      
		 
		 return counter;
	 }
	 
	 public static boolean isPalindrome(String str) {
		 
		 if(str==null || str.length()==0) {
			 return true;
		 }
		 
		 for(int i=0; i<str.length()/2;i++) {
			 
			 if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				 return false;
			 }
		 }
		 
		 
		 return true;
	 }

}
