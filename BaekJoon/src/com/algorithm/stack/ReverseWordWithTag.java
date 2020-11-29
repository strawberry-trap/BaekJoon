package com.algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/17413
Stack
easy
 */

public class ReverseWordWithTag {

	public void solution() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String line = br.readLine() + " ";
		for (int j=0; j<line.length(); j++) {
			char c = line.charAt(j);
			
			// when meeting '<', skim the string while meeting '>'
			if (c == '<') {
				if (!stack.isEmpty()) {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
				}
				while (line.charAt(j) != '>' && j < line.length()) {
					System.out.print(line.charAt(j));
					j++;
				}
				System.out.print(line.charAt(j));
				continue;
			}
			
			else if (c == ' ') {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(" ");
			} else {
				stack.push(c);
			}

		}
		br.close();
		return;
	}
}
