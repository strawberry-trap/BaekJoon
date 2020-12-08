package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #11726
public class TwoByTwoTiling {
	
	// bottom-up dynamic programming approach
	public void solution() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int row = Integer.parseInt(s);
		if (row < 3) {
			System.out.println(row); // in these cases, row is the answer itself
			return;
		}
		
		// using index from 1 to 'row'
		int[] dp = new int[row+1]; 
		
		// initialize dp array
		dp[1] = 1;
		dp[2] = 2;
		for (int i=3; i<=row; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 10007; // prevent overflow (required in the description of this problem)
		}
		System.out.println(dp[row]);
		bf.close();
		return;
	}

}
