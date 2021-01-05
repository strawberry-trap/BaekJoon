package com.algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PastingContinuousNumbers {
	
	public static void main(String[] args) throws IOException {
		
		// read input (range from 1 to 100,000,000)
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		
        int answer = 0;
		for (int i=1; i<=n; i++){
            int digit = (int)(Math.log10(i)+1);
            answer += digit;
        }
		
        System.out.println(answer);
		
		bf.close();	
		return;
	}

}
