package com.nacaroglu.dsa.practice.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {

	public static class Word implements Comparable<Word> {

		String content;
		int count;

		public Word(String content, int count) {
			super();
			this.content = content;
			this.count = count;
		}

		@Override
		public int compareTo(Word o) {
			return this.count - o.count;
		}

		@Override
		public String toString() {
			return "Word [content=" + content + ", count=" + count + "]";
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
		
		

	}

	public static void main(String[] args) {

		TopKFrequentWords tkfw = new TopKFrequentWords();
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };

		List<String> result = tkfw.topKFrequent(words , 2);
		printResult(result);

		String[] words2 = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };

		List<String> result2 = tkfw.topKFrequent(words2, 4);

		printResult(result2);
	}

	private static void printResult(List<String> result) {
		for (String s : result) {
			System.out.print(s + ", ");
		}
		
		System.out.println("");
	}

	public List<String> topKFrequent(String[] words, int k) {

		List<Word> result = new ArrayList<Word>();

		Map<String, Word> map = new HashMap<String, Word>();

		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i])) {
				map.put(words[i], new Word(words[i], 1));
			} else {
				map.get(words[i]).count += 1; 
			}
		}		

		//PriorityQueue<Word> q = new PriorityQueue<>();

		for (String word : map.keySet()) {
			result.add(map.get(word));
		}
		
		
		Collections.sort(result, Comparator.comparing(Word::getCount).reversed().thenComparing(Comparator.comparing(Word::getContent)));
		
		
		List<String> list = new ArrayList<String>();
		for (int i=0; i<k; i++) {
			list.add(result.get(i).content);
		}
		
		
		
		return list;
	}

}
