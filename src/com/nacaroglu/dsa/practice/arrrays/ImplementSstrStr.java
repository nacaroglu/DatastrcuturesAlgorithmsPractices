package com.nacaroglu.dsa.practice.arrrays;

public class ImplementSstrStr {

	public static void main(String[] args) {
		
		ImplementSstrStr iss = new ImplementSstrStr();
		
		System.out.println(iss.strStr("hello", "ll"));
		System.out.println(iss.strStr("", ""));
		System.out.println(iss.strStr("aaaa", "bba"));
		System.out.println(iss.strStr("ahmet", "mehmet"));
		System.out.println(iss.strStr("helloabclx", "lx"));
		System.out.println(iss.strStr("ahmet", "ahmet"));
		System.out.println(iss.strStr("", "a"));
		System.out.println(iss.strStr("mississippi" , "issip")); 
		System.out.println(iss.strStr("mississippi" , "pi"));

	}
	
	public int strStr(String haystack, String needle) {
		
		if(needle.length()> haystack.length()) {
			return -1;
		}	
		
		if(haystack==null || haystack.length()==0)
			return 0;
		
		if(needle==null || needle.length()==0)
			return 0;	
		
		char[] hArr = haystack.toCharArray();
		char[] nArr = needle.toCharArray();
		
		int nIndex = 0;
		int lastMatchIndex = -1;
		boolean matching = false;
		int hIndex= 0;
		
		while( hIndex<hArr.length) {		
				
			
			if(hArr[hIndex]==nArr[nIndex]) {
				
				if(matching==false) {
					lastMatchIndex= hIndex;
				}
				
				matching = true;
				nIndex++;
			}else {
				
				if(matching) {
					hIndex = lastMatchIndex;
				}
				
				matching =false;				
				nIndex = 0;
			}	
			
			if(nArr.length == nIndex) {
				return hIndex-nArr.length + 1;
			}
			
			hIndex++;
		}
		
		return -1;
		
	}

}
