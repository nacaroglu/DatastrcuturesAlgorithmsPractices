package com.nacaroglu.dsa.practice.dynamicprogramming;

public class EqualSubsetSumPartition {

	public static void main(String[] args) {

		EqualSubsetSumPartition ss = new EqualSubsetSumPartition();
		int[] num = { 1, 2, 3, 4 };
		System.out.println(ss.canPartition(num));
	}

	public boolean canPartition(int[] num) {

		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}

		if (sum % 2 != 0) {
			return false;
		}

		return canPartition(num, sum / 2);
	}

	public boolean canPartition(int[] num, int target) {
		
		int n = num.length;

		boolean dp[][] = new boolean[n][target+1];
		
		for(int i=0; i<n; i++) {
			dp[i][0]= true;
		}	
		
		for (int s = 1; s <= target; s++) {
			dp[0][s] = (num[0] == s ? true : false);
		}
		
		for(int r=1;r<n; r++) {	
		
			for(int c=1; c<=target; c++) {								
				
		        if(dp[r-1][c]) {
		          dp[r][c] = dp[r-1][c];
		        } else if (c >= num[r]) { // else if we can find a subset to get the remaining sum
		          dp[r][c] = dp[r-1][c-num[r]];
		        }
			}
		}
		
		
		return dp[n-1][target];

	}
}
