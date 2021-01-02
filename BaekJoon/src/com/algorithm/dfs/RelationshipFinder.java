package com.algorithm.dfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RelationshipFinder {
	
	static boolean[] visited = new boolean[2000];
	static int[][] edge = new int[2000][2000];
		
	public static void main(String[] args) throws IOException {
		
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of people (node)
        int m = sc.nextInt(); // number of relation (edge)
		
        // 1) make a 2D array and save edges from input   
        for (int i=0; i<m; i++) {
        	int start = sc.nextInt();
        	int end = sc.nextInt();
        	edge[start][end] = 1;
        	edge[end][start] = 1;
        }
        
        // 2) run dfs starting from first person,
        // and mark if the node is visited or not.
        dfs(edge[0][0], 0, m, n);
        System.out.println("0");
        
        sc.close();
        return;

	}

	// goal is desired depth.
	private static void dfs(int node, int depth, int goal, int totalNodes) {
		
		if (depth == goal) {
			System.out.println("1");
			return;
		}
		
		if (!visited[node]) {
			depth++;
			visited[node] = true;
			
			for (int i=0; i<totalNodes; i++) {
				if (edge[node][i] == 1) {
					dfs(edge[node][i], depth, goal, totalNodes);
				}
			}
		}
		return;
	}
}



//public class Main {
//	
//	static ArrayList<int[]> path = new ArrayList<>();
//	static boolean[] visited = new boolean[2000];
//	
//	public static void main(String[] args) throws IOException {
//		
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // number of people (node)
//        int m = sc.nextInt(); // number of relation (edge)
//		
//        // 1) make a 2D array and save edges from input
//        int[][] edge = new int[n][n];        
//        for (int i=0; i<m; i++) {
//        	int start = sc.nextInt();
//        	int end = sc.nextInt();
//        	edge[start][end] = 1;
//        	edge[end][start] = 1;
//        }
//        
//        // 2) run dfs starting from first person,
//        // and record the path in an ArrayList to avoid infinite loop.
//        // While dfs, mark visited nodes in visited[] array.
//        visited[0] = true;
//        dfs(edge, 0);
//        
//        // 3) at the end, if every index in the visited[] array is true, return 1. Else, return 0.
//        for (int i=0; i<n; i++) {
//        	if (visited[i] == false) {
//        		System.out.println("0");
//        		break;
//        	}
//        }
//
//        System.out.println("1");
//        sc.close();
//        return;
//
//	}
//	
//	private static void dfs(int[][] edge, int starting) {
//		
//		// iterate over a single node's edges
//		for (int i=0; i<edge.length; i++) {
//			
//			// if there is an edge in the 'starting' node
//			if (edge[starting][i] == 1) {
//				int[] e = new int[2];
//				
//				// define edge node order as {smaller, larger}
//				if (starting > i) {
//					e[0] = i;
//					e[1] = starting;
//				} else {
//					e[0] = starting;
//					e[1] = i;
//				}
//				
//				// if we did not count that path before, add it to 'path', and mark visited[]
//				if (checkRedundancy(e)) {
//					visited[e[0]] = true;
//					visited[e[1]] = true;
//					path.add(e);
//					
//					// and you can spread from the newly found connected node
//					dfs(edge, i);
//				}
//			}
//		}
//		
//	}
//	
//	private static boolean checkRedundancy(int[] e) {
//		for (int[] temp : path) {
//			if (temp[0] == e[0] && temp[1] == e[1]) return false;
//		}
//		return true;
//	}
//
//
//}
//
