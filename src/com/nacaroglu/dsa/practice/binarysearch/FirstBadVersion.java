package com.nacaroglu.dsa.practice.binarysearch;

public class FirstBadVersion {

	public static void main(String[] args) {

		FirstBadVersion fbv = new FirstBadVersion();
		
		fbv.badVersion = 4;
		System.out.println(fbv.firstBadVersion(5));
		
	}

	int badVersion = 0;

	private boolean isBadVersion(int version) {
		return version == badVersion;
	}

	public int firstBadVersion(int n) {

		if (n == 1) return n;

		int left = 0, right = n;
		
		while (left < right) {
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
						
			if (isBadVersion(mid)) {
				right = mid;
			} else if (isBadVersion(mid+1)) {
				return mid+1;
			} else {
				left = mid + 1;
			}
		}

		// Post-processing:
		// End Condition: left == right
		if (left != n && isBadVersion(left))
			return left;
		return -1;
	}
}
