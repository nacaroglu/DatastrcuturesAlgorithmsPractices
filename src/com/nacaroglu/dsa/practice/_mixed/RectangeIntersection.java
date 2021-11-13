package com.nacaroglu.dsa.practice._mixed;

public class RectangeIntersection {
	
	public static class Point {
		
		public int x;
		public int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "x: " + x + " y: " +y;
		}	
		
		
	}
	
	public static class Rectangle{
		
		Point p1;
		Point p2;
		Point p3;
		Point p4;
		
		public Rectangle(Point p1, Point p2, Point p3, Point p4) {
			super();
			this.p1 = p1;
			this.p2 = p2;
			this.p3 = p3;
			this.p4 = p4;
		}
		
		public Point findLeftPoint() {
			
			if(p1.x<=p2.x) {
				return p1;
			}else {
				return p2;
			}
		}
		
		public Point findRightPoint() {
			
			if(p1.x>=p2.x) {
				return p1;
			}else {
				return p2;
			}
		}
		
		public Point findBottomPoint() {
			
			if(p1.y<=p3.y) {
				return p1;
			}else {
				return p3;
			}
		}
		
		public Point findTopPoint() {
			
			if(p1.y>=p3.y) {
				return p1;
			}else {
				return p3;
			}
		}
		
		public int area() {
			
			return Math.abs(p1.x-p2.x)* Math.abs(p2.y-p3.y);			
		}
	}	
	
	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(new Point(-3, 0), new Point(3, 0), new Point(-3, 4), new Point(3, 4));
		Rectangle r2 = new Rectangle(new Point(0, -1), new Point(9, -1), new Point(0, 2), new Point(9, 2));
		
		//Rectangle r1 = new Rectangle(new Point(-3, 0), new Point(3, 0), new Point(-3, 4), new Point(3, 4));
		//Rectangle r2 = new Rectangle(new Point(9, -1), new Point(19, -1), new Point(9, 2), new Point(19, 2));
		
		//Rectangle r1 = new Rectangle(new Point(-3, 0), new Point(3, 0), new Point(-3, 4), new Point(3, 4));
		//***Rectangle r2 = new Rectangle(new Point(-3, 0), new Point(3, 0), new Point(-3, 4), new Point(3, 4));
		
		//Rectangle r1 = new Rectangle(new Point(-3, 0), new Point(3, 0), new Point(-3, 4), new Point(3, 4));
		//Rectangle r2 = new Rectangle(new Point(0, 9), new Point(9, 9), new Point(0, 99), new Point(9, 99));
		
		RectangeIntersection ri = new RectangeIntersection();
		 
		System.out.println(ri.computeArea(r1, r2));
	}
	
	
	public int computeArea(Rectangle r1, Rectangle r2) {
		
		Point r1Left = r1.findLeftPoint();		
		Point r1Right = r1.findRightPoint();
		Point r1Bottom = r1.findBottomPoint();
		Point r1Top = r1.findTopPoint();
		
		
		Point r2Left = r2.findLeftPoint();		
		Point r2Right = r2.findRightPoint();
		Point r2Bottom = r2.findBottomPoint();
		Point r2Top = r2.findTopPoint();
		
        
		System.out.println(r1Left.toString());
		System.out.println(r1Right.toString());
		System.out.println(r1Bottom.toString());
		System.out.println(r1Top.toString());
		
		System.out.println("-----------------------------------");
		
		System.out.println(r2Left.toString());		
		System.out.println(r2Right.toString());
		System.out.println(r2Bottom.toString());
		System.out.println(r2Top.toString());
		
		
		if( (r2Left.x>=r1Left.x && r2Left.x>= r1Right.x) 
		   	&& (r2Right.x>=r1Left.x && r2Right.x>=r1Left.x)	
				) {
			System.out.println("No intersection X");
			return 0;
		}
		
		if( (r2Bottom.y>=r1Bottom.y && r2Bottom.y>=r1Top.y)
				&& (r2Top.y>=r1Top.y && r2Top.y>=r1Top.y) ) {
			
			System.out.println("No intersection Y");
			return 0;
		}
		
		int area = r1.area()+ r2.area()- (r1Right.x -r2Left.x)* (r2Top.y-r1Bottom.y);

		
		return area;
    }

}
