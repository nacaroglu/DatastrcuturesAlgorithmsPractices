package com.nacaroglu.dsa.practice.dynamicprogramming;

public class SubsetSum {

	public static void main(String[] args) {
		
		
		int[] num = {1,2,3,7};
		System.out.println(canPartition(num, 6));
		System.out.println(canPartitionMemo(num, 6));
		System.out.println(canPartitionBottomUp(num, 6));
		int[] num2= {1, 2, 7, 1, 5};
		System.out.println(canPartition(num2, 10));
		System.out.println(canPartitionMemo(num2, 10));
		System.out.println(canPartitionBottomUp(num2, 10));
		int[] num3= {1, 3, 4, 8};
		System.out.println(canPartition(num3, 6));
		System.out.println(canPartitionMemo(num3, 6));
		System.out.println(canPartitionBottomUp(num3, 6));
		

	}

	static boolean canPartition(int[] num, int sum) {
		
		return helper(num, sum, 0);
	}

	private static boolean helper(int[] num, int sum, int i) {
		
		if(sum==0) {
			return true;
		}
		
		if(sum<0 || i>=num.length) {
			return false;
		}
		
		return helper(num, sum-num[i], i+1) || helper(num, sum, i+1);	
	}
	
	static boolean canPartitionMemo(int[] num, int sum) {
		
		Boolean[][] dp = new Boolean[num.length][sum+1]; 
		
		return helperMemo(num, sum, 0, dp);
	}

	private static boolean helperMemo(int[] num, int sum, int i, Boolean[][] dp) {
		
		if(sum==0) {
			return true;
		}
		
		if(sum<0 || i>=num.length) {
			return false;
		}
		
		if(dp[i][sum]!= null) {
			return dp[i][sum];
		}
		
		boolean result = false;
		
		if (num[i] <= sum) {
			result = helperMemo(num, sum-num[i], i+1, dp);
			
			if(result) {
				dp[i][sum] = result;
				return dp[i][sum];
			}
			
		}else {
			result = helperMemo(num, sum, i+1, dp);
		}
		
		dp[i][sum] = result;
		return dp[i][sum];			
	}
	
	static boolean canPartitionBottomUp(int[] num, int sum) {
		
		boolean[][] dp = new boolean[num.length][sum+1];
		
		for(int r=0; r<num.length; r++) {
			dp[r][0] = true;
		}
		
		for(int s=0; s<sum; s++ ) {
			if(num[0]>=s) {
				dp[0][s]=true;
			}
		}
		
		for(int r=1;r<num.length; r++) {
			
			for(int s=1;s<=sum; s++) {
				
				if(dp[r-1][s]) {
					dp[r][s]=dp[r-1][s];
				}else if(s>=num[r]) {
					dp[r][s]=dp[r-1][s-num[r]];
				}
			}			
		}
		
		
		return dp[num.length-1][sum];
	}
}
