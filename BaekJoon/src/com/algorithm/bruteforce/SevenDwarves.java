package com.algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenDwarves {
	
	public static void main(String[] args) throws IOException {
		
		int[] height = new int[9];
		int sum = 0;
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<9; i++) {
			int n = Integer.parseInt(bf.readLine());
			sum += n;
			height[i] = n;
		}
		
		Arrays.parallelSort(height);
		
		for (int i=0; i<9; i++) {
			for (int j=i+1; j<9; j++) {
				if (sum - height[i] - height[j] == 100) {
					for (int k=0; k<9; k++) {
						if (k==i || k==j) continue;
						System.out.println(height[k]);
					}
				}
			}
		}
        
		bf.close();	
		return;
	}
	
	
}
