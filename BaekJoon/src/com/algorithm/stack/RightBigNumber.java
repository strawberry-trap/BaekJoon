package com.algorithm.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class RightBigNumber {

	
	public void solution() throws IOException {
		
		// read input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//¼±¾ð
		Stack<Integer> stack = new Stack<>();
		
		String firstLine = br.readLine(); // assume numbers > 0
		int numbers = Integer.parseInt(firstLine);
		
		String secondLine = br.readLine();
		String[] tempArray = secondLine.split(" ");
		int[] array = new int[numbers]; // store numbers in array
		for (int k=0; k<tempArray.length; k++) {
			array[k] = Integer.parseInt(tempArray[k]);
		}
		
		int[] answer = new int[numbers]; // store each number's right-big-number
		
		stack.push(0); // at the beginning, push index 0
		for (int i=1; i<numbers; i++) {
			if (array[i] > array[stack.peek()]) { // it means that array[i] is right-big-number of the remaining numbers in stack
				while(!stack.isEmpty() && array[stack.peek()] < array[i]) {
					answer[stack.pop()] = array[i];
				}
			}
			stack.push(i);
		}
		
		// after the for loop, numbers in the remaining stack doesn't have right-big-number.
		while(!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}
		
		for (int num : answer) {
			bw.write(num + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		return;
	}
}
