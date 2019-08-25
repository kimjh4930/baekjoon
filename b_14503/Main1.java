package b_14503;

import java.util.Scanner;

public class Main1 {
	
	static int map[][] = new int[50][50];
	
	static int[] dx = {0, 1, 0, -1};	//북동남서;
	static int[] dy = {1, 0, -1, 0};
	
	static int N, M;
	static int r, c, d;
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();		//세로.
		M = scan.nextInt();		//가로.
		
		r = scan.nextInt();
		c = scan.nextInt();
		d = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		//청소를 시작한다.
		int count = cleanRoom(c, r);
		
		System.out.println("result : " + count);
		
		scan.close();
		
	}
	
	static int cleanRoom (int cx, int cy) {
		int cleaned = 0;
		int x = cx, y = cy;
		int temp_x, temp_y;
		int i = 0;
		
		next_block :
		while(true) {
			
			System.out.println("i : " + i);
			System.out.println("x,y,d : (" + y + "," + x + "," + d + ")");
			
			//현재위치를 청소한다.
			map[x][y] = 2;
			cleaned++;
			i = 0;
			
			printMap();
			
			//현재바라보는 위치에서 왼쪽을 청소한다.
			//한바퀴 회전한다.
			//횟수만 확인하는 용도.
			for(; i<4; i++) {
				temp_x = x + dx[(d+3)%4];
				temp_y = y + dy[(d+3)%4];
				System.out.println("(" + temp_y + "," + temp_x + ")");
				
				if(temp_x>=0 && temp_x<M && temp_y>=0 && temp_y<N) {
					//일단 회전한다.
					d++;
					
					if(d == 4) {
						d = 0;
					}
					
					if(map[temp_y][temp_y] == 0) {	
						//왼쪽방향이 청소되어있지 않은 경우.
						//방향을 돌리고 청소되어있지 않은 위치로 이동한다.
						x = temp_x;
						y = temp_y;
						
						continue next_block;
					}
				}
			}
			
			//모든 방향이 청소됐는지 확인한 경우. 뒤가 벽인경우 while문을 중료한다.
			if(i == 4) {
				if(map[x+dx[(d+2)%4]][y+dy[(d+2)%4]] == 1) {
					break;
				}else {
					x = x + dx[(d+2)%4];
					y = y + dy[(d+2)%4];
				}
			}
		}

		return cleaned;
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

//class Point {
//	int x, y, d;
//	
//	public Point(int x, int y, int d) {
//		this.x = x;
//		this.y = y;
//		this.d = d;
//	}
//}