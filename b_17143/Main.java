package b_17143;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int R, C, M;
	static int[] x_index, y_index;
	static int x_size, y_size;
	
	static Shark[][] map = new Shark[101][101];
	
//	static List<Shark> sharkList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		R = scan.nextInt();	//y
		C = scan.nextInt(); //x
		M = scan.nextInt();	//상어 마리.
		
		int r, c, s, d, z;
		
		//set index;
		x_index = new int[C*2 -1];
		y_index = new int[R*2 -1];
		
		x_size = C*2-2;
		y_size = R*2-2;
		
		for(int i=1, j=2; i<=x_size; i++) {
			if(i<=C) {
				x_index[i] = i;
			}else {
				x_index[i] = i-j;
				j+=2;
			}
		}
		
		for(int i=1, j=2; i<=y_size; i++) {
			if(i<=R) {
				y_index[i] = i;
			}else {
				y_index[i] = i-j;
				j+=2;
			}
		}
		
		//map 설정;
		
		for(int i=0; i<M; i++) {
			r = scan.nextInt();
			c = scan.nextInt();
			s = scan.nextInt();
			d = scan.nextInt();
			z = scan.nextInt();
			
			map[r][c] = new Shark(r, c, s, d, z);
		}
		
		int king = 0;
		int score = 0;
		
		List<Shark> sharkList = new ArrayList<>();
		
		while(king < C) {
			//낚시왕이 오른쪽으로 이
			king++;
			
			//잡을 수 있는 상어 탐색.
			for(int y=1; y<=R; y++) {
				if(map[y][king] == null) {
					continue;
				}
				
				score += map[y][king].size;
				map[y][king] = null;
				break;
			}
			
			//상어 이동
			for(int y=1; y<=R; y++) {
				for(int x=1; x<=C; x++) {
					if(map[y][x] == null) {
						continue;
					}
					map[y][x].move();
					sharkList.add(map[y][x]);
				}
			}
			
			//clear;
			for(int y=1; y<=R; y++) {
				for(int x=1; x<=C; x++) {
					map[y][x] = null;
				}
			}
			
			//재배치
			for(Shark shark : sharkList) {
				if(map[shark.y][shark.x] != null) {
					if(map[shark.y][shark.x].size < shark.size) {
						map[shark.y][shark.x] = shark;
					}
				}else {
					map[shark.y][shark.x] = shark;
				}
			}
			
//			print(king);
			sharkList.clear();
		}
		
		System.out.println(score);
		
		scan.close();
	}
	
	static void print (int n) {
		System.out.println("============  "+ n + "  ===========");
		for(int y=1; y<=R; y++) {
			for(int x=1; x<=C; x++) {
				if(map[y][x] == null) {
					System.out.print("- ");
				}else {
					System.out.print("o ");
				}
			}
			System.out.println("");
		}
	}
}

class Shark {
	int x, y, direction, v, size;
	int index;

	public Shark(int r, int c, int s, int d, int z) {
		this.x = c;
		this.y = r;
		this.v = s;
		this.direction = d;
		this.size = z;
		
		switch(d) {
		case 1:
		case 2:
			index = y;
			break;
		case 3:
		case 4:
			index = x;
			break;
		}
	}
	
	public void move () {
		int m;
		switch (direction) {
		case 1:	//y가 마이너스.
			m = v % Main.y_size;
			index -= m;
			if(index <= 0) {
				index += Main.y_size;
			}
			y = Main.y_index[index];
			break;
		case 2:	//y가 플러스.
			m = v % Main.y_size;
			index += m;
			if(index > Main.y_size) {
				index -= Main.y_size;
			}
			y = Main.y_index[index];
			break;
		case 3:	//x가 플러스.
			m = v % Main.x_size;
			index += m;
			if(index >Main.x_size) {
				index -= Main.x_size;
			}
			x = Main.x_index[index];
			break;
		case 4://x가 마이너스.
			m = v % Main.x_size;
			index -= m;
			if(index <=0 ) {
				index += Main.x_size;
			}
			x = Main.x_index[index];
			break;
		}
	}
}
