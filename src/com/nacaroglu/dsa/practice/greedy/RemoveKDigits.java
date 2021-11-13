package com.nacaroglu.dsa.practice.greedy;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
	
		RemoveKDigits rkd = new RemoveKDigits();
		System.out.println(rkd.removeKdigits("1432219", 3));
		//System.out.println(rkd.removeKdigits("10200", 1));
		//System.out.println(rkd.removeKdigits("10", 2));
		//System.out.println(rkd.removeKdigits("100", 1));
	}
	


	public String removeKdigits(String num, int k) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		Stack<Integer> temp = new Stack<Integer>();
		
		for(int i= num.length()-1; i>=0; i--) {
			stack.add( num.charAt(i) - '0' );
		}
		
		int count=0;
		
		while(count<=k) {
			
			int curr = stack.pop();
			int next = stack.peek();
			
			
		}
		
		return "0";
	}

}
