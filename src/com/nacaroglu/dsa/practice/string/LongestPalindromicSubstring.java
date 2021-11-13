package com.nacaroglu.dsa.practice.string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
	
		System.out.println(findLPSLength("Ahmet"));
	}
	
	 public static int findLPSLength(String st) {
		 
		 StringBuilder suffix = new StringBuilder();
		 suffix.append(st);
		 
		 StringBuilder prefix = new StringBuilder();
		 
		 
		 for(int i=0; i< st.length(); i++) {
			 
			 suffix = suffix.deleteCharAt(i);
			 prefix.append(st.charAt(i));
			 
			 System.out.println(prefix.toString()+suffix.toString());
		 }
		 
		 return 0;
	 }

}
