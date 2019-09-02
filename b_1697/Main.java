package b_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] visited = new int[100001];
	
	static int[] dx = {1, -1, 2};
	
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> tempQueue = new LinkedList<>();
	
	static int N, K;
	static int time = 0;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		K = scan.nextInt();
		
		for(int i=0; i<100001; i++) {
			visited[i] = -1;
		}
		
		visited[N] = time;
		queue.add(N);
		bfs();
		
		System.out.println(time);
		
		scan.close();
	}
	
	static void bfs () {
		int temp_x;
		int x;
		
		if(N == K) {
			return;
		}
		
		while(!queue.isEmpty()) {
			x = queue.poll();
			
			for(int i=0; i<3; i++) {
				if(i < 2) {
					temp_x = x + dx[i];
				}else {
					temp_x = x * dx[i];
				}
				
				if(temp_x >= 0 && temp_x < 100001) {
					if(visited[temp_x] == -1) {
						visited[temp_x] = time;
						tempQueue.add(temp_x);
					}
				}
			}
			if(queue.isEmpty()) {
				time++;

				if(visited[K] != -1) {
					return;
				}
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
	}
}
