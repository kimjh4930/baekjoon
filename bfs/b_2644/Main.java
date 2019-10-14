package bfs.b_2644;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int map[][] = new int[101][101];
	static boolean visited[][] = new boolean[101][101];
	static int parent[] = new int[101];
	
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> tempQueue = new LinkedList<>();
	
	static int N, M;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		int one = scan.nextInt();
		int two = scan.nextInt();
		
		M = scan.nextInt();
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		int p, s;
		
		for(int i=0; i<M; i++) {
			p = scan.nextInt();
			s = scan.nextInt();
			parent[s] = find(p);
			map[p][s] = map[s][p] = 1;
		}
		
		if(parent[one] != parent[two]) {
			System.out.println("-1");
		}else {
			System.out.println(bfs(one, two));
		}
		
		scan.close();
	}
	
	static int bfs (int one, int two) {
		int count = 1;
		
		for(int i=1; i<=N; i++) {
			if(visited[one][i] == false && map[one][i] ==1) {
				visited[one][i] = true;
				
				if(map[one][i] == 1 && i == two) {
					return count;
				}
				queue.add(i);
			}
		}
		
		int p;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(visited[p][i] == false && map[p][i] == 1) {
					visited[p][i] = true;
					
					if(map[p][i] == 1 && i == two) {
						return count+1;
					}
					
					tempQueue.add(i);
				}
			}
			
			if(queue.isEmpty()) {
				count++;
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		return count;
	}
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		
		parent[a] = find(parent[a]);
		return parent[a];
	}
	


}
