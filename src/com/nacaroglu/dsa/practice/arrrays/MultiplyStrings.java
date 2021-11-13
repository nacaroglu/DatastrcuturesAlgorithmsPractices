package com.nacaroglu.dsa.practice.arrrays;

import java.util.Arrays;

public class MultiplyStrings {

	public static void main(String[] args) {
		
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply("123", "456"));
		System.out.println(ms.multiply("399", "49"));
		System.out.println(ms.multiply("2", "3"));

	}

	public String multiply(String num1, String num2) {
		
		if(num1.equalsIgnoreCase("0") || num2.equalsIgnoreCase("0")) {
			return "0";
		}
		
		if(num1.equalsIgnoreCase("1")) {
			return num2;
		}
		
		if(num2.equalsIgnoreCase("1")) {
			return num1;
		}

		char[] result = new char[num1.length()+num2.length()];
		Arrays.fill(result,  (char)('0')); 
		
		int n= 0;
		
		for(int i=num2.length()-1; i>=0; i--) {
			
			char[] multiplication = new char[num1.length()+1+n];
			
			doMultiplication(num1, num2.charAt(i), multiplication, n);
			addMultiplication(result, multiplication);
			
			n++;			
		}
		
		String resultStr = new String(result);
		
		if(result[0]=='0') {
			resultStr = resultStr.substring(1);
		}
		
		return resultStr;	
	}

	private void addMultiplication(char[] result, char[] multiplication) {
		
		//System.out.println("result: " + result + " multiplication: " + multiplication);
		
		int carry = 0;
		
		for(int i=0; i< multiplication.length; i++) {
			//System.out.println(result[result.length-1-i] + " --> " + multiplication[multiplication.length-1-i]);
			
			int localSum =  (result[result.length-1-i]- '0') + (multiplication[multiplication.length-1-i]- '0');
			localSum = localSum + carry;
			
			carry = localSum/10;
			
			result[result.length-1-i] = (char)((localSum%10)+ '0');
		}
				
		
		if(carry!=0) {
			result[result.length-multiplication.length] =  (char)((carry)+ '0');
		}
		
	}

	private void doMultiplication(String num1, char charAt, char[] multiplication, int n) {
		
		Arrays.fill(multiplication,  (char)('0')); 

		//System.out.println("num1:" + num1 + " num2[i]: " + charAt + " n: " + n );
		
		int carry = 0;
		
		for(int i= num1.length()-1; i>=0; i--) {
			int localMultip =  (num1.charAt(i)- '0') * (charAt- '0');
			localMultip = localMultip + carry;
			
			carry = localMultip/10;
			
			multiplication[i+1] = (char)((localMultip%10)+ '0');
			
		}
		
		multiplication[0] =  (char)('0');
		
		if(carry!=0) {
			multiplication[0] =  (char)((carry)+ '0');
		}
		
	}

}
