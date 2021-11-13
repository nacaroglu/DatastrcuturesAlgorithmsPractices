package com.nacaroglu.dsa.practice._mixed;

public class BuyAndSellStock {
	
	public static void main(String[] args) {	
		
		BuyAndSellStock bs = new  BuyAndSellStock();
		
		int[] stocks = {310,315, 275, 295, 260, 270, 290, 230, 255, 250};
		
		//int[] stocks = {7,6,4,3,1};
		
		System.out.println(bs.buySellOnce(stocks)); 
		
		
		System.out.println(17%5);
		
	}

	private int buySellOnce(int[] stocks) {
		
		int maxProfit = 0;
		int profit = 0;
		int min;
		int max;
		
		min = stocks[0];
		max = stocks[0];
		
		for(int i=0; i< stocks.length; i++) {
			
			if(stocks[i]<min) {
				min = stocks[i];
				max=0;
			}		
			
			max = Math.max(stocks[i], max);
			
			profit = max-min;			
			
			if(profit>maxProfit) {
				maxProfit = profit;
			}
		}
		
		return maxProfit;
	}

}
