package com.algorithm.bruteforce;

import java.io.IOException;
import java.util.Scanner;

public class NMProgression {
	
	static int[] result = new int[10];
	static boolean[] used = new boolean[10];
	
	public void main() throws IOException {
		
		// get input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// initialize
		for (int i=0; i<used.length; i++) {
			used[i] = false;
		}
		
		recursion(0, N, M);
		
		sc.close();
		return;
	}
	
	private static void recursion(int idx, int N, int M) {
		
		// end condition
		if (idx == M) {
			// print answer
			for (int i=0; i<M; i++) {
				System.out.print(result[i]);
				if (i != M-1) System.out.print(' ');
			}
			System.out.println();
			return;
		}
		
		// 'i' is 1 ~ N natural number. In result[idx], we will put 'i' if the number is not used. 
		for (int i=1; i<=N; i++) {
			
			// if the number 'i' is used before, we cannot use it
			if (used[i] == true) continue;
			
			// Else if the number is not used yet, use it
			result[idx] = i;
			
			// and mark the number as used. Recursion goes one level deeper.
			used[i] = true;
			recursion(idx+1, N, M);
			
			// when above recursion ends, reset 'used[]' array for next recursion. Kind of backtracking
			used[i] = false;
		}
		return;
	}
}
