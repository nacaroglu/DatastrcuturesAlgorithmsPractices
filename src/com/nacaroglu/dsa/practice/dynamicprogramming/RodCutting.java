package com.nacaroglu.dsa.practice.dynamicprogramming;

public class RodCutting {

	public static void main(String[] args) {
		RodCutting rc = new RodCutting();
		int[] lengths = { 1, 2, 3, 4, 5 };
		int[] prices = { 2, 6, 7, 10, 13 };		;
		//System.out.println(rc.solveRodCutting_TopDown(lengths, prices, 5));
		//System.out.println(rc.solveRodCutting_TopDownWithMemo(lengths, prices, 5));
		System.out.println(rc.solveRodCutting_bottomUp(lengths, prices, 5));
	}
	
	public int solveRodCutting_bottomUp(int[] lengths, int[] prices, int l) {
		
		if (l <= 0 || prices.length == 0 || prices.length != lengths.length)
		      return 0;
		
		int[][] dp = new int[prices.length][l+1];	
	
		for(int i=0; i<lengths.length; i++) {
			
			for(int len=1; len<=l; len++) {
				
				int pInc = 0, pExc = 0;
				
				if(lengths[i]<=len) {
					pInc = prices[i] + dp[i][len-lengths[i]];
				}
				
				if( i > 0 )
					pExc = dp[i-1][len];
				
				dp[i][len] = Math.max(pInc, pExc);				
			}			
		}	
		
		return dp[prices.length-1][l];
	}
	
	
	public int solveRodCutting_TopDownWithMemo(int[] lengths, int[] prices, int n) {
		
		Integer[][] dp = new Integer[prices.length][n+1];		
		return helper_TopDownWithMemo(lengths, prices, n, 0, dp);		
	}

	private int helper_TopDownWithMemo(int[] lengths, int[] prices, int l, int index, Integer[][] dp) {
		
		if(index>=lengths.length || l<=0) {
			return 0;
		}
		
		if(dp[index][l]!= null) {
			return dp[index][l];
		}
		
		int pi = 0;
		if(lengths[index]<=l) {
			pi = prices[index] + helper_TopDownWithMemo(lengths, prices, l-lengths[index], index, dp);
		}
		
		int pe = helper_TopDownWithMemo(lengths, prices, l, index+1, dp);
		
		dp[index][l] = Math.max(pi, pe);	
		
		return dp[index][l];
	}
	
	
	public int solveRodCutting_TopDown(int[] lengths, int[] prices, int n) {
		
		return helper_TopDown(lengths, prices, n, 0);		
	}

	private int helper_TopDown(int[] lengths, int[] prices, int l, int index) {
		
		if(index>=lengths.length || l<=0) {
			return 0;
		}
		
		int pi = 0;
		if(lengths[index]<=l) {
			pi = prices[index] + helper_TopDown(lengths, prices, l-lengths[index], index);
		}
		
		int pe = helper_TopDown(lengths, prices, l, index+1);
		
		return Math.max(pi, pe);
	}

}
