package com.nacaroglu.dsa.practice._mixed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class FreqStack {
	
	public static class Foo{		
		int count;
		List<Integer> items;	
	}
	
	public static class FooCompatator implements Comparator<Foo>{
		public int compare(Foo o1, Foo o2) {			
			return o2.count- o1.count; 
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public FreqStack() {
		
		//HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		PriorityQueue<Foo> que = new PriorityQueue<Foo>();
		
	

	}

	public void push(int x) {

	}

	

}
