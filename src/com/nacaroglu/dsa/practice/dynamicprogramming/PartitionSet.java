package com.nacaroglu.dsa.practice.dynamicprogramming;

public class PartitionSet {

	public static void main(String[] args) {
	    PartitionSet ps = new PartitionSet();
	    int[] num = {1, 2, 3, 8};
	    System.out.println(ps.canPartition(num));
	    num = new int[]{1, 1, 3, 4, 7};
	    System.out.println(ps.canPartition(num));
	    num = new int[]{2, 3, 4, 6};
	    System.out.println(ps.canPartition(num));
	  }

	public boolean canPartition(int[] num) {
				
		int sum = 0;
		for (int i : num)
			sum +=i;		
		
		if(sum%2==1)
			return false;
		
		sum = sum/2;
		
		Boolean[][] dp = new Boolean[num.length][sum + 1];
		
		return helper(num,0,sum,dp);	
	}
	
	
	public boolean helper(int[] num, int index, int sum, Boolean[][] dp) {
		
		if(sum==0) {
			return true;
		}
		
		if(index>=num.length) {
			return false;
		}	
		
		if(dp[index][sum]!=null) {
			return dp[index][sum];
		}
		
		if(sum-num[index]>=0) {
			if(helper(num, index+1, sum-num[index], dp)) {
				dp[index][sum] = true;
				return true;
			}
		}
		
		dp[index][sum] = helper(num, index+1, sum,dp);
		
		return dp[index][sum];
	}
}
