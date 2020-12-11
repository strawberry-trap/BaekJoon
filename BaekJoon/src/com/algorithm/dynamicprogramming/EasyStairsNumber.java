package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EasyStairsNumber {
	
	public void solution() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		long mod = 1000000000;
		
		// set array for dynamic-programming (input range is 1 to 100)
		long[][] dp = new long[101][11];
		for (int f=0; f<=9; f++) { // initialize
			dp[1][f] = 1;
		}
		
		// bottom-up dynamic programming approach
		// dp[n][m] = dp[n-1][m-1] + dp[n-1][m+1] // 'm' means last number
		
		// there are two exceptions.
		// if 'm' was 0, m-1 becomes -1. Hence ignore this case
		// also, if 'm' was 9, m+1 becomes 10 which should also be ignored.
		for (int i=2; i<=n; i++) {
			for (int j=0; j<=9; j++) {
				dp[i][j] = 0; // initialize now, because a trash value was in there
				if (j-1 >=0) dp[i][j] += dp[i-1][j-1];
				if (j+1 <=9) dp[i][j] += dp[i-1][j+1];
				dp[i][j] %= mod;
			}
		}
		long answer = 0;
		for (int k=1; k<=9; k++) answer += dp[n][k];
		answer %= mod;
		System.out.println(answer);
		bf.close();
		
		return;
	}

}
