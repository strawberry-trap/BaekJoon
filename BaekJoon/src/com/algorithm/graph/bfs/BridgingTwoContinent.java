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

		// mark each land with different numbers
		int uniqueNumber = -1;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				
				// while traversing through the world[][], when meeting a land, spread within that land using bfs, and mark them with a unique number
				if (world[i][j] == 1) {
					
					// BFS
					Queue<int[]> Q = new LinkedList<int[]>();
					Q.offer(new int[] {i, j});
					world[i][j] = uniqueNumber;
					
					while(!Q.isEmpty()) {
						int Qsize = Q.size();
						for (int k=0; k<Qsize; k++) {
							
							int[] xy = Q.poll();
							int x = xy[0];
							int y = xy[1];
							
							if (x+1<n && world[x+1][y] == 1) {
								world[x+1][y] = uniqueNumber;
								Q.offer(new int[] {x+1, y});
							}
							
							if (x-1>=0 && world[x-1][y] == 1) {
								world[x-1][y] = uniqueNumber;
								Q.offer(new int[] {x-1, y});
							}
							
							if (y+1<n && world[x][y+1] == 1) {
								world[x][y+1] = uniqueNumber;
								Q.offer(new int[] {x, y+1});
							}
							
							if (y-1>=0 && world[x][y-1] == 1) {
								world[x][y-1] = uniqueNumber;
								Q.offer(new int[] {x, y-1});
							}
						}
					}
					uniqueNumber--; // update for next land
				}
			}
		}
		
		// now, each land are marked with unique numbers like -1, -2, ...
		// hence we could run another BFS on the entire land, and check if a land has spread over another land.
		Queue<int[]> Q = new LinkedList<int[]>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				
				if (world[i][j] < 0) {
					Q.offer(new int[] {i, j, world[i][j]});
				}
			}
		}
		
		int bridge = 0; // answer
		while(!Q.isEmpty()) {
			
			int Qsize = Q.size();
			bridge++; 
			
			for (int i=0; i<Qsize; i++) {
				
				int[] cord = Q.poll();
				int x = cord[0];
				int y = cord[1];
				int landNumber = cord[2];
				world[x][y] *= -1; // mark as visited
				
				if (x+1<n) {
					
					// if we meet another spreading land
					if (world[x+1][y] > 0 && world[x+1][y] != landNumber*(-1)) {
						
						// spreading length will be the same between all lands, so just multiply by two and remove the meeting spot which is redundant
						System.out.println(bridge*2 - 1);
						return;
					}
					
					// else
					Q.offer(new int[] {x+1, y, landNumber});
					world[x+1][y] = landNumber*(-1); // mark as visited
				}
				
				if (x-1>=0) {
					if (world[x-1][y] > 0 && world[x-1][y] != landNumber*(-1)) {
						System.out.println(bridge*2 - 1);
						return;
					}
					Q.offer(new int[] {x-1, y, landNumber});
					world[x-1][y] = landNumber*(-1);
				}
				
				if (y+1<n) {
					
					if (world[x][y+1] > 0 && world[x][y+1] != landNumber*(-1)) {
						System.out.println(bridge*2 - 1);
						return;
					}
					Q.offer(new int[] {x, y+1, landNumber});
					world[x][y+1] = landNumber*(-1);
				}
				
				if (y-1>=0) {
					
					if (world[x][y-1] > 0 && world[x][y-1] != landNumber*(-1)) {
						System.out.println(bridge*2 - 1);
						return;
					}
						Q.offer(new int[] {x, y-1, landNumber});
						world[x][y-1] = landNumber*(-1);
				}
			}
		}
		
		bf.close();	
		return;
	}
}
