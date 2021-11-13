package com.nacaroglu.dsa.practice.dynamicprogramming;

public class CountSubsetSums {

	public static void main(String[] args) {

		CountSubsetSums ss = new CountSubsetSums();
		int[] num = { 1, 1, 2, 3 };
		System.out.println(ss.countSubsets(num, 4));
		num = new int[] { 1, 2, 7, 1, 5 };
		System.out.println(ss.countSubsets(num, 9));

	}

	public int countSubsets(int[] num, int sum) {

		Integer[][] dp = new Integer[num.length][sum + 1];
		return helper(num, sum, 0, dp);
	}

	public int helper(int[] num, int sum, int index, Integer[][] dp) {

		if (sum == 0) {
			return 1;
		}

		if (index >= num.length) {
			return 0;
		}

		if (dp[index][sum] == null) {

			int included = 0;
			if (sum >= num[index]) {
				included = helper(num, sum - num[index], index + 1, dp);
			}

			int excluded = helper(num, sum, index + 1, dp);

			dp[index][sum] = included + excluded;
		}

		return dp[index][sum];
	}

}
