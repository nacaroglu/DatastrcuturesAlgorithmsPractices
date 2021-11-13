package com.nacaroglu.dsa.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	
	public static class Item{
		
		int profit;
		int weight;
		
		public Item(int p, int w) {
			weight = w;
			profit = p;
		}
	}

	public static void main(String[] args) {
	    Knapsack ks = new Knapsack();
	    int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    int maxProfit = ks.solveKnapsack(profits, weights, 7);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    maxProfit = ks.solveKnapsack(profits, weights, 6);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    
	    maxProfit = ks.solveKnapsack_topdown(profits, weights, 7);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    maxProfit = ks.solveKnapsack_topdown(profits, weights, 6);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    
	    maxProfit = ks.solveKnapsackBottomUp(profits, weights, 7);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    //maxProfit = ks.solveKnapsackBottomUp(profits, weights, 6);
	    //System.out.println("Total knapsack profit ---> " + maxProfit);
	  }
	
	public int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
		
		int n = weights.length;
		
		int[][] dp = new int[n+1][capacity+1];		

		for(int r = 0; r<=n; r++) {
			for(int c = 0; c<= capacity; c++ ) {				
				if(c==0|| r==0) {
					dp[r][c]=0;
				} else 	if(weights[r-1]<=c) {
					dp[r][c] = Math.max(profits[r-1] + dp[r-1][c-weights[r-1]]  ,  dp[r-1][c]);
				}else {				
					dp[r][c] = dp[r-1][c];
				}
			} 
		}
		
		List<Integer> items = new ArrayList<>();
		int C = capacity;
		for(int r=n;r>0; r--) {
			
			if(dp[r-1][C]!=dp[r][C]) {
				items.add(weights[r-1]);
				C-= weights[r-1];  
			}
		}
		
		return dp[n][capacity];
	}
	
	public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		
		Integer[][] dp = new Integer[profits.length][capacity+1];		
		List<Item> items = buildItems(profits, weights);		
		return solveKnapsack(dp,items, capacity, 0);   
	}
	
	public int solveKnapsack(Integer[][] dp, List<Item> items, int capacity, int index) {
		
		if(capacity <= 0 || index>=items.size() ) {
			return 0;
		}
		
		if(dp[index][capacity] != null)
		      return dp[index][capacity];
		
		int profit1 = 0;
		if(capacity>=items.get(index).weight) {
			profit1 = items.get(index).profit + solveKnapsack(dp, items, capacity-items.get(index).weight, index+1);
		}
		
		int profit2 = solveKnapsack(dp, items, capacity, index+1);
		
		dp[index][capacity] = Math.max(profit1, profit2);
		
		return dp[index][capacity];
	}	

	private List<Item> buildItems(int[] profits, int[] weights) {
		
		List<Item> items = new ArrayList<Item>();
		
		for(int i=0; i<profits.length; i++) {
			items.add(new Item(profits[i], weights[i]));
		}
		
		return items;
	}
	
	public int solveKnapsack_topdown(int[] profits, int[] weights, int capacity) {

		return helper(profits.length, profits, weights, capacity, 0);
	}

	public int helper(int n, int[] profits, int[] weights, int capacity, int level) {

		if (capacity <= 0 || level >= profits.length)
			return 0;

		int select = 0;
		if (weights[level] <= capacity)
			select = profits[level] + helper(n, profits, weights, capacity - weights[level], level + 1);

		int notSelect = helper(n, profits, weights, capacity, level + 1);
		return Math.max(select, notSelect);
	}

}
