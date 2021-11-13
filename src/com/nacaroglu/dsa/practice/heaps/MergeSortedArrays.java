package com.nacaroglu.dsa.practice.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {

	public static void main(String[] args) {
		
		MergeSortedArrays msa = new MergeSortedArrays();
		List<List<Integer>> sortedArrays= new ArrayList();
		
		int[] arr1 = {3,5,7};
		int[] arr2 = {0,6};
		int[] arr3 = {0,6,28};
		
		addToList(sortedArrays, arr1);
		addToList(sortedArrays, arr2);
		addToList(sortedArrays, arr3);
		
		List<Integer> result = msa.mergeSortedArrays(sortedArrays);
		
		for (Integer integer : result) {
			System.out.print(integer + ", ");
		}

	}
	
	private static void addToList(List<List<Integer>> sortedArrays, int[] arr1) {
		
		List<Integer> list = new ArrayList<Integer>();
		for (Integer e : arr1) {
			list.add(e);
		}
		
		sortedArrays.add(list);
	}

	public static List<Integer> mergeSortedArrays(
			List<List<Integer>> sortedArrays){
		
		List<Integer> result = new ArrayList<Integer>();
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		for(List<Integer> list: sortedArrays) {
			for(Integer i: list) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			result.add(q.poll());
		}
		
		return result;
	}

}
