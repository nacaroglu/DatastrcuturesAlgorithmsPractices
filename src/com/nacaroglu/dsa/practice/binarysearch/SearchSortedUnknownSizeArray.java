package com.nacaroglu.dsa.practice.binarysearch;

public class SearchSortedUnknownSizeArray {

	public static void main(String[] args) {
		
		SearchSortedUnknownSizeArray search = new SearchSortedUnknownSizeArray();
		int[] arr = { -1,0,3,5,9,12,18,89 };
		ArrayReader reader = new ArrayReader(arr);
		System.out.println(search.search(reader, 5));		
		System.out.println(search.search(reader, 99));
		System.out.println(search.search(reader, 89));
		System.out.println(search.search(reader, 12));
		System.out.println(search.search(reader, 9));
	}

	public int search(ArrayReader reader, int target) {
		
		int left = 0;
		int right = 1;
		
		while(reader.get(right)!= Integer.MAX_VALUE) {
			left = right;
			right = right*2;
		}
		
		/*
		while(left<=right) {
			
			int mid = left + (right-left)/2;
			
			if(reader.get(mid)==target) {
				return mid;
			}
			
			if(reader.get(mid)==Integer.MAX_VALUE) {
				right = mid-1;
			}else {
				left = mid+1;
			}			
		} */
		
		left = 0;
		
		while(left<=right) {
			
			int mid = left + (right-left)/2;
			
			if(reader.get(mid)==target) {
				return mid;
			}
			
			if(reader.get(mid)==Integer.MAX_VALUE || reader.get(mid)>target) {
				right = mid-1;
			}else {
				left = mid+1;
			}			
		}
		 

		return -1;
	}

}
