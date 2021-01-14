package com.algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BreakingWallShortestPath {
	
	static int[][] maze;
	static boolean[][] visited;
	static int answer = 0;
	
	public void main() throws IOException {

		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");
		int row = Integer.parseInt(s[0]);
		int col = Integer.parseInt(s[1]);

		// fill the maze
		int[][] input = new int[row][col];
		boolean[][] v = new boolean[row][col];
		
		for (int i=0; i<row; i++) {
			String[] numbersAsString = bf.readLine().split(" ");
			int[] numbers = new int[numbersAsString.length];
			for (int j=0; j<numbersAsString.length; j++) {
				input[i][j] = Integer.parseInt(numbersAsString[j]);
				v[i][j] = false;
			}
		}
		maze = input;
		visited = v;
		
		// find shortest path without breaking a wall
		bfs(0, 0, 0);
		
		// try breaking a wall
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (maze[i][j] == 1) {
					
					// break a wall, and run bfs
					maze[i][j] = 0; 
					bfs(0, 0, 0);
					
					// after bfs, rebuild the wall for next bfs
					maze[i][j] = 1; 
					
					// reset the visited[][] array for next bfs
					for (int k=0; k<row; k++) {
						for (int l=0; l<col; l++) {
							visited[k][l] = false;
						}
					}
				}
			}
		}
		
		System.out.println(answer);
		return;
	}
	
	private static void bfs(int X, int Y, int path) {
		
		Queue<int[]> Q = new LinkedList<int[]>();
		Q.add(new int[] {X,Y});
		visited[X][Y] = true;
		
		while (!Q.isEmpty()) {
			
			path++;
			int QSize = Q.size();
			for (int i=0; i<QSize; i++) {
				
				// pop an (x, y) coordinate from the Queue
				int[] xy = Q.poll();
				int x = xy[0];
				int y = xy[1];
				
				// when we arrive at the destination
				if (x == maze.length-1 && y == maze[0].length -1) {
					if (answer == 0) answer = path; // for the first bfs
					else answer = Math.min(answer, path); // after that, only record shorter path
					return;
				}
				
				if (x+1 < maze.length && maze[x+1][y] == 0 && visited[x+1][y] == false) {
					Q.offer(new int[] {x+1, y});
					visited[x+1][y] = true;
				}
				if (x-1 >= 0 && maze[x-1][y] == 0 && visited[x-1][y] == false) {
					Q.offer(new int[] {x-1, y});
					visited[x-1][y] = true;
				}
				if (y+1 < maze[0].length && maze[x][y+1] == 0 && visited[x][y+1] == false) {
					Q.offer(new int[] {x, y+1});
					visited[x][y+1] = true;
				}
				if (y-1 >= 0 && maze[x][y-1] == 0 && visited[x][y-1] == false) {
					Q.offer(new int[] {x, y-1});
					visited[x][y-1] = true;
				}
			}
		}
		
		answer = -1;
		return;
	}
	

}
