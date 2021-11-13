package com.nacaroglu.dsa.practice.arrrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public static class Point {

		int x;
		int y;
		int distance;

		public Point(int i, int j) {
			x = i;
			y = j;
			distance = x * x + y * y;
		}

		@Override
		public String toString() {
			return "X: " + x + " Y: " + y;
		}

	}

	public static class PointComporator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			return o1.distance - o2.distance;
		}
	}

	public static void main(String args[]) {

		KClosestPointsToOrigin kcpto = new KClosestPointsToOrigin();

		int points[][] = { { 1, 3 }, { -2, 2 } };
		// kcpto.kClosest(points, 1);

		int points2[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		// kcpto.kClosest(points2, 2);

		int points3[][] = { { 3, 3 } };
		kcpto.kClosest(points3, 1);

	}

	public int[][] kClosest(int[][] points, int K) {

		int result[][] = new int[K][];

		PriorityQueue<Point> q = new PriorityQueue<Point>(points.length, new PointComporator());

		for (int i = 0; i < points.length; i++) {
			q.add(new Point(points[i][0], points[i][1]));
		}

		int counter = 0;

		while (!q.isEmpty() && counter < K) {

			Point m = q.peek();

			result[counter] = new int[2];
			result[counter][0] = m.x;
			result[counter][1] = m.y;

			counter++;

			q.remove();
		}

		return result;
	}

}
