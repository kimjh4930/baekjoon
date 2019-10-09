package mst.b_1922;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int map[][] = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	
	static int N, M, cost;
	
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		int start, end;
		
		for(int i=1; i<=M; i++) {
			start = scan.nextInt();
			end = scan.nextInt();
			map[start][end] = map[end][start] = scan.nextInt();
		}
		
		int sum = 0;
		Point temp;
		visited[1] = true;
		
		boolean visitAll = true;
		
		for(int i=1; i<=N; i++) {
			if(map[1][i] != 0) {
				pq.offer(new Point(1, i, map[1][i]));
//				System.out.println("i : " + i);
			}
		}
		
		poll:
		while(!pq.isEmpty()) {
			
			visitAll = true;
			
			for(int i=1; i<=N; i++) {
				visitAll &= visited[i];
			}
			
			if(visitAll) {
				break;
			}
			
			temp = pq.poll();
			
			if(visited[temp.end] == true) {
				continue poll;
			}
			
//			System.out.println("(" + temp.start + ", " + temp.end + ") : " + temp.cost);
			
			visited[temp.end] = true;
			sum += temp.cost;
			
//			System.out.println(temp.end);

			for(int i=1; i<=N; i++) {
				if(map[temp.end][i] != 0) {
					pq.offer(new Point(temp.end, i, map[temp.end][i]));
				}
			}
			
		}
		
		System.out.println(sum);
		scan.close();
	}

}

class Point implements Comparable<Point>{
	
	int start, end, cost;
	
	public Point(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Point o) {
		return this.cost < o.cost ? -1 : 1;
	}
	
}