package com.algorithm.graph.dfs;

import java.io.IOException;
import java.util.Scanner;

public class BipartiteGraph {
	
	static int[][] g = new int[20001][20001];
	static int[] visited = new int[20001];
	static String result = "YES";
	
	public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		// 't' is the number of test cases
		for (int test=0; test<t; test++) {
			
			// initialize visited[]
			for (int j=0; j<visited.length; j++) {
				visited[j] = 0;
			}
			
			int vertice = sc.nextInt();
			int edges = sc.nextInt();
			
			// fill graph represented as a 2D array
			for (int i=0; i<edges; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				g[x][y] = 1;
				g[y][x] = 1;
			}
			
			// run dfs
			dfs(1, -1);
			System.out.println(result);
			
			// reset result for next test
			result = "YES";
		}
		return;
	}
	
	private static void dfs(int vertex, int parentColor) {
		
		// if vertex is already visited,
		if (visited[vertex] != 0) {
			
			// check if the color is same as the color of the parent node, where we started dfs.
			if (parentColor == visited[vertex]) {
				result = "NO";
			}
			return;
		}
		
		// if vertex is not visited, mark it as visited,
		// and paint current vertex with color that is inverted from parent vertex
		visited[vertex] = parentColor*(-1);
		
		// run dfs on adjacent vertice
		for (int i=1; i<g.length; i++) {
			if (g[vertex][i] == 1) {
				dfs(i, parentColor*(-1));
			}
		}
	}
}
