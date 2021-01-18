package com.algorithm.queue;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumNumberOfComparison {
	
	public void main() throws IOException {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// get numbers from the input, and put them in the Priority Queue (small number gets higher priority)
		PriorityQueue<Integer> Q = new PriorityQueue<>();
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			Q.offer(number);
		}
		
		int answer = 0;
		while (Q.size()>1) {
			int compare = 0;
			compare += Q.poll();
			compare += Q.poll();
			answer += compare;
			Q.offer(compare);
		}
		
		System.out.println(answer);
		
		sc.close();
		return;
		
	}

}
