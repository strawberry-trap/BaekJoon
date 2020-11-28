package com.algorithm.stack;
import java.util.Scanner;
import java.util.Stack;

/*

https://www.acmicpc.net/problem/9093
Stack
easy

*/
public class ReverseWord {
	
	public void solution() {
		
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		scanner.nextLine(); // for ignoring '\n' at the end of first line
		
		Stack<Character> stack = new Stack<>();
		
		for (int i=0; i<testCases; i++) {

			String line = scanner.nextLine() + " ";
			
			for (int j=0; j<line.length(); j++) {
				
				char c = line.charAt(j);
				
				if (c == ' ') {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				} else {
					stack.push(c);
				}
			}
			
			System.out.println();
		}
		scanner.close();
		return;
	}
}
