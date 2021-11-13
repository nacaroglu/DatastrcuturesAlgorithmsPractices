package com.nacaroglu.dsa.practice.arrrays;

import java.util.ArrayList;

public class AddBinary {

	public static void main(String[] args) {
		
		AddBinary ab = new AddBinary();
		ab.addBinary("1111","1111");

	}

	public String addBinary(String a, String b) {

		int sizeA = a.length();
		int sizeB = b.length();
		
		if(sizeA>sizeB) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < sizeA-sizeB; i++) {
				sb.append("0");
			}
			sb.append(b);
			
			b = sb.toString();
		}
		
		if(sizeB>sizeA) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < sizeB-sizeA; i++) {
				sb.append("0");
			}
			sb.append(a);
			
			a = sb.toString();
		}
		
		ArrayList<Integer> aArr = toArrayList(a);
		ArrayList<Integer> bArr = toArrayList(b);
				
		int[] result = new int[bArr.size()];
		
		int remainder = 0;	
		
		for(int i=aArr.size()-1; i>=0; i--) {
			
			int sum = aArr.get(i) + bArr.get(i) + remainder;
			
			remainder = 0;
			
			if(sum>=2) {
				remainder = 1;
				sum = sum%2;
			}
			
			result[i] = sum;
		}
		
		StringBuffer sb =new StringBuffer();
		
		if(remainder==1) {
			sb.append("1");
		}
		
		for (int i : result) {
			sb.append(i);
		}

		return sb.toString();

	}

	private ArrayList<Integer> toArrayList(String a) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i=0; i<a.length(); i++) {
			
			result.add(Integer.valueOf(a.substring(i, i+1)));
		}
		
		return result;
	}

	

}
