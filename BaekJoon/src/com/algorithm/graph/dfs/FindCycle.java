package com.algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FindCycle {

	static char[][] g;
	static boolean[][] visited;
	static int[] starting;
	static boolean result = false;
	
	public void main() throws IOException {

		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		int row = Integer.parseInt(s[0]);
		int col = Integer.parseInt(s[1]);
		
		boolean[][] v = new boolean[row][col];
		visited = v;
		
		// fill in the graph
		char[][] graph = new char[row][col];
		g = graph;
		for (int i=0; i<row; i++) {
			
			// convert string array to an integer array
			String letterAsString = bf.readLine();
			for (int j=0; j<letterAsString.length(); j++) {
				graph[i][j] = letterAsString.charAt(j);
				
				// initialize visited[] array
				visited[i][j] = false;
			}
		}
		
		// for all coordinates,
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				
				// if it is not visited, run dfs
				if (!visited[i][j]) {
					starting = new int[] {i, j};
					dfs(i, j, g[i][j], 1);
					
					// after dfs, if the result is true, print answer and exit system
					if (result == true) {
						System.out.println("YES");
						return;
					}
					// reset visited[][] array for next dfs
					for (int k=0; k<row; k++) {
						for (int l=0; l<col; l++) {
							visited[k][l] = false;
						}
					}
				}
			}
		}

		System.out.println("NO");
		bf.close();
		return;
	}
	
	private static void dfs(int x, int y, char letter, int path) {
		
		visited[x][y] = true;
		
		// spread up, down, left, right
		if (x+1 < g.length && g[x+1][y] == letter) {
			
			// check end condition, 1) trying to travel a visited spot 2) path is same or larger than four 3) the spot we are heading is starting point
			if (visited[x+1][y] == true) {
				if (path >= 4 && x+1 == starting[0] && y == starting[1]) {
					result = true;
				}
			}
			else
				dfs(x+1, y, letter, path+1);
		}
		if (x-1 >= 0 && g[x-1][y] == letter) {
			if (visited[x-1][y] == true) {
				if (path >= 4 && x-1 == starting[0] && y == starting[1]) {
					result = true;
				}
			}
			else
				dfs(x-1, y, letter, path+1);
		}
		if (y+1 < g[0].length && g[x][y+1] == letter) {
			if (visited[x][y+1] == true) {
				if (path >= 4 && x == starting[0] && y+1 == starting[1]) {
					result = true;
				}
			}
			else
				dfs(x, y+1, letter, path+1);
		}
		if (y-1 >= 0 && g[x][y-1] == letter) {
			if (visited[x][y-1] == true) {
				if (path >= 4 && x == starting[0] && y-1 == starting[1]) {
					result = true;
				}
			}
			else
				dfs(x, y-1, letter, path+1);
		}
		
		return;
	}
}
