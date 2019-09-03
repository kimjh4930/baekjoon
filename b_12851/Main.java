package b_12851;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] visited = new int[2][100001];
	
	static int[] dx = {1, -1, 2};
	
	static int N, K;
	static int time=0;
	
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> tempQueue = new LinkedList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		K = scan.nextInt();
		
		for(int i=0; i<100001; i++) {
			visited[0][i] = -1;
		}
		
		visited[0][N] = 0;
		visited[1][N] = 1;
		
		queue.add(N);
		
		bfs();
		
		System.out.println(visited[0][K]);
		System.out.println(visited[1][K]);
		
		scan.close();
	}
	
	static void bfs () {
		
		int temp_x;
		int x;
		
		if(N == K) {
			return;
		}
		
		time++;
		
		while(!queue.isEmpty()) {
			
			x = queue.poll();
			
//			System.out.print(x + " ");
			
			for(int i=0; i<3; i++) {
				if(i<2) {
					temp_x = x + dx[i];
				}else {
					temp_x = x * 2;
				}
				
				if(temp_x>=0 && temp_x<100001) {
					
					if(visited[0][temp_x] == -1) {
						//처음 방문했을 때
						visited[0][temp_x] = time;
						visited[1][temp_x] = 1;
						
						tempQueue.add(temp_x);
					}else {
						//처음 방문이 아닐때
						
						//같은 bfs에서 돌았으면.
						if(visited[0][temp_x] > time) {
							visited[0][temp_x] = time;
							visited[1][temp_x] = 1;
							tempQueue.add(temp_x);
						}else if(visited[0] [temp_x] == time){
							visited[1][temp_x]++;
							tempQueue.add(temp_x);
						}
					}
				}
			}
			
			if(queue.isEmpty()) {
				time++;
				
				if(visited[0][K] != -1) {
					break;
				}

				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
	}
}
