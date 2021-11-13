package com.nacaroglu.dsa.practice.string;

public class MyAtoi {

	public static void main(String[] args) {

		String s = "+";
		
		MyAtoi a = new MyAtoi();
		System.out.println(a.myAtoi(s));

	}

	public int myAtoi(String s) {	
				
		if(s==null || s.length()==0) 
			return -1;
		
				
		int index = 0;
		int l = s.length();
		
		// clear white spaces
		while(index < l && Character.isSpace(s.charAt(index))) {
			index++;
		}
		
		if(index==l) {
			return -1;
		}
		
		// determine sign
		boolean isNegative = false;
		if(s.charAt(index)=='-') {
			isNegative = true;
			index++;
		}else if(s.charAt(index)=='+') {
			index++;
		}
		
		// first char must be numeric
		if(!( index<s.length() && s.charAt(index)>='0' && s.charAt(index)<='9')) {
			return 0;
		}
		
		// determine actual numeric part
		int startIndex = index;
		while(index<s.length()&& s.charAt(index)>='0' && s.charAt(index)<='9'){
			index++;
		}
		
		int endIndex = index;
		
		long counter = 1;
		long sum = 0;
		for(int i=endIndex-1; i>=startIndex; i--) {
			
			long current = (s.charAt(i) - '0') * counter;
			
			if(isNegative) {
				sum -= current;
			}else {
				sum += current;
			}			
			
			counter= counter*10;
			
			if(sum>=Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}else if(sum<=Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
		}
		
		return (int)sum;

	}

}
