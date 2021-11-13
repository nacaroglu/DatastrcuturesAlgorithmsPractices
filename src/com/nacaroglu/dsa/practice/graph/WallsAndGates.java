package com.nacaroglu.dsa.practice.graph;

public class WallsAndGates {
	
	public enum Direction{
		LEFT,
		RIGHT,
		UP,
		DOWN;
	}

	public static void main(String[] args) {

		int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
		
		WallsAndGates w = new WallsAndGates();
		w.wallsAndGates(rooms);

	}
	
	public void wallsAndGates(int[][] rooms) {
        
		int r = rooms.length;
		int c = rooms[0].length;
		
		int[][] visited = new int[r][c];
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++){
				
				/*
				if(rooms[i][j]==Integer.MAX_VALUE) {
					System.out.println("INF "+ canMove(rooms, i, j, r, c, Direction.UP));
				}else {
					System.out.println(rooms[i][j] + " " +  canMove(rooms, i, j, r, c, Direction.UP));
				}		*/
				
				if(rooms[i][j]!= 0 && rooms[i][j]!=-1) {
					if (canMove(rooms, i, j, r, c, Direction.DOWN) || canMove(rooms, i, j, r, c, Direction.UP)
							 || canMove(rooms, i, j, r, c, Direction.LEFT) || canMove(rooms, i, j, r, c, Direction.RIGHT)) {
						System.out.println("row: " + i + " column: " + j);
					}
				}
				
			}
			
			System.out.println("---------------------------------");
		}
    }

	private boolean canMove(int[][] rooms, int i, int j, int r, int c, Direction direction) {
		
		if(direction==Direction.UP) {
			
			if(i==0) {
				return false;
			}
			
			if(rooms[i-1][j]==-1) {
				return false;
			}
		}else if(direction==Direction.DOWN) {
			if(i==r-1) {
				return false;
			}
			
			if(rooms[i+1][j]==-1) {
				return false;
			}
		}else if(direction==Direction.LEFT) {
			if(j==0) {
				return false;
			}
			if(rooms[i][j-1]==-1) {
				return false;
			}
		}else if(direction==Direction.RIGHT) {
			
			if(j==c) {
				return false;
			}
			
			if(rooms[i][j+1]==-1) {
				return false;
			}
		}
		
		return true;
	}

}
