package com.algorithm.dynamicprogramming;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConsecutiveDice {
	
	private static final int SIDE = 6;
	
	public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();

		for (int t=0; t<testCases; t++) {
			
			int dice = sc.nextInt();
			
			// PriorityQueue( initial-capacity, comparator )
			// compare by the first index. For instance, {0,2} comes first than {4,1}
			PriorityQueue<int[]> Q = new PriorityQueue(dice, (a, b) -> ((int[])a)[0] - ((int[])b)[0]);
			for (int i=0; i<dice; i++) { // for each dice,
				for (int side=0; side<SIDE; side++) { // we have six sides
					int number = sc.nextInt();
					Q.offer(new int[] {number, i});
				}
			}
			
//			for (int[] e : Q) {
//				System.out.println("("+e[0]+","+e[1]+")");
//			}
//			
			
			// construct a dice-numbering array
			int[] diceNumbers = new int[dice*SIDE];
			for (int i=0; i<diceNumbers.length; i++) {
				int[] element = Q.poll();
				diceNumbers[i] = element[1];
			}

			
			// now we have an array of dice numberings like {1, 0, 1, 1, 3, 2, 0},
			// and left thing to do is to find a longest increasing subarray.
			int[] dp = new int[dice*SIDE];
			dp[0] = 1; // length of longest subarray
			
			int max = 0;
			for (int i=0; i<dice*SIDE; i++) {
				for (int j=0; j<i; j++) {
					if (diceNumbers[i] > diceNumbers[j] && dp[j]+1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				max =Math.max(max, dp[i]);
			}
			
			System.out.print("Case #"+(t+1)+": ");
			System.out.println(max);
			
		}
		
		
		return;
	}

}
