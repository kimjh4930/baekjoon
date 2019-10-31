package bfs.b_5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> tempQueue = new LinkedList<>();
	
	static boolean[] visited = new boolean[1000001];
	
	static int F, S, G, U, D;
	static int d[] = new int[2];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		F = scan.nextInt();
		S = scan.nextInt();
		G = scan.nextInt();
		U = scan.nextInt();
		D = scan.nextInt();
		
		d[0] = U;
		d[1] = -1 * D;
		
		visited[S] = true;
		
		if(S == G) {
			System.out.println(0);
			return;
		}
		
		queue.add(S);
		
		int result = bfs();
		
		if(result == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(result);
		}
		
		scan.close();
	}
	
	static int bfs () {
		
		int stair;
		int ts;
		int count = 0;
		
		while(!queue.isEmpty()) {
			stair = queue.poll();
			
			for(int i=0; i<2; i++) {
				ts = stair + d[i];
				
				if(checkRange(ts) && visited[ts] == false) {
					visited[ts] = true;
					if(ts == G) {
						return count+1;
					}
					tempQueue.add(ts);
				}
			}
			
			if(queue.isEmpty()) {
				count++;
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		return -1;
		
	}
	
	static boolean checkRange (int stair) {
		
		if(stair >=1 && stair <=F) {
			return true;
		}
		return false;	
	}

}
