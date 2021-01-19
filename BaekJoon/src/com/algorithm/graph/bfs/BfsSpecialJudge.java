package com.algorithm.graph.bfs;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsSpecialJudge {
	
	public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// fill graph
		int[][] g = new int[n+1][n+1];
		boolean[] visited = new boolean[n+1];
		
		for (int i=0; i<n-1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			g[x][y] = 1;
			g[y][x] = 1;
		}
		
		// visit order to be tested
		int[] order = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			order[i] = sc.nextInt();
		}
		
		// run bfs
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(1); // starting node
		visited[1] = true;
		
		int check = 2;
		
		while(!Q.isEmpty()) {
			int QSize = Q.size();
			for (int i=0; i<QSize; i++) {
				
				// pop a node, and visit adjacent nodes if they are not visited yet
				int node = Q.poll();
				for (int j=1; j<=n; j++) {
					if (g[node][j] == 1 && visited[j] == false) {
						Q.offer(j);
						visited[j] = true;
					}
				}
			}
			
			// check if currently added nodes are in right order
			for (int k=0; k<Q.size(); k++) {
				if (Q.contains(order[check])) {
					check++; // check is order index
				}
				else {
					System.out.println(0);
					return;
				}
			}
		}
		
		System.out.println(1);
		sc.close();
		return;
	}

}
