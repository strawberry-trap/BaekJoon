package com.algorithm.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #1934
public class GreatestCommonDivisor {
	
	public void solution() throws IOException {
		
		// read, write input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(bf.readLine());
		
		for (int i=0; i<testCases; i++) {
			
			String[] numbersAsString = bf.readLine().split(" ");
			int[] numbersAsInteger = new int[numbersAsString.length-1]; // numbersAsString array's 0-th index contains the quantity of numbers.
			
			for (int z=1; z<numbersAsString.length; z++) {
				numbersAsInteger[z-1] = Integer.parseInt(numbersAsString[z]); // here, we should put numbersAsString[1] in numbersAsInteger[0], and [2] in [1], ....
			}
			
			long answer = 0;
			for (int x=0; x<numbersAsInteger.length; x++) {
				for (int y=x+1; y<numbersAsInteger.length; y++) {
					answer += greatestCommonDivisor(numbersAsInteger[x], numbersAsInteger[y]);
				}
			}
			bw.write(String.valueOf(answer));
			bw.write('\n');
			bw.flush();
		}
	
		// afterwork
		bw.close();
		bf.close();
		return;
	}
	
	// using Euclidean algorithm
	public static int greatestCommonDivisor(int x, int y) {
		
		if (y == 0) return x;
		else return greatestCommonDivisor(y, x%y);
	}
}
