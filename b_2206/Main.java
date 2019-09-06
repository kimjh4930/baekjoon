package b_2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean visited[][][] = new boolean[2][1001][1001];
	
	static char map[][] = new char[1001][1001];
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int N, M, count = 0;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
				
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		
		String input;
		
		for(int i=1; i<=N; i++) {
			input = scan.nextLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = input.charAt(j-1);
			}
		}
		
		queue.add(new Point(1,1, 0));
		visited[0][1][1] = true;
		count++;
		
		if(!visited[0][N][M] == true) {
			bfs();
		}
//		printMap();
		
		System.out.println(count);
		
				
		scan.close();
	}
	
	static void bfs () {
		Point p;
		int temp_x, temp_y;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
//			System.out.println("(" + p.x + ", " + p.y + ", " + p.b + ")");
			
			for(int i=0; i<4; i++) {
				temp_x = p.x + dx[i];
				temp_y = p.y + dy[i];
				
				if(temp_x>=1 && temp_x<=M && temp_y>=1 && temp_y<=N) {
					
					if(p.b == 0) {
						//벽을 부수고 오지 않음.
						if(visited[0][temp_y][temp_x] == false) {
							if(map[temp_y][temp_x] == '1') {
								visited[1][temp_y][temp_x] = true;
								tempQueue.add(new Point(temp_x, temp_y, 1));
							}else {
								visited[0][temp_y][temp_x] = true;
								tempQueue.add(new Point(temp_x, temp_y, 0));
							}
						}
					}else {
						//이미 벽을 부쉈음.
						if(map[temp_y][temp_x] == '0' && visited[1][temp_y][temp_x] == false) {
							visited[1][temp_y][temp_x] = true;
							tempQueue.add(new Point(temp_x, temp_y, 1));
						}
					}
				}
			}
			
//			printMap();
			
			if(visited[0][N][M] == true || visited[1][N][M] == true) {
				count++;
				return;
			}
			
			if(queue.isEmpty()) {
				count++;
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		if(visited[0][N][M] == false) {
			count = -1;
		}
	}
	
	static void printMap() {
		System.out.println("=========================");
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				System.out.print(visited[0][i][j] + " ");
			}
			System.out.println("");
		}
	}

}

class Point {
	int x, y, b;
	
	public Point(int x, int y, int b) {
		this.x = x;
		this.y = y;
		this.b = b;
	}
}
