package com.nacaroglu.dsa.practice.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalaryTreshhold {

	public static void main(String[] args) {
		
		SalaryTreshhold st = new SalaryTreshhold();
		
		List<Integer> currentSalaries = new ArrayList<>();
		currentSalaries.add(90);
		currentSalaries.add(30);
		currentSalaries.add(100);
		currentSalaries.add(40);
		currentSalaries.add(20);
		System.out.println(st.findSalaryCap(210, currentSalaries));
		
		currentSalaries.clear();
		currentSalaries.add(100);
		currentSalaries.add(300);
		currentSalaries.add(200);
		currentSalaries.add(400);		
		System.out.println(st.findSalaryCap(800, currentSalaries));
		

	}
	
	public int findSalaryCap(int targetPayroll ,
			List<Integer> currentSalaries) {
		
		List<Integer> prefixSums = new ArrayList<Integer>();
		Collections.sort(currentSalaries);
		
		int sum = 0;
		int targetIndex = -1;
		
		for(int i=0; i<currentSalaries.size(); i++) {
			sum += currentSalaries.get(i);
			if(sum>targetPayroll) {
				targetIndex=i-1;
			}
			prefixSums.add(sum);
		}
		
		int cap = (targetPayroll-prefixSums.get(targetIndex-1))/(currentSalaries.size()-targetIndex);
		
		return cap;
	}
}
