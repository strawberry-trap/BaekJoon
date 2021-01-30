package com.algorithm.dynamicprogramming;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Interval implements Comparable<Interval> {
	
	int start;
	int end;
	
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Interval o) {
		return (end - o.end);
	}
}

public class OverlappingIntervals {
	
	private static final long MOD = 20070713;
	
	public void main() throws IOException {
		
		// get input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Interval[] list = new Interval[n+1];
		for (int i=1; i<=n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list[i] = new Interval(start, end);
		}
		
		// sort by end value, smaller one comes first
		Arrays.sort(list, 1, n);
		
		// find "largest interval ending that is under i-th interval's starting point
		int largest[] = new int[n+1];
		for (int i=1; i<=n; i++) {
			
			largest[i] = 0;
			int starting = list[i].start;
			
			for (int j=1; j<i; j++) {
				
				if (list[j].end < starting) {
					
					// considering interval 'i',
					// i-th       {    }
					// j-th  {   }
					// like above, 'j' is the rightmost interval that doesn't exceed 'i'.
					largest[i] = j;
				}
				else break;
			}
		}
		
		// dp[k] means total case of allocating devices, considering 1 ~ k intervals
		long[] dp = new long[n+1];
		
		// if largest[k] is 0, it means current interval is overlapping with all other intervals.
		// In this case, dp[largest[k]] becomes 0, and dp[largest[k]] is the only case,
		// o o o o ... o o o x
		// because if current interval is overlapping with all other intervals, all other intervals MUST have device on them.
		dp[0] = 1;
		
		// 2 means, 
		// 1. attach device at the first device
		// 2. do not attach device at the first device
		dp[1] = 2;
		
		for (int i=2; i<=n; i++) {
			
			// 1. put device at i-th index == dp[i-1]
			// 2. do not put device at i-th index == dp[largest[i]]
			
			// if you do not put device at i-th interval,
			// you must put device to all intervals overlapping with i-th interval.
			// we defined "largest[]" as the rightmost largest interval that doesn't overlap with i-th interval.
			
			// Hence, dp[i] = dp[i-1] + dp[largest[i]]
			dp[i] = (dp[i-1] + dp[largest[i]])%MOD;
		}
		
		System.out.println(dp[n]);
		
		return;
	}

}
