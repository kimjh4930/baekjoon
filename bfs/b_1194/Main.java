package bfs.b_1194;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static char[][] map = new char[51][51];
	static boolean[][][] visited = new boolean[64][51][51];
	
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static int N, M;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		
		String input;
		
		for(int i=1; i<=N; i++) {
			input = scan.nextLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = input.charAt(j-1);
				
				if(map[i][j] == '0') {
					visited[0][i][j] = true;
					map[i][j] = '.';
					queue.add(new Point(j, i, 0));
				}
			}
		}
		
		System.out.println(bfs());
		
		scan.close();
	}
	
	static int bfs () {
		
		Point p;
		int tx, ty, tempkey;
		int time = 0;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=0; i<4; i++) {
				tx = p.x + dx[i];
				ty = p.y + dy[i];
				tempkey = p.keyset;
				
				//keyset이 동일하지 않다
				if(checkRange(tx, ty) && map[ty][tx] != '#' && visited[tempkey][ty][tx] == false) {
					if(map[ty][tx] == '1') {
						time++;
						return time;
					}else if(map[ty][tx] == '.') {
						visited[tempkey][ty][tx] = true;
						tempQueue.add(new Point(tx, ty, tempkey));
					}else if(map[ty][tx] >= 'a' && map[ty][tx] <= 'f') {
						int tk = getKey(tempkey, map[ty][tx]);
						visited[tk][ty][tx] = true;
						tempQueue.add(new Point(tx, ty, tk));
					}else if(map[ty][tx] >= 'A' && map[ty][tx] <= 'F') {
						if(useKey(tempkey, map[ty][tx])) {
							visited[tempkey][ty][tx] = true;
							tempQueue.add(new Point(tx, ty, tempkey));
						}
					}
				}
			}
			
			if(queue.isEmpty()) {
				time++;
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		return -1;
	}
	
	static int getKey (int keyset, char key) {
		return (keyset | 0x01<<(key-'a'));
	}

	static boolean useKey (int keyset, char lock) {
		if( (keyset & 0x01<<(lock-'A')) >> (lock-'A') == 1 ) {
			return true;
		}
		return false;
	}
	
	static boolean checkRange (int x, int y) {
		if(x>=1 && x<=M && y>=1 && y<=N) {
			return true;
		}
		return false;
	}

}

class Point{
	int x, y;
	int keyset;
	
	public Point(int x, int y, int keyset) {
		this.x = x;
		this.y = y;
		this.keyset = keyset;
	}
}
