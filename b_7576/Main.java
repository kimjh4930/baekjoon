package b_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[1001][1001];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static int N, M, count=0, time=-1;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		M = scan.nextInt();
		N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = scan.nextInt();
				
				if(map[i][j] == 0) {
					count++;
				}else if(map[i][j] == 1) {
					queue.add(new Point(j, i));
				}
			}
		}
		
		bfs();
		
		System.out.println(time);
		
		scan.close();
	}
	
	static void bfs () {
		Point p;
		int temp_x, temp_y;
		
		while(!queue.isEmpty()) {
			
			p = queue.poll();
			
			for(int i=0; i<4 ;i++) {
				temp_x = p.x + dx[i];
				temp_y = p.y + dy[i];
				
				if(temp_x>=0 && temp_x<M && temp_y>=0 && temp_y<N) {
					if(map[temp_y][temp_x] == 0) {
						tempQueue.add(new Point(temp_x, temp_y));
						map[temp_y][temp_x] = 1;
						count--;
					}
				}
			}
			
			if(queue.isEmpty()) {
				queue.addAll(tempQueue);
				tempQueue.clear();
				time++;
			}
		}
		
		if(count > 0) {
			time = -1;
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
