package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// #1309
public class LionCage {
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		// dp[N][K] means 'N' length cages with last lion at 'K' cage. If K==0, there is no lion at the last cage.
		long[][] dp = new long[n+1][3];
		int mod = 9901;
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for (int i=2; i<=n; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%mod; // if there's no lion at the last cage, just add all the previous cases
			dp[i][1] = (dp[i-1][0] + dp[i-1][2])%mod; // put lion at the first cage
			dp[i][2] = (dp[i-1][0] + dp[i-1][1])%mod;
		}
		
		System.out.println((dp[n][0] + dp[n][1] +dp[n][2])%mod);
		bf.close();	
		return;
	}

}
