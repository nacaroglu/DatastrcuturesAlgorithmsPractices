package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class KthSymbolInGrammar {

	public static void main(String[] args) {

		KthSymbolInGrammar s = new KthSymbolInGrammar();
		//System.out.println(s.kthGrammar(30, 434991989));
		System.out.println(s.kthGrammar(4, 7));
		
		

	}

	public int kthGrammar(int N, int K) {
		

		List<Integer> resultList = helper(N); 

		return resultList.get(K-1);
	}

	public List<Integer> helper(int n) {
		
		List<Integer> arr = new ArrayList<Integer>();
		
		if(n==1) {
			arr.add(0);
			return arr;
		}		

		if(n==2) {
			arr.add(0);
			arr.add(1);
			return arr;
		}
		
		arr = helper(n-1);  
		calculate(arr);
		
		return arr;
	}

	private List<Integer> calculate(List<Integer> arr) {
		
		if(arr.isEmpty()) {
			arr.add(0);
			return arr;
		}		

		if(arr.size()==1) {			
			arr.add(1);
			return arr;
		}
		
		int size = arr.size();
		for(int i=size/2; i<size; i++) {
			if(arr.get(i)==0) {
				arr.add(0);
				arr.add(1);
			}else {
				arr.add(1);
				arr.add(0);
			}
		}
		
		return arr;		
	}
}
