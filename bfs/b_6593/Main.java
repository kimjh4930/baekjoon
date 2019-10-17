package bfs.b_6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static char[][][] map = new char[30][30][30];
	
	static int[] dx = {0, 1, 0, -1, 0, 0};
	static int[] dy = {-1, 0, 1, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static int x, y, z;
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			z = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			if(x == 0 && y == 0 && z == 0) {
				break;
			}
			
			Point start = null;
			
			String input;
			
			for(int i=0; i<z; i++) {
				for(int j=0; j<y; j++) {
					input = br.readLine();
					for(int k=0; k<x; k++) {
						if('S' == input.charAt(k)) {
							map[i][j][k] = '#';
							start = new Point(k, j, i);
						}else {
							map[i][j][k] = input.charAt(k);
						}
					}
				}
				br.readLine();
			}
			
			queue.add(start);
			
			int result = bfs();
			
			if(result == -1) {
				System.out.println("Trapped!");
			}else {
				System.out.println("Escaped in " + result + " minute(s).");
			}
			
			//clear
			for(int i=0; i<z; i++) {
				for(int j=0; j<y; j++) {
					for(int k=0; k<x; k++) {
						map[i][j][k] = '0';
					}
				}
			}
			queue.clear();
			tempQueue.clear();
		}
	}
	
	static int bfs () {
		
		Point p;
		int tx, ty, tz;
		
		int count = 1;
		
		while(!queue.isEmpty()) {
			
			p = queue.poll();
			
			for(int i=0; i<6; i++) {
				tx = p.x + dx[i];
				ty = p.y + dy[i];
				tz = p.z + dz[i];
				
				if(checkRange(tx, ty, tz) && map[tz][ty][tx] != '#') {
					if(map[tz][ty][tx] == '.') {
						map[tz][ty][tx] = '#';
						tempQueue.add(new Point(tx, ty, tz));
					}else if(map[tz][ty][tx] == 'E') {
						return count;
					}
				}
			}
			
			if(queue.isEmpty()) {
				count++;
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		if(queue.isEmpty()) {
			
			return -1;
		}else {
			return count;
		}
		
	}
	
	static boolean checkRange (int tx, int ty, int tz) {
		if(tx >= 0 && tx < x && ty >= 0 && ty < y && tz >= 0 && tz < z) {
			return true;
		}
		return false;
	}

}

class Point {
	int x, y, z;
	
	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
