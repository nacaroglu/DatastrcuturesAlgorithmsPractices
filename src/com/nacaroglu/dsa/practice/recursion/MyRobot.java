package com.nacaroglu.dsa.practice.recursion;

import com.nacaroglu.dsa.practice.recursion.RobotRoomCleaner.Direction;

public class MyRobot implements Robot {
	
	int[][] room;
	int rowCount;
	int colCount;
	int r;
	int c;
	Direction direction;

	public MyRobot(int row, int col) {
		
		super();		
		this.rowCount = row;
		this.colCount = col;
		
		this.room = new int[row][col];
		
		for(int i=0; i< room.length; i++) {
			for(int j=0; j<room[0].length; j++) {
				room[i][j]=1;
			}
		}
	}
	
	public void init(int r, int c) {
		this.r = r;
		this.c = c;		
		this.direction = Direction.UP;
	}
	
	public void addWall(int r, int c) {
		room[r][c] = 0;
	}

	@Override
	public boolean move() {
		
		if(direction==Direction.UP) {
			if(r==0 || room[r-1][c]==0) {
				return false;
			}
			else {				
				return true;
			}
		}
		
		if(direction==Direction.DOWN) {
			if(r==rowCount-1 || room[r+1][c]==0) {
				return false;
			}
			else {				
				return true;
			}
		}
		
		if(direction==Direction.LEFT) {
			if(c==0 || room[r][c-1]==0) {
				return false;
			}
			else {				
				return true;
			}
		}
		
		if(direction==Direction.RIGHT) {
			if(c==colCount-1 || room[r][c+1]==0) {
				return false;
			}
			else {				
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void turnLeft() {
		
		if(direction ==Direction.UP) {
			direction = Direction.LEFT;
		} else if(direction==Direction.DOWN) {
			direction = Direction.RIGHT;
		} else if(direction==Direction.RIGHT) {
			direction = Direction.UP;
		} else if(direction ==Direction.LEFT) {
			direction =  Direction.DOWN;
		}
		
		System.out.println("Turning left");
	}

	@Override
	public void turnRight() {
		
		if(direction ==Direction.UP) {
			direction = Direction.RIGHT;
		} else if(direction==Direction.DOWN) {
			direction = Direction.LEFT;
		} else if(direction==Direction.RIGHT) {
			direction = Direction.DOWN;
		} else if(direction ==Direction.LEFT) {
			direction =  Direction.UP;
		}		
		
		System.out.println("Turning right");
	}

	@Override
	public void clean() {
		
		if(direction==Direction.UP) {
			r--;								
		}
		
		if(direction==Direction.DOWN) {			
			r++;			
		}
		
		if(direction==Direction.LEFT) {
			c--;			
		}
		
		if(direction==Direction.RIGHT) {		
			c++;			
		}		
	}

	@Override
	public String toString() {
		return "MyRobot [r=" + r + ", c=" + c + ", face=" + direction + "]";
	}
	
	
}
