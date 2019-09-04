package b_7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[301][301];
	
	static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
 	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static int T, size, count=0;
	
	static Point start, end;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		T = scan.nextInt();
		
		start = new Point(0,0);
		end = new Point(0,0);
		
		for(int t=0; t<T ; t++) {
			size = scan.nextInt();
			
			start.x = scan.nextInt();
			start.y = scan.nextInt();
			end.x = scan.nextInt();
			end.y = scan.nextInt();
			
			queue.add(start);
			map[start.y][start.x] = -1;
			
			if(map[end.y][end.x] == 0) {
				count++;
				bfs();
			}
			
			System.out.println(count);
			
			count = 0;
			
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					map[i][j] = 0;
				}
			}
		}
		
		scan.close();
	}
	
	static void bfs () {
		Point p;
		int temp_x, temp_y;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=0; i<8; i++) {
				temp_x = p.x + dx[i];
				temp_y = p.y + dy[i];
				
				if(temp_x>=0 && temp_x<size && temp_y>=0 && temp_y<size) {
					if(map[temp_y][temp_x] == 0 ) {
						map[temp_y][temp_x] = -1;
						tempQueue.add(new Point(temp_x, temp_y));
					}
				}
			}
			
			if(queue.isEmpty()) {
				
				if(map[end.y][end.x] == -1) {
					queue.clear();
					tempQueue.clear();
					break;
				}
				
				count++;
				queue.addAll(tempQueue);
				tempQueue.clear();
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
