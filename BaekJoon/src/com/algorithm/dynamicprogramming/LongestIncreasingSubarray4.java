package com.algorithm.dynamicprogramming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LongestIncreasingSubarray4 {

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
		ArrayList<Integer> finalAnswer = new ArrayList<>();
		for (int i=1; i<=n; i++) {
			ArrayList<Integer> answer = new ArrayList<Integer>();
			answer.add(numbers[i]);
			dp[i] = 1;
			for (int j=1; j<i; j++) {
				if (numbers[j] < numbers[i] && dp[i] < dp[j]+1) {
					answer.add(numbers[j]);
					dp[i] = dp[j] + 1;
				}
				if (max < dp[i]) {
					max = dp[i];
					finalAnswer = answer;
				}
			}
		}
		System.out.println(max);
		Collections.sort(finalAnswer);
		for (int num : finalAnswer) {
			System.out.print(num + " ");
		}
		
		
//		// input range 1 ~ 1000
//		long[] dp = new long[n+1];
//		long[] dpLeft = new long[n+1]; // second largest number's index
//		
//		long max = 1;
//		int maxIdx = 1;
//		for (int i=1; i<=n; i++) {
//			dp[i] = 1;
//			dpLeft[i] = 0;
//			for (int j=1; j<i; j++) {
//				if (numbers[j] < numbers[i] && dp[i] < dp[j]+1) {
//					dp[i] = dp[j] + 1;
//					dpLeft[i] = j;
//				}
//				if (max < dp[i]) {
//					max = dp[i];
//					maxIdx = i;
//				}
//			}
//		}
//		
//		System.out.print(numbers[maxIdx]);
//		while(dpLeft[maxIdx]!=0) {
//			System.out.print(" " + numbers[(int)dpLeft[maxIdx]]);
//			maxIdx = (int)dpLeft[maxIdx];
//		}
		
		return;
	}
}
