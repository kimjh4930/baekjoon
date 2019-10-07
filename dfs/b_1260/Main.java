package dfs.b_1260;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	
	static int N, M, start;
	
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> tempQueue = new LinkedList<>();
	
	static List<Integer> visitList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		start = scan.nextInt();
		
		int source, dest;
		
		for(int i=1; i<=M; i++) {
			source = scan.nextInt();
			dest = scan.nextInt();
			
			map[source][dest] = map[dest][source] = 1;
		}
		
		//dfs
		visitList.add(start);
		visited[start] = true;
		dfs(start);
		
		for(Integer visit : visitList) {
			System.out.print(visit + " ");
		}
		System.out.println("");
		
		for(int i=0; i<=N; i++) {
			visited[i] = false;
		}
		visitList.clear();
		
		queue.add(start);
		visitList.add(start);
		visited[start] = true;
		bfs();
		
		for(Integer visit : visitList) {
			System.out.print(visit + " ");
		}
		System.out.println("");
		
		scan.close();
	}
	
	static void dfs (int source) {
		
		for(int i=1; i<=N; i++) {
			if(map[source][i] == 1 && visited[i] == false) {
				visited[i] = true;
				visitList.add(i);
				dfs(i);
			}
		}
			
	}
	
	static void bfs () {
		
		int source;
		
		while(!queue.isEmpty()) {
			
			source = queue.poll();
			
			for(int i=1; i<=N; i++) { 
				if(map[source][i] == 1 && visited[i] == false) {
					visited[i] = true;
					visitList.add(i);
					tempQueue.add(i);
				}
			}
			
			if(queue.isEmpty()) {
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
	}

}
