package com.nacaroglu.dsa.practice.dynamicprogramming;

public class CoinChange {
	
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] denominations = { 1, 2, 3 };
		System.out.println(cc.countChange_topdown(denominations, 5));
		System.out.println(cc.countChange(denominations, 5));
	}

	public int countChange_topdown(int[] denominations, int total) {		
		Integer[][] dp = new Integer[denominations.length][total+1];		
		return helper_topdown(denominations, total, 0, dp);		
	}	

	private int helper_topdown(int[] coins, int target, int index, Integer[][] dp) {
		
		if(target==0) {
			return 1;
		}	
		
		if(coins.length == 0 || index >= coins.length)
		      return 0;
		
		
		if(dp[index][target]!=null) {
			return dp[index][target];
		}
		
		int sumInc = 0, sumExc = 0;
		
		if(target>=coins[index]) {
			sumInc = helper_topdown(coins, target-coins[index], index,dp);
		}
		
		sumExc = helper_topdown(coins, target, index+1, dp);
		
		dp[index][target] = sumInc + sumExc;
		
		return dp[index][target] ;
	}
	
	public int countChange(int[] coins, int target) {		
		
		Integer[][] dp = new Integer[coins.length][target+1];		
		
		for(int i=0; i<coins.length; i++) {
			dp[i][0]=1;
		}
		
		
		for(int i=0; i<coins.length; i++) {
			
			for(int t=1; t<=target; t++) {
				
				int sumInc = 0, sumExc = 0;
				
				if(i>0) {
					sumExc = dp[i-1][t];
				}
				
				if(t>=coins[i]) {
					sumInc = dp[i][t-coins[i]];
				}
												
				dp[i][t] = sumInc + sumExc;
			}
		}	
		
		return dp[coins.length-1][target] ;
	}
	
}
