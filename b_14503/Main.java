package b_14503;

import java.util.Scanner;

public class Main {
	
	static int map[][] = new int[50][50];
	
	static int[] dx = {0, 1, 0, -1};	//북동남서;
	static int[] dy = {-1, 0, 1, 0};
	
	static int N, M;
	static int r, c, d;
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();		//세로.
		M = scan.nextInt();		//가로.
		
		r = scan.nextInt();		//y
		c = scan.nextInt();		//x
		d = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		//청소를 시작한다.
		int count = cleanRoom(c, r);
		
		System.out.println(count);
		
		scan.close();
		
	}
	
	static int cleanRoom (int cx, int cy) {
		int x = cx, y = cy;
		int temp_x, temp_y;
		int count = 0;
		int i=0;
		
		next_block : 
		while(true) {
			//현재 위치를 청소한다.
			
			if(map[y][x] == 0) {
				count++;
			}
			map[y][x] = 2;
			temp_x = temp_y = 0;
			i=0;
			
//			printMap();
			
			for(;i<4; i++) {
				temp_x = x + dx[(d+3)%4];
				temp_y = y + dy[(d+3)%4];
				
				if(temp_x>=0 && temp_x<M && temp_y>=0 && temp_y<N) {
//					System.out.println("d, next_d : (" + d + "," + ((d+3)%4) + ")");
					d = (d+3)%4;
					if(map[temp_y][temp_x] == 0) {
//						System.out.println("(" + temp_y + "," + temp_x + "," + d + ")");
						x = temp_x;
						y = temp_y;
						continue next_block;
					}
				}
			}
			
			//모든 곳을 청소한 경우.
			if(i == 4) {
				if(map[y+dy[(d+2)%4]][x+dx[(d+2)%4]] == 1) {
					break;
				}else {
					x = x + dx[(d+2)%4];
					y = y + dy[(d+2)%4];
				}
			}
		}
		
		return count;
	}
	
	static void printMap () {
		System.out.println("==============================");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}

}

class Point {
	int x, y, d;
	
	public Point(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}