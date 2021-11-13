package com.nacaroglu.dsa.practice.recursion;

public class KthGrammar {

	public static void main(String[] args) {		

		KthGrammar kth = new KthGrammar();
		System.out.println(kth.kthGrammar(30, 434991989));
		System.out.println(kth.kthGrammar(30, 434991988));
	}
	
	public int kthGrammar(int n, int k) {
		
		if(n==1) {
			return 0;
		}
		
		if(n==2) {
			if(k==1) {
				return 0;
			}else {
				return 1;
			}
		}
		
		int kx = k/2;
		if(k%2==1) {
			kx = (k+1)/2;
		}
		
		int val = kthGrammar(n-1, kx);
		
		if(val==0) {
			if(k%2==1) {
				return 0;
			}else {
				return 1;
			}
		}
		
		if(val ==1) {
			if(k%2==0) {
				return 0;
			}else {
				return 1;
			}
		}
		
		return -1;
    }
}
