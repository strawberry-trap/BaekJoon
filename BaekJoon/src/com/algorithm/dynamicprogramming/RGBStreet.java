package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGBStreet {

	public void main() throws IOException {

		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		// dp[N][K] means painting 'N' houses with the last house 'K' color. K=0,1,2 corresponding to r, g, b respectively.
		int[][] dp = new int[n+1][3];

		
		// initialize first dp[][] array with input handling.
		String[] input = bf.readLine().split(" ");
		for (int j=0; j<input.length; j++) {
			dp[1][j] = Integer.parseInt(input[j]);
		}

		for (int house=2; house<=n; house++) {
			
			// handling input. Convert string array to an integer array
			String[] numbersAsString = bf.readLine().split(" ");
			int[] rgb = new int[numbersAsString.length];
			for (int j=0; j<numbersAsString.length; j++) {
				rgb[j] = Integer.parseInt(numbersAsString[j]); 
			}
			
			for (int color=0; color<3; color++) {
				if (color==0) dp[house][color] = Math.min(dp[house-1][1], dp[house-1][2]) + rgb[color];
				if (color==1) dp[house][color] = Math.min(dp[house-1][0], dp[house-1][2]) + rgb[color];
				if (color==2) dp[house][color] = Math.min(dp[house-1][0], dp[house-1][1]) + rgb[color];
			}
		}
		
		int answer = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
		System.out.println(answer);

		bf.close();	
		return;
	}

}
