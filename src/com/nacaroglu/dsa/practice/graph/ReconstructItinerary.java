package com.nacaroglu.dsa.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	public static void main(String[] args) {
		
		ReconstructItinerary rci = new ReconstructItinerary();		
		String[][] arr =  {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		List<List<String>> tickets = buildTicketList(arr);				
		//rci.findItinerary(tickets);
		
		String[][] arr2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		//rci.findItinerary(buildTicketList(arr2));
		
		String[][] arr3 = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		rci.findItinerary(buildTicketList(arr3));
	}

	private static List<List<String>> buildTicketList(String[][] arr) {
		List<List<String>> tickets = new ArrayList<List<String>>();
		for(int i=0; i<arr.length; i++) {
			List<String> ticket = new ArrayList<String>();
			ticket.add(arr[i][0]);
			ticket.add(arr[i][1]);
			tickets.add(ticket);
		}
		return tickets;
	}
	
	public List<String> findItinerary(List<List<String>> tickets) {
        
		LinkedList<String> result = new LinkedList<String>();
		
		Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
		
		for (List<String> ticket : tickets) {
			
			PriorityQueue<String> q = null;
			
			if(map.containsKey(ticket.get(0))) {
				q = map.get(ticket.get(0));				
			}else {
				q = new PriorityQueue<String>();
			}
			q.add(ticket.get(1));
			map.put(ticket.get(0), q);
		}
		
		dfs(result, map, "JFK");
		
		return result; 
		
    }

	private void dfs(LinkedList<String> result, Map<String, PriorityQueue<String>> map, String start) {
		
		PriorityQueue<String> q = map.get(start);		
		
		while(q!=null && !q.isEmpty()) {
			dfs(result, map, q.poll());
		}
		
		result.addFirst(start);
		
	}
	
	
	Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

   public List<String> findItinerary2(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        
        for (List<String> ticket : tickets) {
			
			PriorityQueue<String> q = null;
			
			if(flights.containsKey(ticket.get(0))) {
				q = flights.get(ticket.get(0));				
			}else {
				q = new PriorityQueue<String>();
			}
			q.add(ticket.get(1));
			flights.put(ticket.get(0), q);
		}
       
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }

}
