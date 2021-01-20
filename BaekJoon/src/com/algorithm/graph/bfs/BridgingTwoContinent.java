package com.algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BridgingTwoContinent {
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		// convert string array to an integer array
		int[][] world = new int[n][n];
		for (int i=0; i<n; i++) {
			String[] numbersAsString = bf.readLine().split(" ");
			int[] numbers = new int[numbersAsString.length];
			for (int j=0; j<numbersAsString.length; j++) {
				world[i][j] = Integer.parseInt(numbersAsString[j]); 
			}
		}

		/*
		 * 1. put all the "land" coordinates in the Queue.
		 * 2. run bfs using the Queue
		 * 3. while running bfs, if any of the spreading meets another spreading, that is the shortest path
		 * */
		Queue<int[]> Q = new LinkedList<int[]>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (world[i][j] == 1) {
					Q.offer(new int[] {i,j});
					world[i][j] = -1; // mark as visited
				}
			}
		}
		
		int length = 0;
		int currentVisitingMarking = 0;
		
		while(!Q.isEmpty()) {
			
			length++;
			currentVisitingMarking--;
			
			int QSize = Q.size();
			for (int i=0; i<QSize; i++) {
				
				// pop a node
				int[] spot = Q.poll();
				int x = spot[0];
				int y = spot[1];
				
				if (x+1<n) {
					
					// current spot is a water, and we haven't visited here before
					if (world[x+1][y] == 0) {
						world[x+1][y] = currentVisitingMarking; // mark as visited
						Q.offer(new int[] {x+1, y}); // push to Queue
					}
					// while current level order traversal, we will mark "visited" as "currentVisitingMarking".
					// "currentVisitingMarking" is keep decreasing(-1, -2, -3, ..), so we can distinguish if we are at currently exploring land,
					// or a land that is visited before.
					else if (world[x+1][y]<0 && world[x+1][y] != currentVisitingMarking) {
						System.out.println(length);
						return;
					}
				}
				
				if (x-1>=0) {
					if (world[x-1][y] == 0) {
						world[x-1][y] = currentVisitingMarking;
						Q.offer(new int[] {x-1, y});
					}
					else if (world[x-1][y]<0 && world[x-1][y] != currentVisitingMarking) {
						System.out.println(length);
						return;
					}
				}
				
				if (y+1<n) {
					if (world[x][y+1] == 0) {
						world[x][y+1] = currentVisitingMarking;
						Q.offer(new int[] {x, y+1});
					}
					else if (world[x][y+1]<0 && world[x][y+1] != currentVisitingMarking) {
						System.out.println(length);
						return;
					}
				}
				
				if (y-1>=0) {
					if (world[x][y-1] == 0) {
						world[x][y-1] = currentVisitingMarking;
						Q.offer(new int[] {x, y-1});
					}
					else if (world[x][y-1]<0 && world[x][y-1] != currentVisitingMarking) {
						System.out.println(length);
						return;
					}
				}
			}
		}
		
		bf.close();	
		return;
	}

}
