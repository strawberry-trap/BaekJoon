package com.algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConsecutiveSumTwo {
	
	public static void main(String[] args) throws IOException {
		
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

		int[] dp = new int[n+1]; // consecutive sum from first ~ i-th number
		int[] dp2 = new int[n+1]; // consecutive sum from i-th ~ last number
		// if you want to get consecutive sum excluding k-th number, just add dp[k-1] + dp2[k+1].
		
		dp[1] = numbers[1];		
		for (int i=2; i<=n; i++) {
			dp[i] = numbers[i];
			dp[i] = Math.max(dp[i-1] + numbers[i], dp[i]);
		}
        
		dp2[n] = numbers[n];
		for (int j=n-1; j>=1; j--) {
			dp2[j] = numbers[j];
			dp2[j] = Math.max(dp2[j], dp2[j+1] + numbers[j]);
		}
		
		// for the case when you include all numbers (described in the problem)
		int answer = dp[1];
		for (int i=2; i<=n; i++) {
			answer = Math.max(dp[i], answer);
		}
		
		// for the case when you exclude single number, from 1 ~ last number
		for (int k=1; k<=n-1; k++) {
			answer = Math.max(answer, dp[k-1] + dp2[k+1]);
			//System.out.println("excluding "+k+"-th number : " + numbers[k] +", left sum : " + dp[k-1] +", right sum : "+ dp2[k+1]);
		}
		
		System.out.println(answer);
		
		bf.close();	
		return;
	}

}
