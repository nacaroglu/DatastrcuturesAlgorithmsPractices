package com.nacaroglu.dsa.practice.recursion;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
	
	public enum Direction {
	    UP,
	    RIGHT,	    
	    DOWN,
	    LEFT
	  }
	
	public static class Cell{
		
		int r;
		int c;	
		
				
		public Cell(int x, int y) {
			super();
			this.r = x;
			this.c = y;
		}


		@Override		
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + r;
			result = prime * result + c;
			return result;
		}
		
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (r != other.r)
				return false;
			if (c != other.c)
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + "]";
		}	
	}
	
	public static void main(String[] args) {

		MyRobot robot = new MyRobot(5, 8);
		robot.init(1, 3);
		robot.addWall(0, 5);
		robot.addWall(1, 5);
		robot.addWall(2, 1);

		robot.addWall(3, 0);
		robot.addWall(3, 1);
		robot.addWall(3, 2);
		robot.addWall(3, 4);
		robot.addWall(3, 5);
		robot.addWall(3, 6);
		robot.addWall(3, 7);

		RobotRoomCleaner cleaner = new RobotRoomCleaner();
		cleaner.cleanRoom(robot);
		System.out.println(robot.toString());
		System.out.println("bitti");
	}

	/**
	 * // This is the robot's control interface. // You should not implement it, or
	 * speculate about its implementation interface Robot { // Returns true if the
	 * cell in front is open and robot moves into the cell. // Returns false if the
	 * cell in front is blocked and robot stays in the current cell. public boolean
	 * move();
	 *
	 * // Robot will stay in the same cell after calling turnLeft/turnRight. // Each
	 * turn will be 90 degrees. public void turnLeft(); public void turnRight();
	 *
	 * // Clean the current cell. public void clean(); }
	 */

	public void cleanRoom(Robot robot) {

		/*
		 * def backtrack(candidate): if find_solution(candidate): output(candidate)
		 * return
		 * 
		 * # iterate all possible candidates. for next_candidate in list_of_candidates:
		 * if is_valid(next_candidate): # try this partial candidate solution
		 * place(next_candidate) # given the candidate, explore further.
		 * backtrack(next_candidate) # backtrack remove(next_candidate)
		 */
		
		Set<Cell> visited = new HashSet<Cell>();		
		Cell position = new Cell(0,0);
		Direction dir = Direction.UP;		
		visited.add(position);
		backtrack(robot, visited, position, dir);
	}
	
	public void backtrack(Robot robot, Set<Cell> visited, Cell position, Direction dir) {
		
		robot.clean();		
		visited.add(position);	
		Cell newPosition = calculateNewPosition(position, dir);	
		//System.out.println("Visited added" + position.toString());
		
		for(Direction dx: Direction.values()) {
			
			//System.out.println("Direction: " + dx);			

			if (!visited.contains(newPosition) && robot.move()) {				
				backtrack(robot, visited, newPosition, dx);
				goBack(robot);
			}		
			
			robot.turnRight();
		}		
	}

	private void goBack(Robot robot) {	
		//System.out.println("going back...");
		robot.turnRight();
		robot.turnRight();
		robot.move();		
	    robot.turnRight();
	    robot.turnRight();		
	}

	private Cell calculateNewPosition(Cell position, Direction dir) {
		
		Cell newPosition = new Cell(position.r, position.c);
		
		if(dir == Direction.UP) {
			newPosition.r = newPosition.r - 1; 
		} else	if(dir== Direction.DOWN) {
			newPosition.r = newPosition.r + 1;
		} else 	if(dir == Direction.LEFT) {
			newPosition.c = newPosition.c - 1;
		} else 	if(dir == Direction.RIGHT) {
			newPosition.c = newPosition.c +1;
		}		
		return newPosition;				
	}
	
}
