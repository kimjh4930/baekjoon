package mst.b_1647;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static Map<Integer, List<Point>> map = new HashMap<>();
	static boolean visited[] = new boolean[100001];
	
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	
	static int N, M;
	
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
			
			if(!map.containsKey(end)) {
				map.put(end, new ArrayList<>());
			}
			
			map.get(start).add(new Point(start, end, cost));
			map.get(end).add(new Point(start, end, cost));
		}
		
		visited[1] = true;
		List<Point> pList = map.get(1);

		for(Point p : pList) {
			pq.offer(p);
		}
		
		Point temp;
		
		long sum = 0;
		int count = 0;
		
		poll : 
		while(!pq.isEmpty()) {
			
			if(count == N-2) {
				break;
			}
			
			temp = pq.poll();
			
			if(visited[temp.end] == true) {
				continue poll;
			}
			
//			System.out.println("(" + temp.start + ", " + temp.end + ", " + temp.cost + ")");
			
			count++;
			visited[temp.end] = true;
			
			sum += (long)temp.cost;
			
			for(Point p : map.get(temp.end)) {
				pq.offer(p);
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
