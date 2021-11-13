package com.nacaroglu.dsa.practice.sorting;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class GroupByAge {
	
	public static class Person implements Comparable<Person>{
		int age;
		String name;
		
		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}	
		
		public int compareTo(Person p) {
			return this.age-p.age;
		}
	}

	public static void main(String[] args) {
		
		GroupByAge g = new GroupByAge();
		List<Person> people = new ArrayList<>();
		people.add(new Person(41, "Ahmet"));
		people.add(new Person(38, "Emin"));
		people.add(new Person(44, "Mehmet Ali"));
		people.add(new Person(42, "Ersen"));
		people.add(new Person(41, "Muammer"));
		people.add(new Person(38, "Altay"));
		people.add(new Person(42, "Bilal"));
		people.add(new Person(40, "Gurhan"));
				
		List<Person> result = g.groupByAge(people );
		
		for (Person person : result) {
			System.out.println(person.toString());
		}
	}
	
	public List<Person> groupByAge(List<Person> people) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Person person : people) {
			map.put(person.age, map.getOrDefault(person.age, 0)+1);
		}
		
		List<Person> result = new ArrayList<Person>();
		
		
		for (Integer age : map.keySet()) {
			
			for (Person person : people) {
				if(person.age==age) {
					result.add(person);
				}
			}
		}
		
		return result;
	}

}
