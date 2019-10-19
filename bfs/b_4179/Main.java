package bfs.b_4179;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map = new char[1001][1001];
	static boolean[][] visited = new boolean[1001][1001];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static Queue<Point> pQueue = new LinkedList<>();
	static Queue<Point> ptQueue = new LinkedList<>();
	
	static Queue<Point> fQueue = new LinkedList<>();
	static Queue<Point> ftQueue = new LinkedList<>();
	
	static int R, C;
	static int min = -1;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		String input;
		
		for(int i=1; i<=R; i++) {
			input = br.readLine();
			for(int j=1; j<=C; j++) {
				
				map[i][j] = input.charAt(j-1);
				
				if(map[i][j] == 'J') {
					map[i][j] = '.';
					visited[i][j] = true;
					pQueue.offer(new Point(j, i));
				}else if(map[i][j] == 'F') {
					fQueue.offer(new Point(j, i));
				}
			}
		}
		
		int count = 0;
		boolean isEscape = true;
		
		while(!pQueue.isEmpty()) {
			
			//불을 확산시킴.
			count++;
			fireBfs();
			//지훈이가 대피함.
			isEscape = personBfs();
			
			if(isEscape) {
				min = count;
				break;
			}
			
			if(!ftQueue.isEmpty()) {
				fQueue.addAll(ftQueue);
				ftQueue.clear();
			}
			
			if(!ptQueue.isEmpty()) {
				pQueue.addAll(ptQueue);
				ptQueue.clear();
			}
		}
		
		System.out.println(min == -1 ? "IMPOSSIBLE" : min);
		
		br.close();
	}
	
	static void fireBfs () {
		Point p;
		int tx, ty;
		
		while(!fQueue.isEmpty()) {
			
			p = fQueue.poll();
			
			for(int i=0; i<4; i++) {
				tx = p.x + dx[i];
				ty = p.y + dy[i];
				
				if(checkRange(tx, ty) && map[ty][tx] == '.') {
					map[ty][tx] = 'F';
					ftQueue.offer(new Point(tx, ty));
				}
			}
		}
	}
	
	static boolean personBfs () {
		Point p;
		int tx, ty;
		
		while(!pQueue.isEmpty()) {
			
			p = pQueue.poll();
			
			for(int i=0; i<4; i++) {
				tx = p.x + dx[i];
				ty = p.y + dy[i];
				
				if(checkRange(tx, ty) == false) {
					return true;
				}else {
					if(visited[ty][tx] == false && map[ty][tx] == '.') {
						visited[ty][tx] = true;
						ptQueue.offer(new Point(tx, ty));
					}
				}
			}
		}
		
		return false;
	}
	
	static boolean checkRange (int x, int y) {
		if(x >=1 && x<=C && y >=1 && y<=R) {
			return true;
		}
		return false;
	}
	
	static void printMap () {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
		
		System.out.println("======================");
	}

}

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
