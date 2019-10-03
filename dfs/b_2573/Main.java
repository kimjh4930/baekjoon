package dfs.b_2573;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int map[][][] = new int[2][300][300];
	static boolean visited[][] = new boolean[300][300];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static int R, C;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		R = scan.nextInt();
		C = scan.nextInt();
		
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[0][i][j] = scan.nextInt();
				
				if(map[0][i][j] != 0) {
					queue.offer(new Point(j, i));
				}
			}
		}
		
		int year = 0;
		int count = 0;
		
		if(!queue.isEmpty()) {
			while(true) {
				
				count = 0;
				//섬을 탐
				bfs();
				clearVisitedSite();
				
				//감소시킨다.
				reduceIceburg();
				
				outer:
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(map[0][i][j] > 0 && visited[i][j] == false) {
							count++;
							
							if(count > 1) {
								break outer;
							}
							
							visited[i][j] = true;
							dfs(j, i);
						}
					}
				}
				
				year++;
				
				if(count > 1) {
					break;
				}
				
				clearVisitedSite();
				
				queue.addAll(tempQueue);
				tempQueue.clear();
				
				if(queue.isEmpty()) {
					year = 0;
					break;
				}
			}
		}
		
		System.out.println(year);
		
		scan.close();
	}
	
	static void bfs () {
		int temp_x, temp_y;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i=0; i<4; ++i) {
				temp_x = p.x + dx[i];
				temp_y = p.y + dy[i];
				if(checkRange (temp_x, temp_y)) {
					if(map[0][temp_y][temp_x] == 0) {
						map[1][p.y][p.x]++;
					}else {
						if(visited[p.y][p.x] == false) {
							visited[p.y][p.x] = true;
							tempQueue.add(p);
						}
					}
				}
			}
		}
	}
	
	static void reduceIceburg () {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[1][i][j] > 0) {
					map[0][i][j] -= map[1][i][j];
					map[1][i][j] = 0;
					
					if(map[0][i][j] < 0) {
						map[0][i][j] = 0;
					}
				}
			}
		}
	}
	
	static boolean checkRange (int x, int y) {
		if(x >= 0 && x < C && y >= 0 && y < R) {
			return true;
		}
		return false;
	}
	
	static void clearVisitedSite () {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	static void dfs (int x, int y) {
		int temp_x, temp_y;
		
		for(int i=0; i<4; i++) {
			temp_x = x + dx[i];
			temp_y = y + dy[i];
			
			if(checkRange(temp_x, temp_y)) {
				if(map[0][temp_y][temp_x] > 0 && visited[temp_y][temp_x] == false) {
					visited[temp_y][temp_x] = true;
					dfs(temp_x, temp_y);
				}
			}
		}
		
	}
	
	static void printMap () {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[0][i][j] + " ");
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