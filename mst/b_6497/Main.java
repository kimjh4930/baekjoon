package mst.b_6497;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] parent;
	
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			N = scan.nextInt();
			M = scan.nextInt();
			
			if(N == 0 && M == 0) {
				break;
			}
			
			parent = new int[N];
			
			int tatalcost = 0;
			int start, end, cost;
			
			for(int i=0; i<M; i++) {
				start = scan.nextInt();
				end = scan.nextInt();
				
				cost = scan.nextInt();
				
				tatalcost += cost;
				
				pq.offer(new Node(start, end, cost));
			}
			
			
			for(int i=0; i<N; i++) {
				parent[i] = i;
			}
			
			Node node;
			int sum = 0;
			int a, b;
			
			while(!pq.isEmpty()) {
				node = pq.poll();
				
				a = find(node.start);
				b = find(node.end);
				
				if(a == b) {
					continue;
				}
				
				union(a, b);
				sum += node.cost;
				
			}
			
			System.out.println((tatalcost - sum));
		}
		
		scan.close();
	}
	
	static int find (int a) {
		if(parent[a] == a) {
			return a;
		}
		
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void union (int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {
			parent[aRoot] = bRoot;
		}
	}
}

class Node implements Comparable<Node>{
	
	int start, end, cost;
	
	public Node (int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
	
		return this.cost > o.cost ? 1 : -1;
	}
	
}
