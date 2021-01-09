package com.algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ShortestMazePath {
	
	static int[][] maze = new int[100][100];
	static int answer = 0;
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = bf.readLine().split(" ");
		int row = Integer.parseInt(s[0]);
		int col = Integer.parseInt(s[1]);
		
		// fill in the maze
		for (int i=0; i<row; i++) {
			
			// convert string array to an integer array
			String numbersAsString = bf.readLine();
			int[] numbers = new int[numbersAsString.length()];
			for (int j=0; j<numbersAsString.length(); j++) {
				maze[i][j] = Integer.parseInt(numbersAsString.charAt(j)+""); 
			}
		}
		
		dfs(1, 0, 0, row, col);
		
		System.out.println(answer);
		
		bf.close();
		return;
	}
	
	private static void dfs(int depth, int x, int y, int row, int col) {
		
		// if current spot is the destination,
		if (x == row-1 && y == col-1) {
			
			// if it is the first visit, then just update answer
			if (maze[row-1][col-1] == 1) {
				answer = depth;
				maze[x][y] = -1; // mark it as visited
			}
			// if we already recored a path length, compare and record shorter path
			else if (maze[row-1][col-1] == -1) {
				answer = Math.min(answer, depth);
			}
			return;
		}
		
		// else, check if current spot is in-bound and not visited yet
		if (x<0 || x>=row || y<0 || y>=col || maze[x][y] == -1 || maze[x][y] == 0) {
			return;
		}
		
		// System.out.println("(" + x + ", " + y + ") and depth is "+depth);
		
		// if we are not at the destination(still traveling),
		// mark current spot as visited by inverting 1 to -1
		maze[x][y] = -1;

		// and travel up, down, left, right
		dfs(depth+1, x, y+1, row, col);
		dfs(depth+1, x+1, y, row, col);
		dfs(depth+1, x, y-1, row, col);
		dfs(depth+1, x-1, y, row, col);
		
		// reset the maze for other dfs
		
		return;
	}
}
