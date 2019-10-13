package mst.b_4386;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int parent[] = new int[101];
	
	static List<Point> pointList = new ArrayList<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		double x, y;
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<N; i++) {
			x = scan.nextDouble();
			y = scan.nextDouble();
			
			pointList.add(new Point(x, y));
		}
		
		double dist = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				dist = calDist(pointList.get(i), pointList.get(j));
				pq.offer(new Node(i+1, j+1, dist));
			}
		}
		
		Node node;
		double cost = 0;
		int aRoot, bRoot;
		
		while(!pq.isEmpty()) {
			node = pq.poll();
			
			aRoot = find(node.start);
			bRoot = find(node.end);
			
			if(find(aRoot) == find(bRoot)) {
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
	
	static double calDist (Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

}

class Point {
	double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Node implements Comparable<Node>{
	int start, end;
	double cost;
	
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


