package com.nacaroglu.dsa.practice.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {

	public static class Project implements Comparable<Project> {
		int capital;
		int profit;		

		public Project(int capital, int profit) {
			super();
			this.capital = capital;
			this.profit = profit;
		}

		@Override
		public int compareTo(Project o) {
			return o.profit - this.profit;
		}

		@Override
		public String toString() {
			return "Project [capital=" + capital + ", profit=" + profit + "]";
		}
	}

	public static void main(String[] args) {
		
		IPO ipo = new IPO();
		int[] capital = {0,1,1};
		int[] profits = {1,2,3};
		int result = ipo.findMaximizedCapital(3, 0, profits, capital);
		System.out.println(result);
	}

	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		
		PriorityQueue<Project> projects = new PriorityQueue<Project>();
		for (int i = 0; i < capital.length; i++) {
			projects.add(new Project(capital[i], profits[i]));
		}
		
		for(int i=0;i<k; i++) {
			List<Project> temp = new ArrayList<IPO.Project>();
			
			while(!projects.isEmpty()) {
				
				Project p = projects.peek();
				if(p.capital<=w) {
					w+= p.profit;
					projects.poll();
					break;
				}else {
					temp.add(p);
					projects.poll();
				}
			}
			
			projects.addAll(temp);
		}	

		return w;
	}

}
