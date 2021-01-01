package com.algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame {
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		// transplant input into a 2D character array
		char[][] board = new char[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				String row = bf.readLine();
				board[i][j] = row.charAt(j);
			}
		}
		
		// logic
		int answer = 1;
		for (int i=0; i<n; i++) {
			for (int j=0; j+1<n; j++) {
				
				// swap horizontally, and check entire candy board
				char temp = board[i][j];
				board[i][j] = board[i][j+1];
				board[i][j+1] = temp;
				
				// check maximum continuous candies
				answer = Math.max(answer, findMaxCandies(board));
				
				// reset the board to un-swapped status
				temp = board[i][j];
				board[i][j] = board[i][j+1];
				board[i][j+1] = temp;
				
				// same logic as above, but this time compare vertically
				// swap vertically, and check entire candy board
				temp = board[j][i];
				board[j][i] = board[j+1][i];
				board[j+1][i] = temp;
				
				// check maximum continuous candies
				answer = Math.max(answer, findMaxCandies(board));
				
				// reset the board to un-swapped status
				temp = board[i][j];
				board[i][j] = board[i][j+1];
				board[i][j+1] = temp;
			}
		}
		
		System.out.println(answer);
		bf.close();	
		return;
	}
	
	// switch x and y coordinate
	private int findMaxCandies(char[][] board) {
				
		int n =board.length;
		int answer = 1;
		for (int i=0; i<n; i++) {
			for (int j=1; j<n; j++) {
				
				// count horizontally continuous characters
				int horizontal = 1;
				if (board[i][j-1] == board[i][j]) {
					answer = Math.max(answer, ++horizontal);
				} else {
					horizontal = 1;
				}
				
				// count vertically continuous character
				int vertical = 1;
				if (board[j-1][i] == board[j][i]) {
					answer = Math.max(answer, ++vertical);
				} else {
					vertical = 1;
				}
			}
		}
		return answer;
	}
}
