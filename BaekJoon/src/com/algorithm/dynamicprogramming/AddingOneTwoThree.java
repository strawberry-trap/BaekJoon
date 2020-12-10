package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AddingOneTwoThree {
	
	public void solution() throws IOException {
		
		long mod = 1000000009;
		long[][] dp = new long[100001][4]; // using 1, 2, 3
		dp[1][1] = dp[2][2] = dp[3][3] = 1;
		
		for (int i=1; i< dp.length; i++) {
			if (i>1) dp[i][1] = (dp[i-1][2] +dp[i-1][3]) % mod;
			if (i>2) dp[i][2] = (dp[i-2][1] +dp[i-2][3]) % mod;
			if (i>3) dp[i][3] = (dp[i-3][1] +dp[i-3][2]) % mod;
		}
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		
		for (int k=0; k<n; k++) {
			String in = bf.readLine();
			int target = Integer.parseInt(in);
			System.out.println((dp[target][1] + dp[target][2] + dp[target][3])%mod);
		}
		
		return;
	}

}
