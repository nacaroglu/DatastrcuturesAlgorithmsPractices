package com.nacaroglu.dsa.practice.heaps;

public class Point implements Comparable<Point> {

	int x;
	int y;
	int distanceToOrigin;	
	
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		distanceToOrigin = x*x + y*y;
	}

	@Override
	public int compareTo(Point o) {						
		return o.distanceToOrigin-this.distanceToOrigin;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
