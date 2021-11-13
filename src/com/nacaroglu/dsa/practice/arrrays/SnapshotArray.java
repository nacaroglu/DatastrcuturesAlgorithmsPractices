package com.nacaroglu.dsa.practice.arrrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SnapshotArray {

	public static void main(String[] args) {

		// ["SnapshotArray","set", "set", "snap", "set", "get", "get", "set","get",
		// "snap", "get" ]
		// [[3], [0,5], [1,6], [], [0,6], [0,0], [1,0], [1,7], [1,0], [], [1,1]]

		
		
	
		
		/*
		  SnapshotArray s = new SnapshotArray(4);
		 
		  s.set(0,5); 
		  s.set(1,6);
		  s.set(3,31); 
		  System.out.println(s.snap());
		  s.set(0,8);
		  s.set(1,10);
		  s.set(2,12);
		  System.out.println(s.snap());
		  System.out.println(s.get(0,0)); 
		  System.out.println(s.get(1,0));
		  System.out.println(s.get(1,1)); 
		  System.out.println(s.get(2,1));
		  s.set(1,7); 
		  System.out.println(s.snap());
		  System.out.println(s.get(1,1));
		  System.out.println(s.get(3,2));
		  
	*/
	}

	int arr[];
	HashMap<Integer, HashMap<Integer, Integer>> snapShots;
	int counter = -1;
	HashMap<Integer, Integer> setMap;
	
	public SnapshotArray(int length) {
		arr = new int[length];
		snapShots = new HashMap<Integer, HashMap<Integer, Integer>>();
		setMap = new HashMap<Integer, Integer>();
	}

	public void set(int index, int val) {
		if (index < arr.length) {
			arr[index] = val;
			setMap.put(index, val);
		}
	}

	public int snap() {

		counter = counter + 1;
		snapShots.put(counter, setMap);
		setMap = new HashMap<Integer, Integer>();
		return counter;
	}

	public int get(int index, int snap_id) {

		for (int i = snap_id; i >= 0; i--) {
			if (snapShots.get(i).containsKey(index)) {
				return snapShots.get(i).get(index);
			}
		}

		return 0;
	}
}
