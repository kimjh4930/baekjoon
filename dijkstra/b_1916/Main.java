package dijkstra.b_1916;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int[][] dist = new int[1001][1001];
	
	static final int INF = (1<<31)-1;
	static int N, M;
	
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				dist[i][j] = INF;
			}
		}
		
		int start, end, cost;
		
		for(int i=0; i<M; i++) {
			start = scan.nextInt();
			end = scan.nextInt();
			cost = scan.nextInt();
			
			dist[start][end] = Math.min(dist[start][end], cost);
		}
		
		start = scan.nextInt();
		end = scan.nextInt();
		
		int result = djikstra(N, start, end);
		System.out.println(result);
		
		scan.close();
	}
	
	static  int djikstra (int n, int start, int end) {
		for(int i=1; i<=n; i++) {
			if(start != i && dist[start][i] < INF) {
				pq.offer(new Node(i, dist[start][i]));
			}
		}
		
		Node node;
		int idx, cost;
		
		while(!pq.isEmpty()) {
			node = pq.poll();
			idx = node.idx;
			cost = node.cost;
			
			for(int i=1; i<=n; i++) {
				if(dist[idx][i] != INF && cost + dist[idx][i] < dist[start][i]) {
					dist[start][i] = cost + dist[idx][i];
					pq.offer(new Node(i, dist[start][i]));
				}
			}
		}
		
		return dist[start][end];
	}

}

class Node implements Comparable<Node>{
	
	int idx;
	int cost;
	
	public Node (int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
	
}
