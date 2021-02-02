package com.algorithm.bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GomokuGame {

	public static final int BOARD_LENGTH = 10;
	public static final int DIRECTIONS = 8;
	public static final int WINNING_STONES = 5;
	public static char[][] board = new char[BOARD_LENGTH][BOARD_LENGTH];

	public void main() throws IOException {

		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> stone = new ArrayList<int[]>();

		for (int i=0; i<BOARD_LENGTH; i++) {

			String row = bf.readLine();
			for (int j=0; j<row.length(); j++) {
				
				board[i][j] = row.charAt(j);

				// if there is a stone, save that coordinate
				if (board[i][j] == 'X') {
					stone.add(new int[] {i, j});
				}
			}
		}

		// 8 directions that pair like dx[i], dx[i]
		int[] dx = {-1,-1, 0, 1, 1, 1,  0, -1};
		int[] dy = {0,  1, 1, 1, 0,-1, -1, -1};
		
		// pick a stone
		for (int i=0; i<stone.size(); i++) {

			int[] starting = stone.get(i);

			// for each direction,
			for (int j=0; j<DIRECTIONS; j++) {
				
				int x = starting[0];
				int y = starting[1];
				
				// check if we could put 5 stones in a row. (loop runs 4 times)
				int cnt = 1;
				for (int k=0; k<WINNING_STONES-1; k++) {
					
					x += dx[j];
					y += dy[j];
					if (x>=0 && x<BOARD_LENGTH && y>=0 && y<BOARD_LENGTH) {
						
						if (board[x][y] == 'X') {
							cnt++;
						}
						else if (board[x][y] == 'O') // blocked, no need to search further
							break;
					}
				}
				
				if (cnt == 4) {
					System.out.println(1);
					return;
				}
			}
		}
		
		System.out.println(0);
		bf.close();	
		return;
	}
}
