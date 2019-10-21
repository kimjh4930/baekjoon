package bfs.b_2933;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static char[][] map = new char[101][101];
	static boolean[][] visited = new boolean[101][101];
	
	static int[] dx = {0, 1, 0, -1,};
	static int[] dy = {-1, 0, 1, 0};
	
	static int R, C, times;
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	public static void main(String args[]) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		R = scan.nextInt();
		C = scan.nextInt();
		scan.nextLine();
		
		String input;
		
		for(int i=1; i<=R; i++) {
			input = scan.nextLine();
			for(int j=1; j<=C; j++) {
				map[i][j] = input.charAt(j-1);
			}
		}
		
		times = scan.nextInt();
		int num = 0;
		int count = 0;
		
		for(int i=0; i<times; i++) {
			num = scan.nextInt();
			count = 0;
			
			removeMineral(num);
			//drop iceberg
			
			for(int y=1; y<=R; y++) {
				for(int x=1; x<=C; x++) {
					if(map[y][x] == 'x' && visited[y][x] == false) {
						count++;
						visited[y][x] = true;
						queue.offer(new Point(x, y));
						
						bfs();
					}
				}
			}
			
			printMap();
		}
		
		
		scan.close();
	}
	
	static void removeMineral (int n) {
		
		int idx = R-n+1;
		
		for(int i=1; i<=C; i++) {
			map[idx][i] = '.';
		}
	}
	
	//덩어리가 몇개인지 확인하기 위함.
	static void bfs () {
		
		Point p;
		int tx, ty;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=0; i<4; i++) {
				tx = p.x + dx[i];
				ty = p.y + dy[i];
				
				if(checkRange(tx, ty) && visited[ty][tx] == false) {
					visited[ty][tx] = true;
					tempQueue.offer(new Point(tx, ty));
				}
			}
			
			if(queue.isEmpty()) {
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		
	}
	
	static boolean checkRange (int x, int y) {
		if(x >=1 && x <=C && y >=1 && y<=R) {
			return true;
		}
		return false;
	}
	
	static void printMap() {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("==========================");
	}

}

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.x = y;
	}
}
