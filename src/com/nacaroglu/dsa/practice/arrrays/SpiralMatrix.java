package com.nacaroglu.dsa.practice.arrrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SpiralMatrix {

	public static void main(String[] args) {
		
		SpiralMatrix sm = new SpiralMatrix();
		
		
		//int[][] matrix = { { 1, 2, 3 }, { 4,5,6 }, {7,8,9} }; 
		
		//sm.spiralOrder(matrix);
		
		//int[][] matrix = { { 1, 2, 3,4 }, { 5,6,7,8 }, {9,10,11,12} }; 
		int[][] matrix = { { 3 }, { 2 } }; 
		sm.spiralOrder(matrix);

	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> resultList = new ArrayList<Integer>();	
		
		Set<String> visited = new TreeSet<String>();
		
		int H = matrix.length;
		int W = matrix[0].length;		
		
		int x = 0; 
		int y = 0;
		
		
		String direction = "R";
		
		int val = matrix[0][0];					
		resultList.add(val);
		visited.add(x+"_"+y);
		
		boolean canMove = true;
		
		canMove = canMove(matrix, visited, x, y, direction, H, W);
		if(!canMove) {
			if(direction=="R") {
				direction = "D";
				canMove = canMove(matrix, visited, x, y, direction, H, W);
			}else if(direction=="D") {
				direction = "L";
				canMove = canMove(matrix, visited, x, y, direction, H, W);
			}
			else if(direction=="L") {
				direction = "U";
				canMove = canMove(matrix, visited, x, y, direction, H, W);
			}	
			else if(direction=="U") {
				direction = "R";
				canMove = canMove(matrix, visited, x, y, direction, H, W);
			}	
		}	
		
		while(canMove) {		
				
			if(direction=="L") {
				y = y-1;			
			}
			
			if(direction=="R") {
				y = y+1;			
			}
			
			if(direction=="U") {
				x= x-1;					
			}
			
			if(direction=="D") {
				x= x+1;							
			}	
			
			val = matrix[x][y];					
			resultList.add(val);
			visited.add(x+"_"+y);
				
			canMove = canMove(matrix, visited, x, y, direction, H, W);
			
			if(!canMove) {
				if(direction=="R") {
					direction = "D";
					canMove = canMove(matrix, visited, x, y, direction, H, W);
				}else if(direction=="D") {
					direction = "L";
					canMove = canMove(matrix, visited, x, y, direction, H, W);
				}
				else if(direction=="L") {
					direction = "U";
					canMove = canMove(matrix, visited, x, y, direction, H, W);
				}	
				else if(direction=="U") {
					direction = "R";
					canMove = canMove(matrix, visited, x, y, direction, H, W);
				}	
			}				
				
		}	;
		
		return resultList;
    }
	

	private boolean canMove(int[][] matrix, Set<String> visited, int x, int y, String direction, int H, int W) {
		
		if(direction=="L") {
			y = y-1;
			if(y<0) {
				return false;
			}
		}
		
		if(direction=="R") {
			y = y+1;
			if(y>=W) {
				return false;
			}
		}
		
		if(direction=="U") {
			x= x-1;			
			if(x<0) {
				return false;
			}				
		}
		
		if(direction=="D") {
			x= x+1;			
			if(x>=H) {
				return false;
			}				
		}
		
		if(visited.contains(x+"_"+y)) {
			return false;
		}
		
		return true;
	}
}
