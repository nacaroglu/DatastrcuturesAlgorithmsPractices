package com.nacaroglu.dsa.practice.arrrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
	
	public static class Interval implements Comparable<Interval> {
		
		int start;
		int end;
		
		public Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Interval o) {			
			return this.start-o.start;
		}

		@Override
		public String toString() {
			return "Start: " + start + " End: " + end;			
		}
		
		
	}
	
	public static class IntervalComporator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {			
			return o1.start-o2.start;
		}		
	}
	
	
	public static void main(String args[]) {
		
		MergeIntervals mi = new MergeIntervals();
		
		int intervals[][] = {{1,3},{2,6},{8,10}, {15,18}};		
		//System.out.println(mi.merge(intervals).length);		
		
		int intervals2[][] = {{1,4},{4,5}};		
	//System.out.println(mi.merge(intervals2).length);
		
		int intervals3[][] = {{1,4}};		
		System.out.println(mi.merge(intervals3).length);
	}
	
	public int[][] merge(int[][] intervals) {
		
		if(intervals.length==1) {
			return intervals;
		}
                    	 
		 List<Interval> list = new ArrayList<Interval>(); 
		 
		 PriorityQueue<Interval> q = new PriorityQueue<MergeIntervals.Interval>(intervals.length, new IntervalComporator());
		 
		 for(int i=0; i<intervals.length; i++) {
			 q.add(new Interval(intervals[i][0], intervals[i][1]));
		 }
		 
		 while(!q.isEmpty()) {
			 
			 Interval interval = q.peek();
			 boolean added = false;
			 
			 for(int i=0; i< list.size(); i++) {
				 
				 Interval existing = list.get(i);
				 
				 if(interval.start<=existing.end) {
					 
					 existing.end = Math.max(existing.end, interval.end);					 
					 added = true;
					 break;
				 }
			 }
			 
			 if(!added) {
				 list.add(new Interval(interval.start, interval.end));
			 }		
			 
			 q.remove(interval);
		 }
		 
		 int[][] result = new int[list.size()][2];
		 for(int i=0; i<list.size(); i++) {
			 Interval existing = list.get(i);
			 result[i][0] = existing.start;
			 result[i][1] = existing.end;
		 }
		 
		 return result;	        
	  }

}
