package dfs.b_2146;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[100][100];
	static int[][] groupMap = new int[100][100];
	static boolean[][] visited = new boolean[100][100];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static Map<Integer, Queue<Point>> beachMap = new HashMap<>();
	
	static int N;
	static int min = (1<<31) - 1;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		//구역을 나눈다.
		int count = 0;	//섬의 개수
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0 && visited[i][j] == false) {
					count++;
					visited[i][j] = true;
					groupMap[i][j] = count;
					queue.offer(new Point(j, i));
					bfs(count);
				}
			}
		}
		
		queue.clear();
		tempQueue.clear();
		
//		printMap();
		
		Iterator<Integer> iter = beachMap.keySet().iterator();
		int idx;
		
		while(iter.hasNext()) {
			idx = iter.next();
			queue = beachMap.get(idx);
			clearVisited();
			tempQueue.clear();
			
			visited[queue.peek().y][queue.peek().x] = true;
			
			beachBfs(idx);
			
//			bridgeMap();
		}
		
		System.out.println(min);
		
		scan.close();
	}
	
	static void bfs (int count) {
		
		int temp_x, temp_y;
		
		Queue<Point> beachQueue = new LinkedList<>();
		
		Point p;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=0; i<4; i++) {
				temp_x = p.x + dx[i];
				temp_y = p.y + dy[i];
				
				if(checkRange(temp_x, temp_y) && visited[temp_y][temp_x] == false) {
					if(map[temp_y][temp_x] != 0) {
						visited[temp_y][temp_x] = true;
						groupMap[temp_y][temp_x] = count;
						Point nextP = new Point(temp_x, temp_y);
						tempQueue.offer(nextP);
					}else {
						// 현재 위치에서 해안가인지 아닌지 판단한다.
						if(!beachQueue.contains(p)) {
							beachQueue.offer(p);
						}
					}
				}
			}
			
			if(queue.isEmpty()) {
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		beachMap.put(count, beachQueue);
	}
	
	static void beachBfs (int idx) {
		
		int temp_x, temp_y;
		Point p;
		int count = 0;
		
		outer:
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=0; i<4; i++) {
				temp_x = p.x + dx[i];
				temp_y = p.y + dy[i];
				
				if(checkRange(temp_x, temp_y) && visited[temp_y][temp_x] == false) {
					
					if(groupMap[temp_y][temp_x] == idx) {
						continue;
					}else if(groupMap[temp_y][temp_x] == 0) {
						visited[temp_y][temp_x] = true;
						tempQueue.add(new Point(temp_x, temp_y));
					}else if (groupMap[temp_y][temp_x] != idx) {
						break outer;
					}
				}
			}
			
			if(queue.isEmpty()) {
				count++;
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
//		System.out.println("count : " + count);
		if(count < min) {
			min = count;
		}
		
	}
	
	static boolean checkRange (int x, int y) {
		if(x>=0 && x<N && y>=0 && y<N) {
			return true;
		}
		return false;
	}
	
	static void clearVisited () {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	static void bridgeMap () {
		System.out.println("======================================");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) {
					System.out.print("1 ");
				}else {
					System.out.print("0 ");
				}
			}
			System.out.println("");
		}
	}
	
	static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(groupMap[i][j] + " ");
			}
			System.out.println("");
		}
	}

}

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
