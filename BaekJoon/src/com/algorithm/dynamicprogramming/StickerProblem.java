package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StickerProblem {
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int testCase = Integer.parseInt(s);
		
		
		// run 'testCase' times
		for (int t=0; t<testCase; t++) {
			
			// for each case, get row 'length'
			String firstLine = bf.readLine();
			int length = Integer.parseInt(firstLine);
			
			// for each case, get card values from testInput
			int[][] card = new int[2][length];
			
			String[] firstRow = bf.readLine().split(" ");
			String[] secondRow = bf.readLine().split(" ");
			
			for (int j=0; j<length; j++) 
				card[0][j] = Integer.parseInt(firstRow[j]); 
			
			for (int j=0; j<length; j++) 
				card[1][j] = Integer.parseInt(secondRow[j]); 
			
			// dynamic programming
			// dp[N][K] means 'N' length sticker with 'K' row index. K==0 means not selecting card
			int[][] dp = new int[length+1][3];
			dp[1][0] = 0;
			dp[1][1] = card[0][0];
			dp[1][2] = card[1][0];
			
			for (int x=2; x<=length; x++) {
				
				// dp[][] valid index starts from 1, and card[][] valid index starts from 0.
				// 1. take off no sticker
				dp[x][0] = Math.max(dp[x-1][1], dp[x-1][2]); // since dp[x-1][0] must be smaller than dp[x-1][1] or dp[x-1][2], no need to compare it
				dp[x][1] = Math.max(dp[x-1][0], dp[x-1][2]) + card[0][x-1]; // current card + previous dp[][] value
				dp[x][2] = Math.max(dp[x-1][0], dp[x-1][1]) + card[1][x-1];
							
			}
			System.out.println(Math.max(dp[length][1], dp[length][2]));	// dp[x-1][0] is always smaller than dp[x-1][1] or dp[x-1][2]
		}
		
		bf.close();	
		return;
	}

}
