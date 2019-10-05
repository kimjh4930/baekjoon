package dfs.b_2667;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static char[][] map = new char[25][25];
	static boolean[][] visited = new boolean[25][25];
	
	static List<Integer> resultList = new ArrayList<>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int N;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		scan.nextLine();
		
		String input;
		
		for(int i=0; i<N; i++) {
			input = scan.nextLine();
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] == false && map[i][j] != '0') {
					visited[i][j] = true;
					queue.add(new Point(j, i));
					bfs();
				}
			}
		}
		
		System.out.println(resultList.size());
		resultList.sort(new SortList());
		
		for(Integer i : resultList) {
			System.out.println(i);
		}
		
		scan.close();
	}
	
	static void bfs () {
		Point p;
		int temp_x, temp_y;
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			count++;
			
			for(int i=0; i<4; i++) {
				temp_x = p.x + dx[i];
				temp_y = p.y + dy[i];
				
				if(checkRange(temp_x, temp_y) && map[temp_y][temp_x] != '0' && visited[temp_y][temp_x] == false) {
					visited[temp_y][temp_x] = true;
					tempQueue.add(new Point(temp_x, temp_y));
				}
			}
			
			if(queue.isEmpty()) {
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		resultList.add(count);
	}
	
	static boolean checkRange (int x, int y) {
		if(x>=0 && x<N && y>=0 && y<N) {
			return true;
		}
		return false;
	}

}

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class SortList implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 > o2 ? 1 : -1;
	}
	
}
