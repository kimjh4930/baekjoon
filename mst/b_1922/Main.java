package mst.b_1922;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	
	static int[][] map = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	
	static List<Point> pointList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		int n, m, c;
		
		for(int i=0; i<M; i++) {
			n = scan.nextInt();
			m = scan.nextInt();
			c = scan.nextInt();
			
			map[n][m] = c;
		}
		
		visited[1] = true;
		
		Point p;
		int k=0;
		int sum = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				pointList.add(new Point(i, j, map[i][j]));
			}
			
			pointList.sort(new SortList());
			
			while(true) {
				
				if(visited[pointList.get(k).m] == false) {
					visited[pointList.get(k).m] = true;
					sum = 0;
					break;
				}
				k++;
			}
			
		}
		
		scan.close();
	}

}

class Point {
	int n, m, c;
	
	public Point(int n, int m, int c) {
		this.n = n;
		this.m = m;
		this.c = c;
	}
}

class SortList implements Comparator<Point>{

	@Override
	public int compare(Point o1, Point o2) {
		
		return o1.c > o2.c ? 1 : -1;
	}
	
}
