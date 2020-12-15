package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestIncreasingSubarray {

	public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] numbers = new int[n+1];
		for (int j=1; j<=n; j++) { // numbers valid index starts from 1 to 1000
			int num = sc.nextInt();
			numbers[j] = num;
		}
		
		// input range 1 ~ 1000
		long[] dp = new long[n+1];
		long max = 1;
		for (int i=1; i<=n; i++) {
			dp[i] = 1;
			for (int j=1; j<i; j++) {
				if (numbers[j] < numbers[i] && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);

		return;
	}
	
	
}
