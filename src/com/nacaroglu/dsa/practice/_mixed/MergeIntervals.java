package com.nacaroglu.dsa.practice._mixed;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

	static class Pair {
		public int first;
		public int second;

		public Pair(int x, int y) {
			this.first = x;
			this.second = y;
		}

		@Override
		public String toString() {
			return "Pair [start=" + first + ", end=" + second + "]";
		}		
	}

	public static void main(String[] args) {
		
		MergeIntervals mi = new MergeIntervals();

		
		ArrayList<Pair> list = new  ArrayList<MergeIntervals.Pair>();
		
		list.add(new Pair(1, 5));
		list.add(new Pair(3, 7));
		list.add(new Pair(4, 6));
		list.add(new Pair(6, 8));
		
		List<Pair> result = mi.mergeIntervals(list);
		
		printList(result);
		
		list = new  ArrayList<MergeIntervals.Pair>();
		
		list.add(new Pair(10, 12));
		list.add(new Pair(12, 15));
		list.add(new Pair(17, 25));
		
		result = mi.mergeIntervals(list);
		
		printList(result);

	}

	private static void printList(List<Pair> result) {
		for (Pair pair : result) {
			System.out.println(pair.toString());
		}
	}

	public static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
		
		ArrayList<Pair> result = new ArrayList<Pair>();
		
		Pair birinci = v.get(0);
		result.add(birinci);
		
		for(int i=1; i<v.size(); i++) {
			
			Pair ikinci = v.get(i);
			
			// No overlap
			if(birinci.first<ikinci.first && birinci.second<ikinci.first) {				
				result.add(ikinci);
				continue;
				// first includes second thus take first
			} else	if(birinci.first<=ikinci.first && birinci.second>=ikinci.second) {
				
				// overlap
			} else if(birinci.first<=ikinci.first && birinci.second<=ikinci.second) {
				birinci.second = ikinci.second;				
			}
			
			birinci = result.get(result.size()-1);
		}

		return result;
	}

}
