package com.algorithm.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// #1406

public class Editor {

	public void solution() throws IOException {
		
		// read input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //識情
		String sentence = bf.readLine();
		int commands = Integer.parseInt(bf.readLine());

		// left stack contains characters located at the left of the cursor
		Stack<Character> leftStack = new Stack<>();
		
		// at first, cursor is at the end of the sentence. Therefore leftStack should contain all the characters.
		for (int j=0; j<sentence.length(); j++){
			leftStack.push(sentence.charAt(j));
		}
		
		// containing characters located right
		Stack<Character> rightStack = new Stack<>();
		
		// read each command from input.
		for (int i=0; i<commands; i++) {
			
			String command = bf.readLine();
			if (command.charAt(0) == 'L') {
				if (!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop());
				}
			}
			else if (command.charAt(0) == 'R') {
				if (!rightStack.isEmpty()) {
					leftStack.push(rightStack.pop());
				}
			}
			else if (command.charAt(0) == 'P') { // add
				leftStack.push(command.charAt(2));
			}
			else if (command.charAt(0) == 'B') { // delete
				if (!leftStack.isEmpty()) {
					leftStack.pop();
				}
			}
		}
		
		// print output
		String left = "", right = "";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//識情
		while(!leftStack.isEmpty()) left = leftStack.pop() + left;
		while(!rightStack.isEmpty()) right = rightStack.pop() + right;
		
		bw.write(left + right);
		
		// afterwork
		bw.flush();
		bw.close();
		bf.close();
		
		return;
	}
}
