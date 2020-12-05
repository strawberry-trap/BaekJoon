package com.algorithm.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #17087
public class HideAndSeek {
	
	public void solution() throws IOException {
		
		// read, write input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCases = bf.read();
		bf.read(); // consume whitespace
		int startingPoint = Integer.parseInt(bf.readLine());
		
		// convert string array to an integer array
		String[] numbersAsString = bf.readLine().split(" ");
		int[] numbersAsInteger = new int[numbersAsString.length];
		for (int j=0; j<numbersAsString.length; j++) {
			numbersAsInteger[j] = Math.abs(Integer.parseInt(numbersAsString[j]) - startingPoint); // here, we should put numbersAsString[1] in numbersAsInteger[0], and [2] in [1], ....
		}
		
		int gcd = numbersAsInteger[0];
		for (int x=1; x<numbersAsInteger.length; x++) {
			gcd = greatestCommonDivisor(gcd, numbersAsInteger[x]);
		}

		bw.write(String.valueOf(gcd));
		bw.flush();
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
