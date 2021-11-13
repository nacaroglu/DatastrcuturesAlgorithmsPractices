package com.nacaroglu.dsa.practice._mixed;


public class Arrays {

	public static void main(String[] args) {		
		int[] arr1 = {1, 3, 4, 5};  
		int[] arr2 = {2, 6, 7, 8};
		
		System.out.println(mergeArrays(arr1, arr2));
	}

	// merge arr1 and arr2 into a new result array
	public static int[] mergeArrays(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 == null)
			return null;
		if (arr2.length == 0 && arr1.length == 0)
			return null;
		if (arr1 == null || arr1.length == 0)
			return arr2;
		if (arr2 == null || arr2.length == 0)
			return arr1;

		int[] resultArr = new int[arr1.length + arr2.length];

		int f = 0, s = 0, w = 0;

		while (f < arr1.length && s < arr2.length) {

			if (arr1[f] < arr2[s]) {
				resultArr[w] = arr1[f];
				f++;
			} else {
				resultArr[w] = arr2[s];
				s++;
			}

			w++;
		}

		while (f < arr1.length) {
			resultArr[w] = arr1[f];
			w++;
			f++;
		}

		while (s < arr2.length) {
			resultArr[w] = arr2[s];
			w++;
			s++;
		}

		return resultArr; // 
	}
}
