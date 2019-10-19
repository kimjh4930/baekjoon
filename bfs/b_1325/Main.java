package bfs.b_1325;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Integer> indexList[] = new ArrayList[10001];
	static boolean[] visited = new boolean[10001];
	static int[] countArray = new int[10001]; 
	
	static int N, M;
	static int max = -1;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		for(int i=0; i<=N; i++) {
			indexList[i] = new ArrayList<>();
		}
		
		int start, end;
		
		for(int i=0; i<M; i++) {
			start = scan.nextInt();
			end = scan.nextInt();
			
			indexList[start].add(end);
		}
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[10001];
			dfs(i);
		}
		
		StringBuffer result = new StringBuffer();
		
		for(int i=1; i<=N; i++) {
			if(countArray[i] > max) {
				max = countArray[i];
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(countArray[i] == max) {
				result.append(i + " ");
			}
		}
		
		System.out.println(result.toString());
		
		scan.close();
	}
	
	static void dfs (int idx) {
		
		visited[idx] = true;
		
		for(Integer i : indexList[idx]) {
			if(visited[i] == false) {
				countArray[i]++;
				dfs(i);
			}
		}
	}
}
