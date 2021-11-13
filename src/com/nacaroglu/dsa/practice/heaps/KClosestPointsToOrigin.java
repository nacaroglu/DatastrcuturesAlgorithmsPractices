package com.nacaroglu.dsa.practice.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {


		KClosestPointsToOrigin kk = new KClosestPointsToOrigin();
		int[][] points = new int[3][2];
		points[0][0] = 3; points[0][1] = 3;
		points[1][0] = 5; points[1][1] = -1;
		points[2][0] = -2; points[2][1] = 4;
		
		kk.kClosest(points , 2);
	}
	
	public int[][] kClosest(int[][] points, int k) {
		
		List<Point> list = new ArrayList<Point>();
		PriorityQueue<Point> q = new PriorityQueue<>();
		
		for(int i=0; i<points.length; i++) {			
			list.add(new Point(points[i][0], points[i][1]));
		}
		
		for (Point p : list) {
			q.add(p);

			if (q.size() > k) {
				q.poll();
			}
		}
		
		int[][] result = new int[q.size()][2];
		
		int i=0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			result[i][0] = p.x;
			result[i][1] = p.y;
			i++;
		}
        
		return result;
    }
}
