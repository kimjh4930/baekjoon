package dijkstra.b_1753;

import java.awt.Toolkit;
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
	static PriorityQueue<Node> temppq = new PriorityQueue<>();
	
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
		
		next:
		for(int i=0; i<M; i++) {
			from = scan.nextInt();
			to = scan.nextInt();
			cost = scan.nextInt();
			
			if(!nodeMap.containsKey(from)) {
				nodeMap.put(from, new ArrayList<>());
			}
			
			List<Node> tempList = nodeMap.get(from);
			
			//중복체크.
			for(Node t : tempList) {
				if(t.from == from && t.to == to) {
					if(t.cost > cost) {
						t.cost = cost;
					}
					continue next;
				}
			}
			
			nodeMap.get(from).add(new Node(from, to, cost));
		}
		
		djikstra();
		
		for(int i=1; i<=N; i++) {
			if(dist[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
		
		scan.close();
	}
	
	static void djikstra() {
		
		List<Node> nodeList = nodeMap.get(start);
		dist[start] = 0;
		
		for(Node node : nodeList) {
			pq.offer(node);
		}
		
		Node node;
		int from, to, cost;
		
		while(!pq.isEmpty()) {
			node = pq.poll();
			
			from = node.from;
			to = node.to;
			cost = node.cost;
			
			System.out.println("(" + from + ", " + to + ", " + cost + "), " + dist[from] + ", " + dist[to]);
			
			if(dist[from] + cost < dist[to] ) {
				dist[to] = dist[from] + cost;
				temppq.offer(new Node(start, to, dist[to]));
				if(nodeMap.get(to) != null) {
					for(Node n : nodeMap.get(to)) {
						if(!temppq.contains(n)) {
							temppq.offer(n);
						}
					}
				}
			}
			
			if(pq.isEmpty()) {
				pq.addAll(temppq);
				temppq.clear();
			}
		}
	}
}

class Node implements Comparable<Node>{

	int from, to ,cost;
	
	public Node (int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
	
}
