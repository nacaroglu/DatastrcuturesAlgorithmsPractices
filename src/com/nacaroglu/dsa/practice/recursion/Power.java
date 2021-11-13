package com.nacaroglu.dsa.practice.recursion;

public class Power {

	public static void main(String[] args) {
		
		Power p = new Power();
		System.out.println(p.myPow(2, 10));

	}
	
	public double myPow(double x, int n) {
		
		if(n==0) {
			return 1;
		}
    
		if(n<0) {
			x = 1/x;
			n = n*-1;
		}
		
		return helper(x,n);		
    }

	private double helper(double x, int n) {
		
		if(n==1) {
			return x;
		}
		
		if(n%2==0) {
			return helper(x,n/2) * helper(x,n/2);
		}else {
			return x* helper(x,n/2) * helper(x,n/2);
		}	
	}

}
