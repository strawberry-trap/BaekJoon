package com.algorithm.sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// original bubble sort code
/*
boolean swapped = false;
for (int i=1; i<n; i++) {
	swapped = false;
	for (int j=1; j<=n-i; j++) {
		if (numbers[j] > numbers[j+1]) {
			
			// swap
			int temp = numbers[j];
			numbers[j] = numbers[j+1];
			numbers[j+1] = temp;
			swapped = true;
		}
	}
	if (swapped == false) {
		System.out.println(i);
		break;
	}
}
*/

class Coordinate implements Comparable<Coordinate> {
	
	int number;
	int idx;
	
	Coordinate(int number, int idx){
		this.number = number;
		this.idx = idx;
	}

	@Override
	public int compareTo(Coordinate o) {
		return number - o.number;
	}

}

public class BubbleSort {

	public void main() throws IOException {
		
		// get input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Coordinate[] coord = new Coordinate[n+1];
		for (int i=0; i<n; i++) {
			int number = sc.nextInt();
			coord[i] = new Coordinate(number, i);
		}
		
		Arrays.sort(coord, 0, n);
		
		// checking how many bubble sorts are done
		int max = 0;
		for (int i=0; i<n; i++) {
			max = Math.max(max, (coord[i].idx - i)); // moved number - 1
		}
		
		System.out.println(max+1);
		
		return;
	}
		
}
