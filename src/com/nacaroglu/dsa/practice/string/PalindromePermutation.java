package com.nacaroglu.dsa.practice.string;

import java.util.Arrays;
import java.util.Stack;

public class PalindromePermutation {

	public static void main(String[] args) {
		
		PalindromePermutation pp = new PalindromePermutation();
		pp.canPermutePalindrome("carerac");

	}
	
	 public boolean canPermutePalindrome(String s) {
	        
	        if(s==null || s.length()<1){
	            return true;
	        }
	        
	        char[] arr = s.toCharArray();
	        Arrays.sort(arr);
	        
	        Stack<Character> stack = new Stack<Character>();
	        stack.push(arr[0]);
	        
	        for(int i=1; i<arr.length; i++){
	            
	            if(!stack.isEmpty() && stack.peek()==arr[i]){
	                stack.pop();
	                
	            }else{
	                stack.push(arr[i]);
	                
	            }            
	        }
	        
	        if(stack.isEmpty() || stack.size()==1) 
	            return true;
	        
	        return false;       
	        
	    }

}
