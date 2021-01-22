package com.algorithm.graph.bfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {
	
	public static final int MAX_LEN = 100001;
	
	public void main() throws IOException {
		
		// initialize
		int[] graph = new int[MAX_LEN];
		for (int i=0; i<graph.length; i++) {
			graph[i] = -1;
		}
		
		// get input
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		// put starting point in the Queue
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(start);
		graph[start] = 0;
		
		// run bfs
		int time = 0;
		while(!Q.isEmpty()) {
			
			int Qsize = Q.size();
			time++;
			
			for (int i=0; i<Qsize; i++) {
				
				int x = Q.poll();
				
				// end condition
				if (x == end) {
					System.out.println(time-1);
					return;
				}
				
				if (x-1>=0 && graph[x-1] == -1 ) { // checking in-bound, not visited
					graph[x-1] = time;
					Q.offer(x-1);
				}
				
				if (x+1 < MAX_LEN && graph[x+1] == -1) {
					graph[x+1] = time;
					Q.offer(x+1);
				}
				
				if (x*2 < MAX_LEN && graph[x*2] == -1) {
					graph[x*2] = time;
					Q.offer(x*2);
				}
			}
		}
		
		
		return;
	}
}
