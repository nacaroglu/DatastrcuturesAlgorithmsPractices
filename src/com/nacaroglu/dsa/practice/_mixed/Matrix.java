package com.nacaroglu.dsa.practice._mixed;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] S= new int[4][4];
		
		for(int r=0; r< S.length; r++) {
			
			for(int c=0; c<S[0].length; c++) {
				
				S[r][c] = r*S[0].length+c+1;
			}
		}
		
		Matrix m = new Matrix();
		
		int[][] D= m.transpose(S);
		
		System.out.println("Bitti.");
		
	}
	
	public int[][] transpose(int[][] S){
		
		int[][] D = new int[S.length][S[0].length];
		
		for(int r=0; r< S.length; r++) {
			
			for(int c=0; c<S[0].length; c++) {
				
				D[c][S[0].length-r-1] = S[r][c];
			}
		}
		
		return D;
	}

}
