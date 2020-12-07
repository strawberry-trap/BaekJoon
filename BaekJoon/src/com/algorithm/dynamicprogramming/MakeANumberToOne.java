package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #1463
public class MakeANumberToOne {
	public void solution() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(bf.readLine());
		
		int[] dp = new int[number+1]; // use index as index-number's answer
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		if (number <4) {
			System.out.println(dp[number]);
			bf.close();
			return;
		}
		
		// dynamic programming, bottom-up approach
		// complexity is O(N)
		for (int i=4; i<=number; i++) {
			if (i%3 == 0) 
				dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
			else if (i%2 == 0) 
				dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
			else { dp[i] = dp[i-1] + 1; }
		}
		System.out.println(dp[number]);
		
		// afterwork
		bf.close();
		
		return;
	}
}
