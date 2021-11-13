package com.nacaroglu.dsa.practice.recursion;

public class PowerOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PowerOfThree p = new PowerOfThree();
		
		System.out.println(p.isPowerOfThree(900));
		
		System.out.println(p.isPowerOfThree(27));

		/*
		System.out.println(p.isPowerOfThree(Integer.MAX_VALUE));
		System.out.println(p.isPowerOfThree(Integer.MIN_VALUE)); */

		System.out.println(p.isPowerOfThree(1162261469));
		System.out.println(p.isPowerOfThree(1162261467));
		System.out.println(p.isPowerOfThree(243));
		System.out.println(p.isPowerOfThree(243));
		System.out.println(p.isPowerOfThree(405));
		System.out.println(p.isPowerOfThree(-3));
		System.out.println(p.isPowerOfThree(9));
		
	}

	public boolean isPowerOfThree(int n) {

		if (n <= 0) {
			return false;
		}

		while (n > 10) {

			String str = String.valueOf(n);
			int sum = findDigitSum(str);

			if (sum % 9 != 0) {
				return false;
			}

			n = n / 3;

		}

		if (n != 1 && n != 3 && n != 9) {
			return false;
		}

		return true;

	}

	private int findDigitSum(String str) {

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {

			int x = Integer.valueOf(str.substring(i, i + 1));
			sum += x;
		}

		return sum;
	}

}
