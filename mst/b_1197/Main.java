package mst.b_1197;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static List<Point>[] startList;
	static Map<Integer, List<Point>> map = new HashMap<>();
	
	static boolean[] visited = new boolean[10001];
	
	static int V, E;
	
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		V = scan.nextInt();
		E = scan.nextInt();
		
		int start, end, cost;
		
		for(int i=1; i<=E; i++) {
			start = scan.nextInt();
			end = scan.nextInt();
			cost = scan.nextInt();
			
			if(!map.containsKey(start)) {
				List<Point> pList = new ArrayList<>();
				map.put(start, pList);
			}
			
			if(!map.containsKey(end)) {
				List<Point> pList = new ArrayList<>();
				map.put(end, pList);
			}
			
			map.get(start).add(new Point(start, end, cost));
			map.get(end).add(new Point(end, start, cost));
		}
		
		visited[1] = true;
		List<Point> pList = map.get(1);
		
		for(Point p : pList) {
			pq.offer(p);
		}
		
		boolean visitAll = true;
		Point temp;
		int sum = 0;
		
		poll : 
		while(!pq.isEmpty()) {
			
			temp = pq.poll();
			
			if(visited[temp.end] == true) {
				continue poll;
			}
			
			for(int i=1; i<=V; i++){
				visitAll &= visited[i];
			}
			
			if(visitAll) {
				break;
			}

			sum += temp.cost;
			visited[temp.end] = true;
			
			List<Point> list = map.get(temp.end);
			
			for(Point p : list) {
				if(visited[p.end] == false) {
					pq.offer(p);
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
		return this.cost > o.cost ? 1 : -1;
	}
}
