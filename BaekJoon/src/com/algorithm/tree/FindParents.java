package com.algorithm.tree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindParents {
	
	public void main() throws IOException {

		// get input
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		int[][] g = new int[nodes+1][nodes+1];
		int parent[] = new int[nodes+1];
		for (int i=0; i<nodes-1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			g[x][y] = 1;
			g[y][x] = 1;
		}
		
		// initialize
		for (int i=0; i<parent.length; i++) {
			parent[i] = 0;
		}
		
		// run bfs, starting from node #1
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(1);
		parent[1] = -1;
		while (!Q.isEmpty()) {
			int QSize = Q.size();
			for (int i=0; i<QSize; i++) {
				int node = Q.poll();
				
				// visit adjacent(child) node
				for (int j=1; j<g.length; j++) {
					if (g[node][j] == 1 && parent[j] == 0) {
						parent[j] = node;
						Q.offer(j);
					}
				}
			}
		}
		
		for (int i=2; i<parent.length; i++) {
			System.out.println(parent[i]);
		}
		
		return;
	}
}
