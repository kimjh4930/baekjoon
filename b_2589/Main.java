package b_2589;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static char[][] map = new char[50][50];
	static boolean[][] start = new boolean[50][50];
	static boolean[][] visited = new boolean[50][50];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static int N, M;
	static int max = -1;
	static int count = 0;
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		
		String input = "";
		
		for(int i=0; i<N; i++) {
			input = scan.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'L') {
					clearVisited();
					count = 0;
					
					queue.add(new Point(j, i));
					visited[i][j] = true;
//					count++;
					
					bfs();
					
					if(count > max) {
						max = count;
					}
				}
			}
		}
		
		System.out.println(max);
		
//		printMap();
		
		scan.close();
	}
	
	static void clearVisited () {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = false;
			}
		}
		
	}
	
	static void bfs() {
		Point p;
		int temp_x, temp_y;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=0; i<4; i++) {
				temp_x = p.x + dx[i];
				temp_y = p.y + dy[i];
				
				if(temp_x>=0 && temp_x<M && temp_y>=0 && temp_y<N && visited[temp_y][temp_x] == false) {
					if(map[temp_y][temp_x] == 'L') {
						visited[temp_y][temp_x] = true;
						tempQueue.add(new Point(temp_x, temp_y));
					}
				}
			}
			
			if(queue.isEmpty()) {
				if(!tempQueue.isEmpty()) {
					count++;
				}
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
	}
	
	static void printMap () {
		System.out.println("=============================");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
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