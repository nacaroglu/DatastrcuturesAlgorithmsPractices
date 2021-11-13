package com.nacaroglu.dsa.practice.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HighestAverageScore {
	
	public static class TestScore implements Comparable<TestScore> {
		
		String studentID;
		int score;

		public TestScore(String studentID, int score) {
			super();
			this.studentID = studentID;
			this.score = score;
		}
		
		public TestScore() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public int compareTo(TestScore o) {
			return o.score-this.score;
		}

		@Override
		public String toString() {
			return "TestScore [studentID=" + studentID + ", score=" + score + "]";
		}		
	}

	public static void main(String[] args) {
		// Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
		
		List<TestScore>  nameScoreData = new ArrayList<TestScore>();
		nameScoreData.add(new TestScore("Bob", 87));
		nameScoreData.add(new TestScore("Mike", 35));
		nameScoreData.add(new TestScore("Bob", 52));
		nameScoreData.add(new TestScore("Jason", 98));
		nameScoreData.add(new TestScore("Mike", 50));
		nameScoreData.add(new TestScore("Jessica", 99));
		
		nameScoreData.add(new TestScore("Bob", 67));
		nameScoreData.add(new TestScore("Mike", 75));
		nameScoreData.add(new TestScore("Bob", 98));
		nameScoreData.add(new TestScore("Jason", 99));
		nameScoreData.add(new TestScore("Mike", 94));
		nameScoreData.add(new TestScore("Jessica", 89));
		nameScoreData.add(new TestScore("Jessica", 79));
		
		HighestAverageScore has = new HighestAverageScore();
		TestScore result = has.findStudentWithHighestBestOfThreeScores(nameScoreData, 4);
		System.out.println(result);

	}
	
	public TestScore findStudentWithHighestBestOfThreeScores ( List<TestScore>  nameScoreData, int k) {
		
		Map<String, PriorityQueue<Integer>> scores = new HashMap<String, PriorityQueue<Integer>>();
		
		for (TestScore test : nameScoreData) {
			
			if(scores.containsKey(test.studentID)) {
				scores.get(test.studentID).add(test.score);
			}else {
				PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) -> n2 - n1);
				q.add(test.score);
				scores.put(test.studentID,  q);
			}
		}
		
		TestScore bestStudent = new TestScore();
		
		for(String studentID: scores.keySet()) {			
			PriorityQueue<Integer> studentScores = scores.get(studentID);
			if(studentScores.size()<k) {
				continue;
			}
			
			int sum = 0;
			for(int i=0; i<k; i++) {
				sum += studentScores.poll();
			}
			
			int avg = sum/k;
			
			if(avg>bestStudent.score) {
				bestStudent.studentID = studentID;
				bestStudent.score = avg;
			}
		}		
		
		return bestStudent;
	}

}
