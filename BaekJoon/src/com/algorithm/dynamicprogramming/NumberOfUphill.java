package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfUphill {
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		
		// dp[N][K] means the number of 'N' length increasing numbers whose last digit number is 'K'
		int[][] dp = new int[n+1][10];
		
		// initialize first case
		for (int k=0; k<=9; k++) {
			dp[1][k] = 1;
		}
		
		int mod = 10007;
		// fill dp[][] array, i-length increasing number with last number j
		for (int i=2; i<=n; i++) {
			for (int j=0; j<=9; j++) {
				for (int m=0; m<=j; m++) {
					dp[i][j] += dp[i-1][m];
				}
				dp[i][j] %= mod;
			}
		}
		
		// calculate answer, n-length increasing number
		int answer = 0;
		for (int last=0; last<=9; last++) {
			answer += dp[n][last];
		}
		System.out.println(answer%mod);
		
		bf.close();	
		return;
	}

}
