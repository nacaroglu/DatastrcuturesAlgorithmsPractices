package com.nacaroglu.dsa.practice._mixed;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {

	public static class Interval implements Comparable<Interval>  {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Interval o) {
			// TODO Auto-generated method stub
			return this.start-o.start;
		}
	}
	

	public static void main(String[] args) {
		
		ConflictingAppointments c = new ConflictingAppointments();

		//[6,7], [2,4], [8,12]
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(1, 4);
		intervals[1] = new Interval(2, 5);
		intervals[2] = new Interval(7, 9);
		
		System.out.println(c.canAttendAllAppointments(intervals));
	}
	
	
	public boolean canAttendAllAppointments(Interval[] intervals) {
		
		Arrays.sort(intervals);
		
		for(int i=0; i<intervals.length-1; i++) {
			
			if(intervals[i].end>intervals[i+1].start) {
				return false;
			}
		}
		
		return true;
	}
}