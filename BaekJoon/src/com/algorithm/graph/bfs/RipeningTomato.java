package com.algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RipeningTomato {

	static int[][] box = new int[1000][1000];
	static int ROW = 0;
	static int COL = 0;
	
	// start from -1, since we are starting from a ripen tomato
	static int DAYS = -1;
	
	public void main() throws IOException {

		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");
		int col = Integer.parseInt(s[0]);
		int row = Integer.parseInt(s[1]);
		ROW = row;
		COL = col;

		// fill the box, and check if all the tomatoes are already ripen
		boolean isAlreadyRipen = true;
		for (int i=0; i<row; i++) {
			String[] numbersAsString = bf.readLine().split(" ");
			int[] numbers = new int[numbersAsString.length];
			for (int j=0; j<numbersAsString.length; j++) {
				box[i][j] = Integer.parseInt(numbersAsString[j]);
				
				// mark if there is unripe tomato
				if (box[i][j] == 0) isAlreadyRipen = false;
			}
		}

		if (isAlreadyRipen) {
			System.out.println("0");
			return;
		}
		
		// run bfs
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (box[i][j] == 1) list.add(new int[] {i, j});
			}
		}
		bfs(list);
		
		// after bfs, check if there is still unripe tomato
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (box[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		
		System.out.println(DAYS);

		bf.close();	
		return;
	}
	
	private static void bfs(ArrayList<int[]> list) {
		
		Queue<int[]> Q = new LinkedList<int[]>();
		for (int[] ripenTomato : list) {
			Q.offer(ripenTomato);
		}
		
		// level order traversal
		while(!Q.isEmpty()) {
			
			int QSize = Q.size();
			for (int i=0; i<QSize; i++) {
				
				// pop a tomato and mark it as ripen
				int[] XY = Q.poll();
				int X = XY[0];
				int Y = XY[1];
				box[X][Y] = 1;
				
				// spread down, up, left, right
				if (X+1 < ROW && box[X+1][Y] == 0) {
					box[X+1][Y] = 1;
					Q.offer(new int[] {X+1, Y});
				}
				if (X-1 >=0 && box[X-1][Y] == 0) {
					box[X-1][Y] = 1;
					Q.offer(new int[] {X-1, Y});
				}
				if (Y-1 >=0 && box[X][Y-1] == 0) {
					box[X][Y-1] = 1;
					Q.offer(new int[] {X, Y-1});
				}
				if (Y+1 < COL && box[X][Y+1] == 0) {
					box[X][Y+1] = 1;
					Q.offer(new int[] {X, Y+1});
				}
			}
			DAYS++;
		}
		return;
	}

}
