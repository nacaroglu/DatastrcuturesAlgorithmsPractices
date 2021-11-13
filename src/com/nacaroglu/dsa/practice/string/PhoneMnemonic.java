package com.nacaroglu.dsa.practice.string;

import java.util.ArrayList;
import java.util.List;

public class PhoneMnemonic {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneMnemonic pm = new PhoneMnemonic();
		List<String> result= pm.phoneMnemonic("23");
		
		for (String string : result) {
			System.out.println(string);
		}
	}
	
	
	
	public List<String> phoneMnemonic(String phoneNumber){
		
		String[] mapping = { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };
		
		List<String> result= new ArrayList<String>();
		
		for(int i=0; i< phoneNumber.length(); i++) {
			
			result = calculateForDigit(mapping[phoneNumber.charAt(i)-'0'],result);
		}	
		
		return result;
	}

	private static List<String> calculateForDigit(String str, List<String> list) {
		
		List<String> result = new ArrayList<String>();  
		
		if(list.isEmpty()) {
			for (int i = 0; i < str.length(); i++) {
				result.add(String.valueOf(str.charAt(i)));
			}
		}else {
			for (String item : list) {
				
				for (int i = 0; i < str.length(); i++) {
					result.add(new String(item+str.charAt(i)));
				}
			}
		}		
		
		return result;
	}

}
