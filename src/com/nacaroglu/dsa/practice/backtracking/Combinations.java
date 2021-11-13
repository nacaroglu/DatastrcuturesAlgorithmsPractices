package com.nacaroglu.dsa.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Combinations c = new Combinations();
		c.combine(4, 1);

		System.out.println("Bitti");
	}
	
	 public List<List<Integer>> combine(int n, int k) {
		 
		 List<List<Integer>> result = new LinkedList<List<Integer>>();
		 
		 result = backtrack(n, k, 0, result);
		 
		 return result;
	 }
	 
		public List<List<Integer>> backtrack(int n, int k, int level, List<List<Integer>> result) {

			List<List<Integer>> tempResult = new ArrayList<List<Integer>>();

			if (level == k) {
				return result;
			}

			if (result.isEmpty()) {
				for (int i = 1; i <= n; i++) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(i);
					tempResult.add(list);

				}
			} else {

				for (List<Integer> list : result) {

					for (int i = 1; i <= n; i++) {

						List<Integer> newList = new ArrayList<Integer>(list);

						newList.add(i);

						if (doControl(newList, tempResult)) {
							tempResult.add(newList);
						}
					}
				}
			}

			result = tempResult;

			return backtrack(n, k, level + 1, result);
		}

		private boolean doControl(List<Integer> newList, List<List<Integer>> tempResult) {

			int item = newList.get(0);

			for (int i = 1; i < newList.size(); i++) {
				if (newList.get(i) == item) {
					return false;
				}
			}

			List<Integer> newListCopy = new ArrayList<Integer>(newList);
			Collections.sort(newListCopy);

			HashSet<Integer> set = new HashSet<Integer>(newListCopy);

			if (set.size() < newListCopy.size()) {
				return false;
			}

			for (List<Integer> tempItem : tempResult) {

				boolean isEqual = tempItem.equals(newListCopy);

				if (isEqual) {
					return false;
				}

			}

			return true;
		}

}
