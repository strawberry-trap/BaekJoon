package com.algorithm.graph.bfs;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CopyAndPasteEmoji {
	
	public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		boolean[][] visited = new boolean[n+1][n+1];
		for (int i=0; i<visited.length; i++) {
			for (int j=0; j<visited[0].length; j++) {
				visited[i][j] = false;
			}
		}

		// initialize Queue, and push starting node
		// int[number of emoji shown on the screen][number of emoji saved in clipboard]
		Queue<int[]> Q = new LinkedList<int[]>();
		Q.offer(new int[] {1, 0, 0});
		visited[1][0] = true;
		visited[0][0] = true; // not using index 0
		
		// run bfs
		while(!Q.isEmpty()) {
						
			int Qsize = Q.size();
			for (int i=0; i<Qsize; i++) {
				
				int[] e = Q.poll();
				int screen = e[0];
				int clipboard = e[1];
				int time = e[2];
				
				// end condition
				if (screen == n) {
					System.out.println(time);
					return;
				}
				
				// delete single emoji from the screen
				if (screen-1 >=0 && visited[screen-1][clipboard] == false) {
					Q.offer(new int[] {screen-1, clipboard, time+1});
					visited[screen-1][clipboard] = true;
				}
				
				// add emoji shown on the screen to the clipboard
				if (clipboard+screen <= n && visited[screen][clipboard+screen] == false) {
					Q.offer(new int[] {screen, clipboard+screen, time+1});
					visited[screen][clipboard+screen] = true;
				}
				
				// paste entire emoji from the clipboard into the screen
				if (screen+clipboard <= n && visited[screen + clipboard][clipboard] == false) {
					Q.offer(new int[] {screen+clipboard, clipboard, time+1});
					visited[screen+clipboard][clipboard] = true;
				}
			}
		}
		
		
		return;
	}

}
