package com.nacaroglu.dsa.practice.recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

	public static void main(String[] args) {
		
		FibonacciNumber fb = new FibonacciNumber();
		
		System.out.println(fb.fib(4));
		System.out.println(fb.fib_iterative(4));
		System.out.println(fb.fib_iterative_two_var(4));
		
		System.out.println(fb.fib(10));
		System.out.println(fb.fib_iterative(10));
		System.out.println(fb.fib_iterative_two_var(10));
		
	}
	
	Map<Integer,Integer> map  = new HashMap<Integer, Integer>();
	
	public int fib(int n) {
		
		int result = 0;

		if(map.containsKey(n)) {
			return map.get(n);
		}
		
		if(n<2) {		
			return n;
		}
		
		result = fib(n-1) + fib(n-2);
		
		map.put(n, result);
		return result;
	}
	
	public int fib_iterative(int n) {		
		
		int [] fibs = new int[n+1];
		
		fibs[0] = 1;
		fibs[1] = 1;
		
		for(int i=2; i<n; i++) {
			fibs[i] = fibs[i-1] + fibs[i-2];
		}
		
		return fibs[n-1];
	}
	
	public int fib_iterative_two_var(int n) {		
						
		int prev1 = 1;
		int prev2 = 1;
		int val=0;
		
		for(int i=2; i<n; i++) {
			val = prev1 + prev2;
			prev2 = prev1;
			prev1 = val;
		}
		
		return val;
	}
}
