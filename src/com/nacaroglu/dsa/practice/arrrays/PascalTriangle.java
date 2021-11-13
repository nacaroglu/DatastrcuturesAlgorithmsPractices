package com.nacaroglu.dsa.practice.arrrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {

		PascalTriangle pt = new PascalTriangle();

		List<Integer> result = pt.getRow(3);
		
		System.out.println(result.size());
		
		HashSet<String> set = new HashSet<String>();
		

	}
	
	public List<Integer> getRow(int rowIndex) {
		Integer[] result = new Integer[rowIndex+1];
		
		if(rowIndex==0) {
			result[0] = 1;
			ArrayList<Integer> list = arrayList(result);
			return list;			
		}
		
		if(rowIndex==1) {
			result[0] = 1;
			result[1] = 1;
			ArrayList<Integer> list = arrayList(result);
			return list;	
		}
		
		List<Integer> prev  = getRow(rowIndex-1); 
		
		result[0]= 1;
		result[rowIndex] = 1;
		
		for (int i = 1; i < result.length-1; i++) {
			int cell = prev.get(i-1) + prev.get(i);
			result[i]= cell;
		}		
		
		ArrayList<Integer> list = arrayList(result);
		return list;				
	}

	private ArrayList<Integer> arrayList(Integer[] result) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(result));
		return list;
	}

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		for (int n = 0; n < numRows; n++) {

			List<Integer> innerResult = new ArrayList<Integer>();

			for (int r = 0; r <= n; r++) {

				// System.out.print(ncr(n, r));
				innerResult.add(ncr(n, r));
			}

			// System.out.println("");
			resultList.add(innerResult);
		}

		return resultList;

	}

	private BigInteger factorial(int i) {

		BigInteger result = new BigInteger("1");

		for (long j = 1; j <= i; j++) {

			result = result.multiply(BigInteger.valueOf(j));

		}

		return result;
	}

	private int ncr(int n, int r) {

		BigInteger result = factorial(n) .divide((factorial(r) .multiply(factorial(n - r))));

		return result.intValue();
	}
}
