package bfs.b_11559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static char[][] map = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static List<Point> removeList = new ArrayList<>();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<12; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=0; j<6; j++) {
				map[i][j] = input[j];
			}
		}
		
		int count = 0;
		boolean result = false;
		
		while(true) {
			
			result = false;
			
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					//연쇄반응이 없을 때까지 반복한다.
					if(map[i][j] != '.' && visited[i][j] == false) {
						visited[i][j] = true;
						
						Point p = new Point(j, i);
						removeList.add(p);
						queue.offer(p);
						
						result |= bfs(map[i][j]);
					}
				}
			}
		
			//터졌으면 아래로 내린다.
			if(result) {
				arrangeMap();
				clearVisitedMap();
				count++;
			}else {
				break;
			}
		}
		
		System.out.println(count);
		
		br.close();
	}
	
	static boolean bfs (char c) {
		
		Point p;
		int tx, ty;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=0; i<4; i++) {
				tx = p.x + dx[i];
				ty = p.y + dy[i];
				
				if(checkRange(tx, ty) && map[ty][tx] == c && visited[ty][tx] == false) {
					visited[ty][tx] = true;
					Point nextP = new Point(tx, ty);
					removeList.add(nextP);
					tempQueue.offer(nextP);
				}
			}
			
			if(queue.isEmpty()) {
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		//remove;
		
		if(removeList.size() >= 4) {
			for(Point r : removeList) {
				map[r.y][r.x] = '.';
			}
			
			removeList.clear();
			return true;
		}else {
			removeList.clear();
			return false;
		}
	}
	
	static void arrangeMap () {
		
		List<Character> charList = new ArrayList<>();
		
		int index = 0;
		
		for(int j=5; j>=0; j--) {
			
			index = 0;
			
			for(int i=11; i>=0; i--) {
				//아래에서 위로 탐색해서 단어가 나오면 맨 아래로 내린다.
				if(map[i][j] != '.'){
					charList.add(map[i][j]);
					map[i][j] = '.';
				}
			}
			
			for(int i=11; i>=0; i--) {
				if(index < charList.size()) {
					map[i][j] = charList.get(index);
					index++;
				}
			}
			
			charList.clear();
		}
	}
	
	static void clearVisitedMap () {
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	static boolean checkRange (int x, int y) {
		if(x >=0 && x<6 && y>=0 && y<12) {
			return true;
		}
		return false;
	}
	
	static void printMap() {
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				System.out.print(map[i][j]);
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
