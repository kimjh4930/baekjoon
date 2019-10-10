package mst.b_2887;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static List<int[]> combiList = new ArrayList<>();
	static Map<Integer, List<Node>> map = new HashMap<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static boolean[] visited = new boolean[100001];
	
	static int N;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		int x, y, z;
		
		List<Point> pList = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			z = scan.nextInt();
			
			pList.add(new Point(i, x, y, z));
		}
		
		int arr[] = new int[N];
		combination(arr, 0, N, 2, 0);
		
		Point p1, p2;
		int dist;
		
		for(int[] combi : combiList) {
			
			p1 = pList.get(combi[0]);
			p2 = pList.get(combi[1]);
			dist = calDist(p1, p2);
			
			
			if(!map.containsKey(p1.idx)) {
				map.put(p1.idx, new ArrayList<>());
			}
			if(!map.containsKey(p2.idx)) {
				map.put(p2.idx, new ArrayList<>());
			}
			
			map.get(p1.idx).add(new Node(p1.idx, p2.idx, dist));
			map.get(p2.idx).add(new Node(p2.idx, p1.idx, dist));
			
		}
		
		//탐색
		visited[1] = true;
		List<Node> nodeList = map.get(1);
		boolean visitAll = true;
		Node temp;
		
		int sum = 0;
		
		for(Node node : nodeList) {
			pq.offer(node);
		}
		
		poll:
		while(!pq.isEmpty()) {
			
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
			
			visited[temp.end] = true;
			sum += temp.cost;
			nodeList = map.get(temp.end);
			
			for(Node n : nodeList) {
				if(visited[n.end] == false) {
					pq.add(n);
				}
			}
			
		}
		
		System.out.println(sum);
		
		scan.close();
	}
	
	static int calDist (Point p1, Point p2) {
		int min = Math.min(Math.abs(p1.x-p2.x), Math.abs(p1.y-p2.y));
		return Math.min(min, Math.abs(p1.z-p2.z));
	}
	
	static void combination(int[] arr, int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			combiList.add(arr.clone());
			return;
		}
		
		if(index == n) {
			return;
		}
		
		arr[arrSize] = index;
		
		combination(arr, arrSize+1, n, r, index+1);
		combination(arr, arrSize, n, r, index+1);
	}

}

class Point {
	int idx;
	int x, y, z;
	
	public Point (int idx, int x, int y, int z) {
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.z = z;
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
