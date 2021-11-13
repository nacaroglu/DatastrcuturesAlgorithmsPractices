package com.nacaroglu.dsa.practice.binarysearch;

public class ArrayReader {

	private int[] arr;	
	
	public ArrayReader(int[] arr) {
		super();
		this.arr = arr;
	}
	
	public int get(int index) {
		
		if(index<=arr.length-1) {
			return arr[index];
		}
		
		return Integer.MAX_VALUE;
	}
}
