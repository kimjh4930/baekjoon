package mst.b_2211;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	
	static Map<Integer, List<Node>> map = new HashMap<>();
	
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	static int[][] costMap = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	
	static List<Node> connectedList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		int start, end, cost;
		
		for(int i=0; i<M; i++) {
			start = scan.nextInt();
			end = scan.nextInt();
			cost = scan.nextInt();
			
			if(!map.containsKey(start)) {
				map.put(start, new ArrayList<>());
			}
			map.get(start).add(new Node(start, end, cost));
			if(!map.containsKey(end)) {
				map.put(end, new ArrayList<>());
			}
			map.get(end).add(new Node(end, start, cost));
			
			costMap[start][end] = costMap[end][start] = cost;
		}
		
		visited[1] = true;
		List<Node> nodeList = map.get(1);
		
		for(Node node : nodeList) {
			pq.offer(node);
			connectedList.add(node);
		}
		
		Node node;
		
		while(!pq.isEmpty()) {
			
			node = pq.poll();
			
//			System.out.println("(" + node.start + ", " + node.end + ")" );
			
			if(visited[node.end] == true) {
				continue;
			}
			
			if(node.start != 1) {
				if(costMap[1][node.end] > costMap[1][node.start] + costMap[node.start][node.end]) {
					costMap[1][node.end] = costMap[1][node.start] + costMap[node.start][node.end];
					removeElement(1, node.end);
					connectedList.add(node);
				}
			}
			
			visited[node.end] = true;
			
			List<Node> nList = map.get(node.end);
			
			for(Node n : nList) {
				if(visited[n.end] == false) {
					pq.offer(n);
				}
			}
		}
		
		System.out.println(connectedList.size());
		for(Node n : connectedList) {
			System.out.println(n.start + " " + n.end);
		}
		
		scan.close();
	}
	
	static void removeElement (int start, int end) {
		
		Node temp = null;
		
		for(Node node : connectedList) {
			if(node.start == start && node.end == end) {
				temp = node;
				break;
			}
		}
		
		if(temp != null) {
			connectedList.remove(temp);
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
