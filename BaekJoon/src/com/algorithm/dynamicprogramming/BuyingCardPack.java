package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #11052
public class BuyingCardPack {
	/*
	 * if we are to buy 5 cards, the cases are:
	 * 
	 * 5
	 * 4 + 1
	 * 3 + 2
	 * 2 + 3
	 * 1 + 4
	 * 
	 * one of above must contain the maximum cost to buy 5 cards.
	 * 
	 * for instacne,
	 * dp[1] = card[1] // basic case
	 * dp[2] = dp[1] + card[1] vs. card[2]
	 * dp[3] = dp[2] + card[1] vs. dp[1] + card[2] vs. card[3]
	 * ...
	 * 
	 * 
	 * */
	public void solution() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
		// convert string array to an integer array
		String[] numbersAsString = bf.readLine().split(" ");
		int[] card = new int[numbersAsString.length + 1];
		for (int j=1; j<numbersAsString.length + 1; j++) {
			card[j] = Integer.parseInt(numbersAsString[j-1]); 
		}
		card[0] = 0;
		
		int[] dp = new int[n+1]; // we will use index as card number
		dp[0] = 0;
		dp[1] = card[1];
		for (int i=2; i<=n; i++ ) {
			for (int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + card[j]);
			}
		}
		
		System.out.println(dp[n]);

		
		// afterwork
		bf.close();
		
		return;
	}
}
