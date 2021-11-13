package com.nacaroglu.dsa.practice.binarysearch;

public class SparseSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SparseSearch bs = new SparseSearch();
		
		
		
		String[] arr = {"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};
		System.out.println(bs.search(arr, "educative"));		
		System.out.println(bs.search(arr, "education"));
		System.out.println(bs.search(arr, "world"));
	}
	
	public int search(String[] arr, String target) {
		
		return helper(arr,0,arr.length-1, target);
		
    }

	private int helper(String[] arr, int l, int h, String target) {
		
		if(l>h) {
			return -1;
		}
		
		int mid = l + (h-l)/2;
		
		if(arr[mid].equalsIgnoreCase(target)) {
			return mid;
		}else if(arr[mid].compareToIgnoreCase("")==0) {
				int left = helper(arr,l,mid-1,target);
				if(left!=-1) {
					return left;
				}
				
				int right =helper(arr,mid+1, h, target);				
				if(right!= -1) {
					return right;
				}			
		}else if(arr[mid].compareToIgnoreCase(target)>0) {
			return helper(arr,l,mid-1,target);
		}else {
			return helper(arr,mid+1, h, target);
		}
		
		return -1;
	}
	
	

	

}
