package com.algorithm.string;

import java.io.IOException;
import java.util.Scanner;

public class ParallelStrings {
	
	public void main() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine()); // length
		String s = sc.nextLine(); // string
		
		// for each character in the string,
		for (int i=0; i<s.length(); i++) {
			
			// try removing single character at index 'i'
			String newString = s.substring(0, i) + s.substring(i+1);
			
			// now divide the string in half, and compare if they are the same
			String left = newString.substring(0, newString.length()/2);
			String right = newString.substring(newString.length()/2);
			
			if (left.compareTo(right) == 0) {
				
				// checking "not unique" case, by doing the same thing on "left" string.
				String L = left.substring(0, left.length()/2);
				String R = left.substring(left.length()/2);
				if (L.compareTo(R) == 0) {
					System.out.println("NOT UNIQUE");
					return;
				}
				else {					
					System.out.println(left);
					return;
				}
				
			}
		}
		
		System.out.println("NOT POSSIBLE");
		return;
	}
	

}
