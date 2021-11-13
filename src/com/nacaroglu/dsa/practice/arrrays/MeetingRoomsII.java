package com.nacaroglu.dsa.practice.arrrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
	
	public static class Meeting implements Comparable<Meeting> {
		
		int start;
		int end;
		
		public Meeting(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Meeting o) {			
			return this.start-o.start;
		}

		@Override
		public String toString() {
			return "Start: " + start + " End: " + end;			
		}
		
		
	}
	
	public static class MeetingComporator implements Comparator<Meeting>{

		@Override
		public int compare(Meeting o1, Meeting o2) {			
			return o1.start-o2.start;
		}		
	}
	
	
	public static void main(String args[]) {
		
		MeetingRoomsII mr2 = new MeetingRoomsII();
		
		int intervals[][] = {{0,30},{5,10},{15,20}};		
		//System.out.println(mr2.minMeetingRooms(intervals));
		
		int intervals2[][] = {{1,5},{8,9},{8,9}};		
		//System.out.println(mr2.minMeetingRooms(intervals2));
		
		// [[1293,2986],[848,3846],[4284,5907],[4466,4781],[518,2918],[300,5870]]
		int intervals3[][] = {{1293,2986},{848,3846},{4284,5907},{4466,4781}, {518,2918}, {300,5870}};		
		System.out.println(mr2.minMeetingRooms(intervals3));
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
	}
	
	 public int minMeetingRooms(int[][] intervals) {
		 
		 List<Integer> rooms = new ArrayList<Integer>(); 
		 
		 PriorityQueue<Meeting> q = new PriorityQueue<MeetingRoomsII.Meeting>(intervals.length, new MeetingComporator());
		 
		 for(int i=0; i<intervals.length; i++) {
			 q.add(new Meeting(intervals[i][0], intervals[i][1]));
		 }
		 
		 while(!q.isEmpty()) {
			 
			 Meeting m = q.peek();
			 boolean added = false;
			 
			 for(int i=0; i< rooms.size(); i++) {
				 if(rooms.get(i)<=m.start) {
					 rooms.set(i, m.end);
					 added = true;
					 break;
				 }
			 }
			 
			 if(!added) {
				 rooms.add(m.end);
			 }
			 
			 q.remove(m);
		 }
		 
		 return rooms.size();	        
	  }

}
