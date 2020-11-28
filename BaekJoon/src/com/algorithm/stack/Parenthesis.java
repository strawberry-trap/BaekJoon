package com.algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*

https://www.acmicpc.net/problem/9012
Stack
easy

*/
public class Parenthesis {
	
	public void solution() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = br.read();
		br.readLine(); // for ignoring '\n' at the end of first line
		
		for (int i=0; i<testCases; i++) {
			
			String line = br.readLine();

			int count = 0;
			for (int j=0; j<line.length(); j++) {
				char c = line.charAt(j);
				if (c == '(') count++;
				else if (c == ')') count--;
				if (count < 0) {
					System.out.println("NO");
					continue;
				}
			}
			if (count != 0) System.out.println("NO");
			else System.out.println("YES");
		}
		br.close();
		return;
	}
	

}

/*

6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(
 
*/
