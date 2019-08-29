package b_16234;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[50][50];
	static boolean[][] visited = new boolean[50][50];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static List<Point> connectedList = new ArrayList<>();
	
	static int N, L, R;
	static int diff;
	static int sum = 0;
	static int nextValue = 0;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		L = scan.nextInt();
		R = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		int dfsCallCount = 0;
		int times = 0;
		
//		printMap();
		
		while(true) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j] == false) {
						connectedList.add(new Point(j, i));
						sum += map[i][j];
						visited[i][j] = true;
						
						dfsCallCount++;
						
						
						
						dfs(j, i);
						
						nextValue = sum / connectedList.size();
						
						for(Point p : connectedList) {
//							System.out.println("(" + p.x + "," + p.y + ")");
							map[p.y][p.x] = nextValue;
						}
						
						//초기화
						connectedList.clear();
						nextValue = 0;
						sum = 0;
						
//						printMap();
					}
				}
			}
			
			if(dfsCallCount  < N*N) {
				times++;
			}
			
			if(dfsCallCount == N*N) {
				break;
			}
			
			//clear
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited[i][j] = false;
				}
			}
			
			dfsCallCount = 0;
		}
		
		System.out.println(times);
		
		scan.close();
	}
	
	static void printMap() {
		System.out.println("==========================");
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	static void dfs(int x, int y) {
		
		int temp_x, temp_y, temp_value;
		
		//현재값;
		int value = map[y][x];
		
		for(int d=0; d<4; d++) {
			
			temp_x = x + dx[d];
			temp_y = y + dy[d];
			
			if(temp_x>=0 && temp_x<N && temp_y>=0 && temp_y<N && visited[temp_y][temp_x] == false) {
				
				temp_value = map[temp_y][temp_x];
				
				if(Math.abs(value - temp_value) >= L && Math.abs(value - temp_value) <= R) {
					
//					System.out.println("diff : " + Math.abs(value-temp_value));
					
					sum += temp_value;
					visited[temp_y][temp_x] = true;
					connectedList.add(new Point(temp_x, temp_y));
					dfs(temp_x, temp_y);
				}
			}
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