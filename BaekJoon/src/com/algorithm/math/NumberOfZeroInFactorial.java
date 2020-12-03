package com.algorithm.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #1676
public class NumberOfZeroInFactorial {

	public void solution() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int input = Integer.parseInt(s);
		
		// exception for factorial zero
		if (input==0) {
			System.out.println(0);
			return;
		}
		
		int count = 0;
		for (int i=1; i<=input; i++) {
			for (int k=5; k<=i; k*=5) {
				if (i%k == 0) count++; 
			}
		}
		
		System.out.println(count);

		// afterwork
		bf.close();
		
		return;
	}
}
