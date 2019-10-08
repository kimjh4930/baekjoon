package mst.b_9372;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> tempQueue = new LinkedList<>();
	
	static int[][] map = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	
	static int T, N, M, start, end;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		T = scan.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			N = scan.nextInt();
			M = scan.nextInt();
			
			for(int i=1; i<=M ; i++) {
				start = scan.nextInt();
				end = scan.nextInt();
				
				map[start][end] = map[end][start] = 1;
			}
			
			visited[1] = true;
			queue.add(1);
			int result = bfs();
			
			System.out.println(result);
			
			queue.clear();
			tempQueue.clear();
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					map[i][j] = 0;
				}
			}
			
			for(int i=1; i<=N; i++) {
				visited[i] = false;
			}
				
		}
		scan.close();
	}
	
	static int bfs () {
		
		int end;
		int count = 0;
		boolean visitAll = true;
		
		while(!queue.isEmpty()) {
			end = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(map[end][i] == 1 && visited[i] == false) {
					visited[i] = true;
					count++;
					tempQueue.add(i);
				}
			}
			
			visitAll = true;
			
			for(int i=1; i<=N; i++) {
				visitAll &= visited[i];
			}
			
			if(visitAll) {
				break;
			}
			
			if(queue.isEmpty()) {
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		return count;
		
	}
}
