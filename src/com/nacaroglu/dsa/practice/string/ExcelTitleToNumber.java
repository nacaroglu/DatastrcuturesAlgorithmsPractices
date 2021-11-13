package com.nacaroglu.dsa.practice.string;

public class ExcelTitleToNumber {
	
	public static void main(String[] args) {
		
		ExcelTitleToNumber tn = new ExcelTitleToNumber();
		System.out.println(tn.titleToNumber("A"));
		System.out.println(tn.titleToNumber("AB"));
		System.out.println(tn.titleToNumber("ZY"));
		System.out.println(tn.titleToNumber("CCC"));
	}
	
	
	public int titleToNumber(String columnTitle) {
		
		if (columnTitle==null || columnTitle.length()==0) 
			return 0;
		
		int sum = 0;
		int power = 1;
		
		for(int i=columnTitle.length()-1; i>=0; i--) {
						 
			sum += (columnTitle.charAt(i) -'A'+1)* power ;
			power = power*26;
		}
		
		return sum;
        
    }
}
