package com.algorithm.graph.dfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSandBFS {
	
	// not using index 0
	static int[][] g = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	
	public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int vertice = sc.nextInt();
		int edges = sc.nextInt();
		int startingVertex = sc.nextInt();
		
		// filling in graph
		for (int i=0; i<edges; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// Bi-directional edge
			g[x][y] = 1;
			g[y][x] = 1;
		}
		
		// initialize visited[] array for DFS
		for (int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		dfs(startingVertex);
		System.out.println();
		
		// reset visited[] array for BFS
		for (int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		bfs(startingVertex);
		
		return;
	}
	
	public static void dfs(int vertex) {
		
		// if it is already visited, do nothing
		if (visited[vertex] == true) return;
		
		// if it is not visited, mark it as visited
		visited[vertex] = true;
		System.out.print(vertex);
		System.out.print(' ');
		
		// and run dfs at adjacent vertice
		for (int i=1; i<=1000; i++) {
			if (g[vertex][i] == 1) {
				dfs(i);
			}
		}
		
	}
	
	public static void bfs(int vertex) {
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(vertex);
		
		while (Q.size() > 0) {
			for (int i=0; i<Q.size(); i++) {
				int cur = Q.poll();
				
				if (visited[cur] == true) {
					continue;
				}
				else {
					visited[cur] = true;
					System.out.print(cur);
					System.out.print(' ');
					
					// put all adjacent vertice in the Queue
					for (int j=1; j<=1000; j++) {
						if (g[cur][j] == 1 && visited[j] == false) {
							Q.offer(j);							
						}
					}
				}
			}
			
			
		}
		
	}

}
