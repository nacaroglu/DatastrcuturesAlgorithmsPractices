package com.nacaroglu.dsa.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public static void main(String[] args) {
		
		NumberOfIslands noi = new NumberOfIslands();
		
		/*
		char[][] grid= {
		                {'1','1','1','1','0'},
		                {'1','1','0','1','0'},
		                {'1','1','0','0','0'},
		                {'0','0','0','0','0'}
				};
			*/		
					
		/*
		char[][] grid= {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
		}; 
		
		/*
		char[][] grid= {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}                
		}; */
		
		
		char[][] grid=
				{ { '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1',		'1' },
						{ '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1',				'0' },
						{ '1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1',								'1' },
						{ '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',								'1' },
						{ '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',								'1' },
						{ '1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1',								'1' },
						{ '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1',								'1' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1',								'1' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1',								'1' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',								'1' },
						{ '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',								'1' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',								'1' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',								'1' },
						{ '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1',								'1' },
						{ '1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1',								'1' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1',								'0' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0',								'0' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',								'1' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
						{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' } };
						
		System.out.println(noi.numIslands(grid));

	}
	
	 boolean [][] visited;
	
	public int numIslands(char[][] grid) {
		int count = 0;

		int rows = grid.length;
		int cols = grid[0].length;
		visited = new boolean[rows][cols];

		for (int r = 0; r < rows; r++) {

			for (int c = 0; c < cols; c++) {

				if (grid[r][c] == '0' || visited[r][c]) {
					continue;
				}

				count++;
				
				helper(grid, r, c);
			}
		}	

		return count;
	
	}
	
	private void helper(char[][] grid, int r, int c ) {
		
		if (r < 0 || c < 0 || r >= grid.length || c  >= grid[0].length) {
			return;
		}
		
	

		if (grid[r][c] == '0' || visited[r][c]) {
			return;
		}
		
		visited[r][c] = true;
		
		grid[r][c] = '0';		

		helper(grid, r - 1, c);
		helper(grid, r + 1, c);
		helper(grid, r, c - 1);
		helper(grid, r, c + 1);
		
	}
	
	public int numIslands2(char[][] grid) {
		 int count = 0;
	        
	        int rows = grid.length;
	        int cols = grid[0].length;
	        boolean [][] visited = new boolean[rows][cols];
	        
	        for(int i=0; i<rows; i++){            
	          
	            for(int j=0; j<cols; j++){
	                
	                if(grid[i][j]=='0' || visited[i][j]){
	                    continue;
	                }
	                
	                Queue<Integer[]> q = new LinkedList<Integer[]>();
	                
	                Integer arr[] = new Integer[2];
	                arr[0] = i;
	                arr[1] = j;
	                
	                q.add(arr);                
	                count++;                
	                
	                while(!q.isEmpty()){
	                    
	                    Integer[] p = q.peek();
	                    int r = p[0];
	                    int c = p[1];
	                    
	                    if(visited[r][c]) {
	                    	 q.poll();
	                    	continue;
	                    }
	                    
	                    grid[r][c]='0';
	                    visited[r][c] = true;
	                    
	                    // UP
	                    if(r>0 && grid[r-1][c]=='1'){                       
	                        
	                        Integer arr1[] = new Integer[2];
	                        arr1[0] = r-1;
	                        arr1[1] = c;                
	                        q.add(arr1);   
	                    }
	                    
	                    //right
	                    if(r+1<rows && grid[r+1][c]=='1'){
	                    
	                        Integer arr2[] = new Integer[2];
	                        arr2[0] = r+1;
	                        arr2[1] = c;                
	                        q.add(arr2);
	                    }
	                    
	                    //up
	                    if(c>0 && grid[r][c-1]=='1'){
	                        Integer arr3[] = new Integer[2];
	                        arr3[0] = r;
	                        arr3[1] = c-1;                
	                        q.add(arr3);
	                    }
	                    
	                    //down
	                    if(c+1<cols && grid[r][c+1]=='1'){
	                        Integer arr4[] = new Integer[2];
	                        arr4[0] = r;
	                        arr4[1] = c+1;                
	                        q.add(arr4);                        
	                    }
	                    
	                    q.poll();
	                }                
	            }
	        }
	        
	        
	        return count;
	}

}
