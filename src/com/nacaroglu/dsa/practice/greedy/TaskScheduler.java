package com.nacaroglu.dsa.practice.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	public static class Task implements Comparable<Task>{
		
		Character task;
		int count;	
		
		public Task(Character task, int count) {
			super();
			this.task = task;
			this.count = count;
		}
		
		@Override
		public int compareTo(Task o) {
			// TODO Auto-generated method stub
			return o.count-this.count;
		}

		@Override
		public String toString() {
			return "Task [task=" + task + ", count=" + count + "]";
		}
	}

	public static void main(String[] args) {
		
		TaskScheduler ts = new TaskScheduler();
		
		char[] tasks = {'A','A','A','B','B','B'};		
		//ts.leastInterval(tasks, 2);
		
		char[] tasks2 = {'A','A','A','B','B','B'};		
		//ts.leastInterval(tasks2, 0);
		
		char[] tasks3 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		
		ts.leastInterval(tasks3, 2);
	}
	
	public int leastInterval(char[] tasks, int n) {
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < tasks.length; i++) {
			
			if(map.containsKey(tasks[i])) {
				map.put(tasks[i], map.get(tasks[i])+1);
			}else {
				map.put(tasks[i],1);
			}
		}
		
		PriorityQueue<Task> q = new PriorityQueue<Task>();
		
		for(Character c: map.keySet()) {
			Task t = new Task(c, map.get(c));
			q.add(t);
		}
		
		HashMap<Character, Integer> indexMap = new HashMap<Character, Integer>();
		
		List<Character> resultList = new ArrayList<Character>();
		
		
		
		while(!q.isEmpty()) {
			
			Task task = decideNextTask(q, indexMap, n, resultList.size());
			
			if(task==null) {
				resultList.add('.');
			}else {
				indexMap.put(task.task, resultList.size());
				resultList.add(task.task);		
				
				// remove task from queue
				if(task.count==1) {
					q.remove(task);
				}else {
					task.count--;
					q.remove(task);
					q.add(task);	
				}
			}			
		}	
        
        return resultList.size();
    }

	private Task decideNextTask(PriorityQueue<Task> q, HashMap<Character, Integer> indexMap, int n, int index) {
		
		Task t = q.peek();
		
		if(index==0) {
			return t;
		}
		
		List<Task> temp = new ArrayList<Task>();
		
		while(!q.isEmpty()) {
			
			int lastIndex = indexMap.getOrDefault(t.task,-1);
			
			if(lastIndex == - 1 || index-lastIndex>n) {				
				q.addAll(temp);				
				return t;
			}else {
				temp.add(q.poll());
				t = q.peek();
			}			
		}
		
		q.addAll(temp);
		return null;
	}

}
