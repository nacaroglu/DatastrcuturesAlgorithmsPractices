package com.nacaroglu.dsa.practice.string;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncoding {
	
	public static class CharCount{
		
		char chr;
		int count;
		
		public CharCount(char chr, int count) {
			super();
			this.chr = chr;
			this.count = count;
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RunLengthEncoding r = new RunLengthEncoding();
		System.out.println(r.decoding("3e4f2e"));
		System.out.println(r.encoding("eeeffffee"));
	}
	
	public String decoding(String s) {
		StringBuilder sb = new StringBuilder();
		
		// The decoding of "3e4f2e" returns "eeeffffee".		
		int index =0; 
		
		List<CharCount> list = new  ArrayList<CharCount>();
		
		while(index<s.length()) {
			
			StringBuilder sbx = new StringBuilder();
			
			while(Character.isDigit(s.charAt(index))) {			
				sbx.append(s.charAt(index));
				index++;			
			}
			
			int count = Integer.valueOf(sbx.toString());				
			list.add(new CharCount(s.charAt(index), count));
			
			index++;			
		}
		
		for (CharCount cc : list) {
			for(int i=0; i< cc.count; i++) {
				sb.append(cc.chr);
			}
		}
		
		return sb.toString();
	}
	
	public String encoding(String s) {
		// of "aaaabcccaa" is "4alb3c2a".
		
		StringBuilder sb = new StringBuilder();
		
		List<CharCount> list = new  ArrayList<CharCount>();
		
		char current = s.charAt(0);
		int count = 1;
		
		
		for(int i=1; i<s.length(); i++) {
			if(current==s.charAt(i)) {
				count++;
			} else {
				list.add(new CharCount(current, count));
				current = s.charAt(i);
				count = 1;
			}
		}
		
		list.add(new CharCount(current, count));
		
		for (CharCount charCount : list) {
			sb.append(charCount.count);
			sb.append(charCount.chr);
		}		
		
		return sb.toString();
	}

}
