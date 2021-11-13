package com.nacaroglu.dsa.practice.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ReconstructItinerary {
	
	public static class Flight implements Comparable<Flight>{
		String from;
		String to;
		
		public Flight(String from, String to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Flight o) {
			
			return this.to.compareTo(o.to);
		}

		@Override
		public String toString() {
			return "Flight [from=" + from + ", to=" + to + "]";
		}
		
	}

	public static void main(String[] args) {
		
		List<List<String>> tickets = new ArrayList<List<String>>();
		
		/*
		// [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
		tickets.add(addFlight("MUC", "LHR"));
		tickets.add(addFlight("JFK", "MUC"));
		tickets.add(addFlight("SFO", "SJC"));
		tickets.add(addFlight("LHR", "SFO"));*/
		
		// [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
		tickets.add(addFlight("JFK", "SFO"));
		tickets.add(addFlight("JFK","ATL"));
		tickets.add(addFlight("SFO","ATL"));
		tickets.add(addFlight("ATL","JFK"));
		tickets.add(addFlight("ATL","SFO"));
		
		ReconstructItinerary rci = new ReconstructItinerary();
		List<String> result = rci.findItinerary(tickets);
		
		for (String string : result) {
			System.out.println(string);
		}
		
	}

	private static List<String> addFlight(String from, String to) {
		List<String> f1 = new ArrayList<String>();
		f1.add(from);
		f1.add(to);
		return f1;
	}
	
	public List<String> findItinerary(List<List<String>> tickets) {
		
		List<Flight> flights = new ArrayList<Flight>();
		
		List<String> result = new ArrayList<String>();
		
		for (List<String> ticket : tickets) {
			flights.add(new Flight(ticket.get(0), ticket.get(1)));
		}
		
		
		HashSet<Flight> visited = new HashSet<Flight>(); 
		
		dfs(flights, visited, "JFK", result);		
        
        return result;
    }
	
	private void dfs(List<Flight> flights, Set<Flight> visited, String from, List<String> result) {
		
		Flight f = getFirst(flights, from, visited);
		
		if(f==null) {
			result.add(from);
			return;
		}
		
		visited.add(f);
		result.add(f.from);
		dfs(flights, visited, f.to, result);
	}

	private Flight getFirst(List<Flight> flights, String from, Set<Flight> visited) {
		
		SortedSet<Flight> set = new TreeSet<Flight>();
		
		for (Flight flight : flights) {
			
			if(visited.contains(flight)) {
				continue;
			}
			
			if(flight.from.equalsIgnoreCase(from)) {
				set.add(flight);
			}
		}
		
		if(set.isEmpty()) {
			return null;
		}
		
		return set.first();
	}

}
