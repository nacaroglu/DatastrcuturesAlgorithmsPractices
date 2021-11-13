package com.nacaroglu.dsa.practice.arrrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs ={"flower","flow","flight"};
		System.out.println(lcp.longestCommonPrefix(strs));
		String[] strs1 = {"dog","racecar","car"};
		//System.out.println(lcp.longestCommonPrefix(strs1));		

	}
	
	 public String longestCommonPrefix(String[] strs) {
		 
		 if(strs.length==0) {
			 return "";
		 }
		 
		 if(strs.length==1) {
			 return strs[0];
		 }
		 
		 int minSizeIndex = findMinSizeIndex(strs);
		 
		 StringBuffer sb = new StringBuffer();
		 
		 String pivot = strs[minSizeIndex];
	        
		for (int i = 0; i < strs[minSizeIndex].length(); i++) {
			
			char currentChar = pivot.charAt(i);
			
			if(!othersHasChar(strs, i, currentChar)) {
				break;
			}else {
				sb.append(currentChar);
			}
		}
		
		if(sb.length()==0) {
			return "";
		}
		 
		 return sb.toString();
	 }

	private boolean othersHasChar(String[] strs, int i, char currentChar) {
		
		for (int j = 0; j < strs.length ; j++) {
			
			if(currentChar!=strs[j].charAt(i)) {
				return false;
			}
		}
		
		return true;
	}

	private int findMinSizeIndex(String[] strs) {
		
		int minSize= strs[0].length();
		int minIndex = 0;
		
		for (int i = 1; i < strs.length; i++) {
			
			if(strs[i].length()< minSize) {
				minSize = strs[i].length();
				minIndex = i;
			}
		}
		
		return minIndex;
	}

}
