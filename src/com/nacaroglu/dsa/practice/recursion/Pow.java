package com.nacaroglu.dsa.practice.recursion;

public class Pow {

	public static void main(String[] args) {
		
		Pow p = new Pow();
		
		System.out.println(p.myPow(2,10));
		System.out.println(p.myPow(2,-2));
		/*System.out.println(p.pow(10,7));
		System.out.println(p.pow(10,-4));
		*/
		System.out.println(p.myPow(2.1000,3));
	}
	
	public double myPow(double x,int n) {
		
		if(n==0) {
			return 1;
		}
		
		if(n<0) {
			x = 1/(double)x;
		}
		
		n = Math.abs(n);
		
		return do_pow(x, n);
	}
	
	public double do_pow(double x,int n) {		
		
		if(n==1) return x;
		
		return x * do_pow(x, n-1);
	}

}
