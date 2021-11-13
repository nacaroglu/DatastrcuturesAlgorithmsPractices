package com.nacaroglu.dsa.practice.dynamicprogramming;

public class MinimumSubsetSumDifference {

	public static void main(String[] args) {

		MinimumSubsetSumDifference mssd = new MinimumSubsetSumDifference();

		int[] num = { 1, 2, 3, 9 };
		System.out.println(mssd.canPartition(num));

		int[] num2 = { 1, 2, 7, 1, 5 };
		System.out.println(mssd.canPartition(num2));
	}

	int minDiff = Integer.MAX_VALUE;

	public int canPartition(int[] num) {

		return helper(num, 0, 0, 0);
	}

	private int helper(int[] num, int i, int s1, int s2) {

		if (i == num.length) {
			return Math.abs(s1 - s2);
		}

		int diff1 = helper(num, i + 1, s1 + num[i], s2);
		int diff2 = helper(num, i + 1, s1, s2 + num[i]);
		return Math.min(diff1, diff2);

	}

}
