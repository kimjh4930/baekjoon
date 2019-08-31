package b_15685;

import java.util.Scanner;

public class Main {
	
	static boolean map[][] = new boolean[101][101];
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, -1, 0, 1};
	
	static int N;
	
	static int generation[] = new int[2048];
	static int X, Y, D, G;
	static int count = 0;
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		setGeneration();
		
		int temp_x, temp_y;
		
		N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			
			X = scan.nextInt();
			Y = scan.nextInt();
			D = scan.nextInt();
			G = scan.nextInt();
			
			int index = 1;
			
			temp_x = X;
			temp_y = Y;
			
			for(int g=0; g<G; g++) {
				index *= 2;
			}
			
			map[Y][X] = true;
			
			for(int j=0; j<index; j++) {
				temp_x += dx[(generation[j] + D) % 4];
				temp_y += dy[(generation[j] + D) % 4];
				
				map[temp_y][temp_x] = true;
			}
			
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] == true && map[i+1][j] == true && map[i][j+1] == true && map[i+1][j+1]== true) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		scan.close();
		
	}
	
	static void setGeneration() {
		int init = 1;
		
		generation[0] = 0;
		
		for(int i=1; i<=10; i++) {
			for(int j=init, k=init-1; j<init*2; j++, k--) {
				generation[j] = (generation[k]+1)%4;
			}
			init *= 2;
		}
	}
	
	static void printMap () {
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j] == true) {
					System.out.print("1 ");
				}else {
					System.out.print("0 ");
				}
			}
			System.out.println("");
		}
	}

}

class Point {
	int x, y, d, g;
	
	public Point (int x, int y, int d, int g) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.g = g;
	}
}
