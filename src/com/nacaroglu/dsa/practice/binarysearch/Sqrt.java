package com.nacaroglu.dsa.practice.binarysearch;

public class Sqrt {

	public static void main(String[] args) {

		Sqrt s = new Sqrt();

		//System.out.println(s.mySqrt(2));
		 //System.out.println(s.mySqrt(4));
		 //System.out.println(s.mySqrt(8));
		 //System.out.println(s.mySqrt(24));
		System.out.println(s.mySqrt(76));
		 //System.out.println(s.mySqrt(81));

		//System.out.println(s.mySqrt(2147395599));

	}

	public int mySqrt(int x) {
		
		if(x<=1) {
			return x;
		}

		int l = 2;
		int h = x/2;

		while (l <= h) {

			int mid = l + (h - l) / 2;

			long midSquared = (long) mid * mid;

			if (midSquared <= x) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		return (int) l - 1;
	}

}
