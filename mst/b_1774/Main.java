package mst.b_1774;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static double[][] map = new double[1001][1001];
	static int[] parent = new int[1001];
	
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		//parent 초기
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		List<Point> pointList = new ArrayList<>();
		List<Node> nodeList = new ArrayList<>();
		
		int x, y;
		int start, end;
		
		for(int i=1; i<=N; i++ ) {
			x = scan.nextInt();
			y = scan.nextInt();
			
			pointList.add(new Point(x, y));
		}
		for(int i=0; i<M; i++) {
			start = scan.nextInt();
			end = scan.nextInt();
			
			nodeList.add(new Node(start, end));
		}
		
		double dist;
		
		for(int i=0; i<pointList.size(); i++) {
			for(int j=i+1; j<pointList.size(); j++) {
				dist = calDist(pointList.get(i), pointList.get(j));
				pq.offer(new Node(i+1, j+1, dist));
			}
		}
		
		//이미 연결되어있는 것들 처리.		
		for(Node node : nodeList) {
			union(node.start, node.end);
		}
		
		Node node;
		int aRoot, bRoot;
		
		double cost = 0;
		
		while(!pq.isEmpty()) {
			node = pq.poll();
			
			aRoot = find(node.start);
			bRoot = find(node.end);
			
			if(aRoot == bRoot) {
				continue;
			}
			
			union(aRoot, bRoot);
			cost += node.cost;
		}
		
		System.out.format("%.2f%n", cost);
		
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
	
	static void printParent () {
		for(int i=1; i<=N; i++) {
			System.out.print(parent[i] + " ");
		}
		System.out.println("");
	}
	
	static double calDist (Point p1, Point p2) {
		return Math.sqrt( Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2) );
	}
}

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Node implements Comparable<Node>{
	int index;
	int start, end;
	double cost;
	
	public Node (int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public Node (int start, int end, double cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost > o.cost ? 1 : -1;
	}

}
