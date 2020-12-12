package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SpecialBinaryNumber {
	
	public void solution() throws IOException {
		
		// read input (range 1 to 90)
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		long[][] dp = new long[91][2];
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		// recurrence relation
		// array index means, dp[digit][rightmost_number]
		// dp[3][1] means 3-digit number having 1 as the rightmost digit. ex) 101
		for (int i=2; i<=90; i++) {
			dp[i][0] = dp[i-1][1] + dp[i-1][0];
			dp[i][1] = dp[i-1][0]; // since we should not have consecutive 1s, do not add dp[i-1][1] since it will produce numbers like ..01011
		}
		
        long answer = dp[n][0] + dp[n][1];
		System.out.println(answer);
		bf.close();
		return;
	}
}
