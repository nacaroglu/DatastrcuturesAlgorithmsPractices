package com.nacaroglu.dsa.practice.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SorAlmostSortedArray {

	public static void main(String[] args) {

		SorAlmostSortedArray sort = new SorAlmostSortedArray();
		int[] sequence = { 3,-1,2,6,4,5,8 };
		sort.sortApproximatelySortedData(sequence, 2);

	}
	
	public void sortApproximatelySortedData(int[] sequence,	int k) {
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		List<Integer> result = new ArrayList<Integer>();
		
		int i;
		
		for(i=0; i<=k; i++) {
			q.add(sequence[i]);
		}
		
		while(!q.isEmpty()) {
			result.add(q.poll());
			
			if(i<sequence.length) {
				q.add(sequence[i]);
			}
			
			i++;
		}
		
		System.out.println(result.size());
	}

}
