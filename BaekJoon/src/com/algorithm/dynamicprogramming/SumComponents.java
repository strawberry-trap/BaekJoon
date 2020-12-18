package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumComponents {
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		// convert string array to an integer array
		String[] numbersAsString = bf.readLine().split(" ");
		int[] numbers = new int[numbersAsString.length];
		for (int j=0; j<numbersAsString.length; j++) {
			numbers[j] = Integer.parseInt(numbersAsString[j]); 
		}
		long mod = 1000000000;
		int K = numbers[1];
		int N = numbers[0];
		
		// dp[K][N] means adding up 'K' numbers makes 'N'
		// dp[K][N] = dp[K-1][N-L], L means last number
		// 1 + 2 + ... 7 + L = N (total K numbers)
		// then, 1 + 2 + ... + 7 = N - L (total K-1 numbers)
		long[][] dp = new long[K+1][N+1];
		dp[0][0] = 1;
		
		for (int i=1; i<=K; i++) {
			for (int j=0; j<=N; j++) {
				for (int l=0; l<=j; l++) {
					dp[i][j] += dp[i-1][j-l];
					dp[i][j] %= mod;
				}
			}
		}
		
		System.out.println(dp[K][N]);
		
		bf.close();	
		return;
	}

}
