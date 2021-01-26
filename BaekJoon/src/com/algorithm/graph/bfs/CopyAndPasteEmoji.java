package com.algorithm.graph.bfs;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CopyAndPasteEmoji {
	
	public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		boolean[][] visited = new boolean[n*2 + 1][n*2 + 1];
		for (int i=0; i<visited.length; i++) {
			for (int j=0; j<visited[0].length; j++) {
				if (i == 0) { // not using index 0
					visited[i][j] = true;
					continue;
				}
				visited[i][j] = false;
			}
		}

		// initialize Queue, and push starting node
		// int[number of emoji shown on the screen][number of emoji saved in clipboard]
		Queue<int[]> Q = new LinkedList<int[]>();
		Q.offer(new int[] {1, 0}); // {screen, clipboard, time}
		visited[1][0] = true;
		
		// run bfs
		int time = 0;
		while(!Q.isEmpty()) {
			
			int Qsize = Q.size();
			for (int i=0; i<Qsize; i++) {
				
				int[] e = Q.poll();
				int screen = e[0];
				int clipboard = e[1];
				
				// end condition
				if (screen == n) {
					System.out.println(time);
					return;
				}
				
				// delete single emoji from the screen
				if (screen-1 >= 0 && visited[screen-1][clipboard] == false) {
					Q.offer(new int[] {screen-1, clipboard});
					visited[screen-1][clipboard] = true;
				}
				
				// save emoji shown on the screen to the clipboard
				if (screen <= n*2 && visited[screen][screen] == false) {
					Q.offer(new int[] {screen, screen});
					visited[screen][screen] = true;
				}
				
				// paste entire emoji from the clipboard into the screen
				if (screen + clipboard <= n*2 && visited[screen + clipboard][clipboard] == false) {
					Q.offer(new int[] {screen + clipboard, clipboard});
					visited[screen + clipboard][clipboard] = true;
				}
			}
			time++;
		}
		
		
		return;
	}

}
