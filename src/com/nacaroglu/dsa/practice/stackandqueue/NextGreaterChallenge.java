package com.nacaroglu.dsa.practice.stackandqueue;

import java.util.Stack;

public class NextGreaterChallenge {

	public static void main(String[] args) {
		
		int arr[] = {4,6,3,2,8,1};
		
		int[] result = nextGreaterElement(arr);

	}
	
	public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        
        if(arr==null || arr.length==0)
        	return arr;
       
        Stack<Integer> stack = new Stack<Integer>();
        int max = -1;
        
        stack.push(max);
        
        for(int i= arr.length-2; i>=0; i--) {
        	if(arr[i]<arr[i+1]) {
        		max = arr[i+1];        		
        	}
        	
        	stack.push(max);
        }
        
        int counter = 0;
        while(!stack.isEmpty()) {
        	result[counter] = stack.pop();
        	counter++;
        }
        
        return result;
    }

}
