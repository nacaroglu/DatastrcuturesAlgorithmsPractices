package com.nacaroglu.dsa.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class BestTimeToBuySel {
	
	public static class StockTrade {
		
		int buyIndex;
		int sellIndex;
		int buyValue;
		int sellValue;
		int profit;	
		
		
		public StockTrade(int[] prices, int buyIndex, int sellIndex) {
			super();
			this.buyIndex = buyIndex;
			this.sellIndex = sellIndex;
			buyValue = prices[buyIndex];
			sellValue = prices[sellIndex];
			profit = sellValue-buyValue;
		}
		
		public int getBuyIndex() {
			return buyIndex;
		}
		public void setBuyIndex(int buyIndex) {
			this.buyIndex = buyIndex;
		}
		public int getBuyValue() {
			return buyValue;
		}
		public void setBuyValue(int buyValue) {
			this.buyValue = buyValue;
		}

		@Override
		public String toString() {
			return "StockTrade [buyIndex=" + buyIndex + ", sellIndex=" + sellIndex + ", buyValue=" + buyValue
					+ ", sellValue=" + sellValue + ", profit=" + profit + "]";
		}
		
		
		
	}

	public static void main(String[] args) {
		
		BestTimeToBuySel bst= new BestTimeToBuySel();
		
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(bst.maxProfit(prices));

	}
	
	public int maxProfit(int[] prices) {
		
		HashMap<Integer, List<StockTrade>> map = buildMap(prices);
		
		TreeSet<Integer> keySet = new TreeSet<Integer>(map.keySet());
		
		for(int profit: keySet.descendingSet()) {
			
			List<StockTrade> trades = map.get(profit);
			
			for (StockTrade trade : trades) {
				List<StockTrade> compatibles = findCompatibles(trade,map);
			}
		}
    
		return 0;
    }

	private List<StockTrade> findCompatibles(StockTrade trade, HashMap<Integer, List<StockTrade>> map) {
		// TODO Auto-generated method stub
		return null;
	}

	private HashMap<Integer, List<StockTrade>> buildMap(int[] prices) {
		HashMap<Integer, List<StockTrade>> map = new HashMap<Integer, List<StockTrade>>();
		
		
		for (int sellIndex = 1; sellIndex < prices.length; sellIndex++) {
			
			for(int buyIndex=sellIndex-1; buyIndex>=0; buyIndex-- ) {
		
				if(prices[sellIndex]>prices[buyIndex]) {
					StockTrade trade = new StockTrade(prices, buyIndex, sellIndex);
					
					if(map.containsKey(trade.profit)) {
						map.get(trade.profit).add(trade);
					}else {
						List<StockTrade> trades = new ArrayList<BestTimeToBuySel.StockTrade>();
						trades.add(trade);
						map.put(trade.profit, trades);						
					}				
				}
			}
		}
		return map;
	}
}
