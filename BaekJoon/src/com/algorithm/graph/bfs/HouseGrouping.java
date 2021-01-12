package com.algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class HouseGrouping {
	
	static final int MAX_LEN = 25;
	static int[][] house = new int[25][25];
	static ArrayList<Integer> group = new ArrayList<>();
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		// fill in the house array
		for (int i=0; i<n; i++) {
			
			// convert string array to an integer array
			String numbersAsString = bf.readLine();
			int[] numbers = new int[numbersAsString.length()];
			for (int j=0; j<numbersAsString.length(); j++) {
				house[i][j] = Integer.parseInt(numbersAsString.charAt(j)+""); 
			}
		}
		
		// run bfs
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (house[i][j] == 1) bfs(i,j);
			}
		}
		
		Collections.sort(group);
		System.out.println(group.size());
		for (int g : group) {
			System.out.println(g);
		}
		
		bf.close();
		return;
	}
	
	private static void bfs(int x, int y) {
		
		Queue<int[]> Q = new LinkedList<int[]>();
		
		// put starting point in the Queue, and mark it as visited
		Q.offer(new int[] {x, y});
		house[x][y] = -1; // mark as visited
		int numOfGroup = 1; // number of grouped house
		
		// level order traversal
		while (Q.size() > 0) {
			
			int QSize = Q.size();
			for (int i=0; i<QSize; i++) {
				
				// pop a coordinate from the Queue
				int[] xy = Q.poll();
				int X = xy[0];
				int Y = xy[1];
				
				// moving left, right, up, down,
				// check if the spot is in-bound and valid
				if (X+1 < MAX_LEN && house[X+1][Y] == 1) {
					house[X+1][Y] = -1; // visited
					numOfGroup++;
					Q.offer(new int[] {X+1, Y});
				}
				if (X-1 >= 0 && house[X-1][Y] == 1) {
					house[X-1][Y] = -1; 
					numOfGroup++;
					Q.offer(new int[] {X-1, Y});
				}
				if (Y+1 < MAX_LEN && house[X][Y+1] == 1) {
					house[X][Y+1] = -1; 
					numOfGroup++;
					Q.offer(new int[] {X, Y+1});
				}
				if (Y-1 >= 0 && house[X][Y-1] == 1) {
					house[X][Y-1] = -1; 
					numOfGroup++;
					Q.offer(new int[] {X, Y-1});
				}
				
			}
			
		}
		group.add(numOfGroup);
	}

}
