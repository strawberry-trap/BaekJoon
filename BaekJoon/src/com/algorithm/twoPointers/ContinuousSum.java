package com.algorithm.twoPointers;

import java.io.IOException;
import java.util.Scanner;

public class ContinuousSum {
	
public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] numbers = new int[n+1];
		for (int j=1; j<=n; j++) { // numbers valid index starts from 1 to 100,000
			int num = sc.nextInt();
			numbers[j] = num;
		}
		
		int L=1, R=1, sum=0, max=numbers[L];
		while (L<=R && R<=n) {
			sum += numbers[R];
			if (sum < 0) { // if [L,R] continuous sum is negative, ignoring [L, R] gives larger sum. ex) [sum = -3], 2, 5, 1 then the answer is simply 2+5+1
				L = ++R;
				max = Math.max(max, sum);
				sum = 0;
			} else {
				R++;
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
}
