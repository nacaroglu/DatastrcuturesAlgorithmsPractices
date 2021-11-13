package com.nacaroglu.dsa.practice.string;

public class LookAndSay {

	public static void main(String[] args) {
		
		LookAndSay ls = new LookAndSay();
		System.out.println(ls.lookAndSay(8));		

	}
	
	
	public String lookAndSay(int num) {
		
		String result= "1";
		
		for(int i=1; i<num; i++) {			
			result = helper(result);
		}
		
		return result;
	}


	private String helper(String str) {
		
		StringBuffer result = new StringBuffer();
		
		char current = str.charAt(0);
		int count = 1;
		
		for(int i=1;i<str.length(); i++) {
			
			if(str.charAt(i)==current) {
				count++;
			}else {
				result.append(String.valueOf(count)).append(current);
				count=1;
				current=str.charAt(i);
			}
		}
		
		result.append(String.valueOf(count)).append(current);
		
		return result.toString();
	}
}
