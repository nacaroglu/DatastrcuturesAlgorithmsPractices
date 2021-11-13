package com.nacaroglu.dsa.practice._mixed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlusOne {
	
	public static void main(String[] args) {	
		
		PlusOne p1 = new PlusOne();
		
		int[] A = {9};
		
		System.out.println(p1.add(A)); 
		
	}
	
	public int[] add(int[] A) {
		
		if(A==null || A.length==0) {
			return A;
		}
			
		int carry = 0;
		
		for(int i=A.length-1; i>=0; i--) {
			
			int currentSum = A[i] + carry;
			
			if(i==A.length-1) { currentSum = currentSum+1; }
			
			if(currentSum==10) {
				A[i] = 0;
				carry = 1;
			}else {
				A[i] = currentSum;
				carry = 0;
			}
		}
		if(carry==1) {
			int[] B = new int[A.length+1];
			
			B[0]=1;
			for(int i=1; i<A.length; i++) {
				B[i] = A[i-1];
			}
			
			return B;
		}
		
		return A;
	}
}
