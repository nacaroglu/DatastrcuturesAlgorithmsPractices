package com.nacaroglu.dsa.practice.binarysearch;

public class GuessGame {

	public static void main(String[] args) {		
		
		GuessGame bs = new GuessGame(6);
		
		System.out.println(bs.guessNumber(10));
		
		bs.pick=1;
		System.out.println(bs.guessNumber(1));
		System.out.println(bs.guessNumber(2));
		bs.pick=2;
		System.out.println(bs.guessNumber(2));				
	}
	
	int pick;
		
	public GuessGame(int pick) {
		super();
		this.pick = pick;
	}

	private int guess(int num) {		
		return Integer.compare(pick, num);
	}
	
	public int guessNumber(int n) {	
		
		if(n==1) return n;
        
		int l= 0; 
		int h = n;
		
		while(l<=h) {
			
			int mid = l + (h-l)/2;
			
			int guessResult = guess(mid); 
			
			if(guess(mid)==0) {
				return mid;
			}else if(guessResult==-1) {
				h = mid-1;
			}else {
				l = mid+1;
			}	
		}
		
		return -1;	
    }	
	

	

}
