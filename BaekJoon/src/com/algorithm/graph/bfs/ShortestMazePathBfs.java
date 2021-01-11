package com.algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestMazePathBfs {
	
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
		
		// run bfs
		int[] coordinate = new int[] {0, 0};
		bfs(coordinate, row, col);
		
		// print answer
		System.out.println(answer);
		bf.close();
		return;
	}
	
	// level order traversal
	private static void bfs(int[] xy, int row, int col) {
		
		Queue<int[]> Q = new LinkedList<int[]>();
		Q.offer(xy);
		maze[0][0] = 3; // visited
		
		// length of path
		int path = 0; 
		
		while (Q.size()>0) {
			
			// for each level order traversal, increase path length by 1
			path++;
			
			int QSize = Q.size();
			for (int i=0; i<QSize; i++) {
				
				// pop an (x, y) coordinate from the Queue
				int[] coordinate = Q.poll();
				int x = coordinate[0];
				int y = coordinate[1];
//				 System.out.println("pop (" + x +","+y+")");
								
				// if we are at the destination, break all procedure
				// because in level order traversal, reaching destination means you just traveled the shortest path
				if (x == row-1 && y == col-1) {
					answer = path; 
					return;
				}
				
				// else if we are still traveling, push all adjacent vertice into the Queue,
				// only when the vertice are not visited yet && are in-bound.
				// you must mark it as visited WHEN YOU PUSH THE VERTEX INTO THE QUEUE. Else, you will push redundant vertice.
				if ( x-1 >= 0 && maze[x-1][y] == 1 ) {
					Q.offer(new int[] {x-1, y});
					maze[x-1][y] = 3; // mark it as visited
				}
				if ( x+1 < row && maze[x+1][y] == 1 ) {
					Q.offer(new int[] {x+1, y});
					maze[x+1][y] = 3;
				}
				if ( y-1 >= 0 && maze[x][y-1] == 1 ) {
					Q.offer(new int[] {x, y-1});
					maze[x][y-1] = 3;
				}
				if ( y+1 < col && maze[x][y+1] == 1 ) {
					Q.offer(new int[] {x, y+1});
					maze[x][y+1] = 3;
				}
			}
			
//			for (int i=0; i<row; i++) {
//				for (int j=0; j<col; j++) {
//					System.out.print(maze[i][j]);
//				}
//				System.out.println();
//				if (i==row-1)
//					System.out.println("shortest length : " + path);
//			}
//			
//			System.out.print("Queue : ");
//			for (int[] c : Q) {
//				System.out.print(" ("+c[0] + "," + c[1] + ") ");
//			}
//			System.out.println();
//			System.out.println();

		}
		
	}
	

}
