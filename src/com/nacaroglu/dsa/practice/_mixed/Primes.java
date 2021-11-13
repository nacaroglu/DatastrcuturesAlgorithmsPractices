package com.nacaroglu.dsa.practice._mixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Primes {
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new  PriorityQueue<Integer>();
		

		Primes bs = new  Primes();
		
		List<Integer> primes = findPrimes2(100);		
		
		for (Integer p : primes) {
			System.out.print(p + ", ");
		}
	}

	private static List<Integer> findPrimes(int n) {
		
		List<Integer> primes = new ArrayList<Integer>();
		
		for(int i=2; i<n; i++) {
			
			if(isPrime(i, primes)) {
				primes.add(i);
			}
			
		}
		
		return primes;
	}

	private static boolean isPrime(int i, List<Integer> primes) {
		
		for (Integer num : primes) {
			if(i%num ==0) 
				return false;
		}
		
		return true;
	}
	
	private static List<Integer> findPrimes2(int n) {
	
		Integer[] basePrimes = {2,3,5,7};
		
		List<Integer> primes = new ArrayList<Integer>();
		primes.addAll(Arrays.asList(basePrimes));
		
		for(int i=2; i<n; i++) {
			boolean found = false;
			for (Integer base : basePrimes) {
				if(i%base==0) {
					found = true;
					break;
				}
			}
			
			if(!found)
				primes.add(i);
			
		}
		
		return primes;
	}
}
