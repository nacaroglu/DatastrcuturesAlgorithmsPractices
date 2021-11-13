package com.nacaroglu.dsa.practice.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RenderCalendar  {
	
	public static class Event implements Comparable<Event>{
		
		int start;
		int end;
		
		public Event(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Event o) {			
			return this.start-o.start;
		}

		@Override
		public String toString() {
			return "Event [start=" + start + ", end=" + end + "]";
		}

		public void intersect(Event event) {
			
			start = Math.max(start, event.start);
			end = Math.min(end, event.end);		
		}	
		
		public void merge(Event event) {
			
			start = Math.min(start, event.start);
			end = Math.max(end, event.end);		
		}
		
		public boolean isIntersect(Event event) {
			
			if(this.end<event.start) {
				return false;
			}
			
			return true;
		}
	}
			
	public static void main(String[] args) {
		
		RenderCalendar calRender = new RenderCalendar();
		
		/*
		List<Event> events = new ArrayList<Event>();
		events.add(new Event(1,5));
		events.add(new Event(6,10));
		events.add(new Event(11,13));
		events.add(new Event(14,15));
		events.add(new Event(2,7));
		events.add(new Event(8,9));
		events.add(new Event(12,15));
		events.add(new Event(4,5));
		events.add(new Event(9,17));
		
		
		System.out.println(calRender.render(events));
		*/
		
		//int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		//calRender.merge(intervals);
		
		int[][] intervals = {{-4, -1},{0, 2},{3, 6},{7, 9},{11,12},{14,17}};
		calRender.mergeAdd(intervals, new Event(1, 8));
	}
	
	
	
	public int[][] merge(int[][] intervals) {
		
		if(intervals.length==1) {
			return intervals;
		}
		
		List<Event> events = new ArrayList<Event>(); 
		
		for(int i=0; i<intervals.length; i++) {
			events.add(new Event(intervals[i][0], intervals[i][1]));
		}
		
		Collections.sort(events);
		
		Event intersection = new Event(events.get(0).start, events.get(0).end);
		List<Event> result = new ArrayList<Event>();
		
		for(int i=1; i<events.size(); i++) {	
			
			Event curr = events.get(i);
			
			if(intersection.isIntersect(curr)) {
				intersection.merge(curr);
			}else {
				
				result.add(intersection);				
				intersection = new Event(curr.start, curr.end);			
			}			
		}
		
		result.add(intersection);
		int[][] arr = new int[result.size()][2];
		
		for(int i=0; i<result.size(); i++) {
			arr[i][0] = result.get(i).start;
			arr[i][1] = result.get(i).end;
		}
        
		
		return arr;
    }
	
	public int render(List<Event> events) {
		
		int max = 0;
		
		Collections.sort(events);
		
		Event intersection = new Event(0, 24);
		
		int count = 0;
		
		for(int i=0; i<events.size(); i++) {	
			
			Event curr = events.get(i);
			
			if(intersection.isIntersect(curr)) {
				intersection.intersect(curr);
				count++;
				max = Math.max(count, max);
				System.out.println("Max: " + max + " " +  intersection.toString());
			}else {
				intersection.start = curr.start;
				intersection.end = curr.end;
				count = 0;
			}			
		}
		
		return max;
	}
	
	public int[][] mergeAdd(int[][] intervals, Event e) {
		
		if(intervals.length==1) {
			return intervals;
		}
		
		List<Event> events = new ArrayList<Event>(); 
		
		for(int i=0; i<intervals.length; i++) {
			events.add(new Event(intervals[i][0], intervals[i][1]));
		}
		
		events.add(e);
		
		Collections.sort(events);
		
		Event event = new Event(events.get(0).start, events.get(0).end);
		List<Event> result = new ArrayList<Event>();
		
		for(int i=1; i<events.size(); i++) {	
			
			Event curr = events.get(i);
			
			if(event.isIntersect(curr)) {
				event.merge(curr);
			}else {
				
				result.add(event);				
				event = new Event(curr.start, curr.end);			
			}			
		}
		
		result.add(event);
		int[][] arr = new int[result.size()][2];
		
		for(int i=0; i<result.size(); i++) {
			arr[i][0] = result.get(i).start;
			arr[i][1] = result.get(i).end;
		}
        
		
		return arr;
    }

}
