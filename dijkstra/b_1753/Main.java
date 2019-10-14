package dijkstra.b_1753;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int[] dist;	//start위치기준;
	static final int INF = (1<<31)-1;
	
	static Map<Integer, List<Node>> nodeMap = new HashMap<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	static int N, M, start;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		dist = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			dist[i] = INF;
		}
		
		start = scan.nextInt();
		
		int from, to, cost;
		
		for(int i=0; i<M; i++) {
			from = scan.nextInt();
			to = scan.nextInt();
			cost = scan.nextInt();
			
			if(!nodeMap.containsKey(from)) {
				nodeMap.put(from, new ArrayList<>());
			}
			nodeMap.get(from).add(new Node(to, cost));
		}
		
		dist[start] = 0;
		djikstra(start);
		
		for(int i=1; i<=N; i++) {
			if(dist[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
		
		scan.close();
	}
	
	static void djikstra (int start) {
		
		Node temp;
		List<Node> nodeList;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			temp = pq.poll();
			
			nodeList = nodeMap.get(temp.to);
			
			if(nodeList == null) {
				continue;
			}
			
			for(Node node : nodeList) {
				int newVal = dist[temp.to] + node.cost;
				int beforeVal = dist[node.to];
				
				if(newVal < beforeVal) {
					dist[node.to] = dist[temp.to] + node.cost;
					pq.offer(new Node(node.to, dist[node.to]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{

	int to ,cost;
	
	public Node (int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
	
}
