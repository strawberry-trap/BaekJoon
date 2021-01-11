package com.algorithm.graph.dfs;

import java.io.IOException;
import java.util.Scanner;

public class NumberOfIslands {
	
	public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			// get input
			int width = sc.nextInt();
			int height = sc.nextInt();
			if (width == 0 && height == 0) break;
			
			// width == column, height == row
			int[][] world = new int[height][width];
			for (int i=0; i<height; i++) {
				for (int j=0; j<width; j++) {
					world[i][j] = sc.nextInt();
				}
			}
			
			int numOfIslands = 0;
			for (int i=0; i<height; i++) {
				for (int j=0; j<width; j++) {
					
					// when you found not-visited "clean" land,
					if (world[i][j] == 1) {
						
						// count it as a new land and mark all connect land as visited.
						numOfIslands++;
						dfs(world, i, j);
					}
				}
			}
			System.out.println(numOfIslands);
		}
		
		sc.close();
		return;
	}
	
	private static void dfs(int[][] world, int x, int y) {
		
		// if current land is already visited, or is out of map, or is not a land but water, stop searching.
		if (x<0 || x>=world.length || y<0 || y>=world[0].length || world[x][y] == -1 || world[x][y] == 0) return;
		
		// else, mark current land as visited, and search up, down, left, right, and diagonal directions.
		world[x][y] = -1;
		
		dfs(world, x+1, y); // down
		dfs(world, x-1, y); // up
		dfs(world, x, y+1); // right
		dfs(world, x, y-1); // left
		
		dfs(world, x+1, y-1); // down-left
		dfs(world, x+1, y+1); // down-right
		dfs(world, x-1, y-1); // up-left
		dfs(world, x-1, y+1); // up-right
	}

}
