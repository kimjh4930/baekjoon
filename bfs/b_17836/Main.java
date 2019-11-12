package bfs.b_17836;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[101][101];
	static boolean[][][] visited = new boolean[2][101][101];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int N, M, T;
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		T = scan.nextInt();
		
		for(int i=1; i<=N; ++i) {
			for(int j=1; j<=M; ++j) {
				map[i][j] = scan.nextInt();
			}
		}
		
		visited[0][1][1] = true;
		queue.add(new Point(1, 1, false));
		
		int resultTime = bfs();
		
		if(resultTime == -1 ) {
			System.out.println("Fail");
		}else {
			if(resultTime > T) {
				System.out.println("Fail");
			}else {
				System.out.println(resultTime);
			}
		}
		
		
		scan.close();
	}
	
	static int bfs () {
		
		Point p;
		int tx, ty;
		int time = 0;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=0; i<4; i++) {
				tx = p.x + dx[i];
				ty = p.y + dy[i];
				
				if(checkRange(tx, ty)) {
					
					if(p.hasSword == true) {
						//검을 갖고 있는 경
						if(visited[1][ty][tx] == false) {
							
							if(tx == M && ty == N) {
								time++;
								return time;
							}
							
							visited[1][ty][tx] = true;
							tempQueue.add(new Point(tx, ty, true));
						}
					}else {
						//검을 갖고 있지 않을 경우 그냥 계속 진행한다.
						if(map[ty][tx] != 1 && visited[0][ty][tx] == false) {
							
							if(tx == M && ty == N) {
								time++;
								return time;
							}
							
							visited[0][ty][tx] = true;
							
							if(map[ty][tx] == 2) {
								visited[1][ty][tx] = true;
								tempQueue.add(new Point(tx, ty, true));
							}else {
								tempQueue.add(new Point(tx, ty, false));
							}
						}
					}
				}
			}
			
			if(queue.isEmpty()) {
				
//				printMap();
				
				if(time >= T) {
					return -1;
				}
				
				queue.addAll(tempQueue);
				tempQueue.clear();
				time++;
			}
		}
		
		return -1;
	}
	
	static boolean checkRange(int x, int y) {
		if(x>=1 && x<=M && y>=1 && y<=N) {
			return true;
		}
		return false;
	}
	
	static void printMap () {
		
		System.out.println("============================");
		for(int i=1; i<=N; ++i) {
			for(int j=1; j<=M; ++j) {
				if(visited[0][i][j] == true) {
					System.out.print(1 + " ");
				}else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
		
		System.out.println("=========sword==============");
		for(int i=1; i<=N; ++i) {
			for(int j=1; j<=M; ++j) {
				if(visited[1][i][j] == true) {
					System.out.print(1 + " ");
				}else {
					System.out.print(0 + " ");
				}
			}
			System.out.println("");
		}
		
		System.out.println("\n\n");
		
	}

}

class Point {
	int x, y;
	boolean hasSword;
	
	public Point(int x, int y, boolean hasSword) {
		this.x = x;
		this.y = y;
		this.hasSword = hasSword;
	}
}
