package com.algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SteelPipe {
	
	
	public void solution() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		int answer = 0;
		
		String pipe = br.readLine();
		for (int i=0; i<pipe.length(); i++) {
			if (pipe.charAt(i) == '(') {
				stack.push(i); // push each index
			}
			else if (pipe.charAt(i) == ')') {
				int previous = stack.pop();
				if (previous+1 == i) { // indicating that it is a laser, because previous index was '('
					answer += stack.size(); // then, remaining elements in the stack are pipes to cut with current laser.
				} else {
					answer++; // it means that currently looking ')' is the end of a pipe, and we should +1 answer since it is the last piece made by previous laser.
				}
			}
		}
		br.close();
		
		System.out.println(answer);
		return;
	}
}
