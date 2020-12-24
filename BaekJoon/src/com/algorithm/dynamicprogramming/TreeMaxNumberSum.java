package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// #1932
public class TreeMaxNumberSum {
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		int[][] tree = new int[n][n];
		for (int i=0; i<n; i++) {
			// parse input and save data into the TREE
			String[] numbersAsString = bf.readLine().split(" ");
			for (int j=0; j<=i; j++) {
				tree[i][j] = Integer.parseInt(numbersAsString[j]); 
			}
		}
		
		int[][] dp = new int[n][n];
		dp[0][0] = tree[0][0];
		for (int a=1; a<n; a++) {
			for (int b=0; b<=a; b++) {
				if (b==0) {
					dp[a][b] = dp[a-1][b] + tree[a][b];
				}
				else if (b==a) {
					dp[a][b] = dp[a-1][b-1] + tree[a][b];
				}
				else {
					dp[a][b] = Math.max(dp[a-1][b], dp[a-1][b-1]) + tree[a][b];
				}
			}
		}
		
		// find answer
		int max = 0;
		for (int x=0; x<n; x++) {
			max = Math.max(max, dp[n-1][x]);
		}
		
		System.out.println(max);

		bf.close();	
		return;
	}

}
