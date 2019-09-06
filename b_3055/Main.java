package b_3055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static char[][] map = new char[50][50];
	static boolean[][] visited = new boolean[50][50];
	
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	
	static Queue<Point> bqueue = new LinkedList<>();
	static Queue<Point> btqueue = new LinkedList<>();
	
	static Queue<Point> wqueue = new LinkedList<>();
	static Queue<Point> wtqueue = new LinkedList<>();
	
	static int R, C;
	static int count;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		R = scan.nextInt();
		C = scan.nextInt();
		scan.nextLine();
		
		String input;
		
		for(int i=0; i<R; i++){
			input = scan.nextLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
				
				if(map[i][j] == 'S') {
					map[i][j] = '.';
					bqueue.add(new Point(j, i));
					visited[i][j] = true;
				}else if (map[i][j] == '*') {
					wqueue.add(new Point(j, i));
				}
			}
		}
		
//		printMap();
		
		bfs();
		
		if(count == -1) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(count);
		}
		scan.close();
	}
	
	static void bfs () {
		
		Point wp, bp;
		int temp_x, temp_y;
		
		while(!bqueue.isEmpty()) {
			//현재위치에서 물을 지도에 먼저 찍는다.

			bp = bqueue.poll();
			map[bp.y][bp.x] = '.';
			
			while(!wqueue.isEmpty()) {
				wp = wqueue.poll();
				
				for(int i=0; i<4; i++) {
					temp_x = wp.x + dx[i];
					temp_y = wp.y + dy[i];
					
					if(temp_x>=0 && temp_x<C && temp_y>=0 && temp_y<R){
						if(map[temp_y][temp_x] == '.') {
							map[temp_y][temp_x] = '*';
							wtqueue.add(new Point(temp_x, temp_y));
						}
					}
				}
			}
			
			for(int i=0; i<4; i++) {
				temp_x = bp.x + dx[i];
				temp_y = bp.y + dy[i];
				
				if(temp_x>=0 && temp_x<C && temp_y>=0 && temp_y<R){
					if((map[temp_y][temp_x] == '.' || map[temp_y][temp_x] == 'D') && visited[temp_y][temp_x] == false) {
						
						if(map[temp_y][temp_x] == 'D') {
							count++;
							return;
						}
						
						map[temp_y][temp_x] = 'S';
						visited[temp_y][temp_x] = true;
						btqueue.add(new Point(temp_x, temp_y));
					}
				}
			}
			
			if(bqueue.isEmpty()) {
				
//				printMap();
				
				if(!btqueue.isEmpty()) {
					count++;
				}
				
				bqueue.addAll(btqueue);
				btqueue.clear();
				wqueue.addAll(wtqueue);
				wtqueue.clear();
			}
		}
		count = -1;
	}
	
	static void printMap() {
		System.out.println("=========================");
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
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
