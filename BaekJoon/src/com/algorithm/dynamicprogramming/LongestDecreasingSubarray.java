package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestDecreasingSubarray {
	
	public void main() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		// convert string array to an integer array
		String[] numbersAsString = bf.readLine().split(" ");
		int[] numbers = new int[numbersAsString.length+1];
		for (int j=1; j<=numbersAsString.length; j++) {
			numbers[j] = Integer.parseInt(numbersAsString[j-1]); 
		}
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		int max = 1;
		
		for (int i=2; i<=n; i++) {
			dp[i] = 1;
			for (int j=1; j<i; j++) {
				if (numbers[i] < numbers[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
		bf.close();	
		return;
	}

}
