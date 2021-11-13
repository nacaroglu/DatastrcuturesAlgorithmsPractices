package com.nacaroglu.dsa.practice._mixed;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallestInMSortedArrays {

	public static void main(String[] args) {
		Integer[] l1 = new Integer[] { 2, 6, 8 };
		Integer[] l2 = new Integer[] { 3, 6, 7 };
		Integer[] l3 = new Integer[] { 1, 3, 4 };
		List<Integer[]> lists = new ArrayList<Integer[]>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
		System.out.print("Kth smallest number is: " + result);
	}

	public static int findKthSmallest(List<Integer[]> lists, int k) {
		
		if(lists==null || lists.size()==0) {
			return -1;
		}			
		
		Integer[] l1 = lists.get(0);		
		
		if(lists.size()>1) {
			
			for(int i=1; i<lists.size(); i++) {
				Integer[] l2 = lists.get(i);
				l1= merge(l1, l2);
			}
		}
		
		return l1[k-1];
	}

	private static Integer[] merge(Integer[] l1, Integer[] l2) {
		
		Integer [] result = new Integer[l1.length + l2.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i<l1.length && j<l2.length) {
			
			if(l1[i]<l2[j]) {
				result[k] = l1[i];
				i++;							
			}else {
				result[k] = l2[j];
				j++;				
			}
			
			k++;
		}
		
		while(i<l1.length) {
			result[k] = l1[i];
			i++;
			k++;
		}
		
		while(j<l2.length) {
			result[k] = l2[j];
			k++;
			j++;
		}		
		
		return result;
	}

}
