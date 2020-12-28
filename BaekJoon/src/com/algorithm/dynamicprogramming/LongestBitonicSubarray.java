package com.algorithm.dynamicprogramming;

public class LongestBitonicSubarray {
	
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
		
		// dp[N] means N-length longest subarray.
		int[] dp = new int[n+1];
		
		dp[1] = numbers[1];
		int max = dp[1];
		for (int i=2; i<=n; i++) {
			dp[i] = numbers[i];
			for (int j=1; j<i; j++) {
				if (numbers[j] < numbers[i]) {
					dp[i] = Math.max(dp[j] + numbers[i], dp[i]);
				}
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
		
		bf.close();	
		return;
	}

}
