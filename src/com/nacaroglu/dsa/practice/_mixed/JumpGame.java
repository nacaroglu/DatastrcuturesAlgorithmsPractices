package com.nacaroglu.dsa.practice._mixed;

public class JumpGame {
	
	boolean found = false;
	
	public static void main(String[] args) {	
		
		JumpGame p1 = new JumpGame();
		
		//int[] A = {3,3,1,0,2,0,1};
		
		int[] A = {3, 2, 0,0, 2, 0,1};
		
		System.out.println(p1.jumpGame(A));
		
	}
	
	public boolean jumpGame(int[] A) {
		
		
		jump( A, 0);
		
		return found;
	}
	
	public void jump(int[] A, int index) {
			
		
		for(int i=A[index]; i>0; i--) {
			
			if(A[index+i]==0) {
				//System.out.println("index: " + index + " i: " + i + " value: " + A[index+i]);
				continue;
			}
			
			if(index+i==A.length-1) {				
				//System.out.println("Found  index: " + index + " i: " + i + " value: " + A[index+i]);
				found = true;
				return ;
			}
			
			jump(A,index+i);			
		}		
	}
}
