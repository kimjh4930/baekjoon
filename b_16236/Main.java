package b_16236;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[20][20];
	static boolean[][] visited = new boolean[20][20];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static List<Point> candiList = new ArrayList<>();
	
	static int N;
	static int age=2, eatCount=0;
	static Point shark;
	static Point tempShark;
	
	static int time=0;
	static int nextTime=0;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = scan.nextInt();
				
				if(map[i][j] == 9) {
					map[i][j] = 0;
					shark = new Point(j, i);
					queue.add(shark);
				}
			}
		}
		
		while(true) {
//			System.out.println("======================");
//			System.out.println("start : (" + shark.x + "," + shark.y + ")");
			tempShark = bfs();
			
			if(tempShark == null) {
//				System.out.println("tempShark is null.");
				break;
			}else {
				time += nextTime;
			}
			
			//먹었음.
			map[tempShark.y][tempShark.x] = 0;
			eatCount++;
			
//			System.out.println("eat : (" + tempShark.x + "," + tempShark.y + ")");
//			System.out.println("age : " + age + "\teatCount : " + eatCount);
			
			if(age == eatCount) {
				age++;
				eatCount=0;
			}
			
			
			//초기화
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited[i][j] = false;
				}
			}
			queue.clear();
			tempQueue.clear();
			candiList.clear();
			
			shark.x = tempShark.x;
			shark.y = tempShark.y;
			
			queue.add(shark);
		}
		
		System.out.println(time);
		
		scan.close();
	}
	
	//먹을 수 있는 먹이 중 가장 가까운 위치로 간다.
	static Point bfs() {
		int temp_x, temp_y;
		Point p;
		Point s = null;
		
		nextTime = 0;
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			visited[p.y][p.x] = true;
			
			for(int i=0; i<4; i++) {
				temp_x = p.x + dx[i];
				temp_y = p.y + dy[i];
				
				if(temp_x >=0 && temp_x<N && temp_y>=0 && temp_y<N && map[temp_y][temp_x] <= age) {
					if(visited[temp_y][temp_x] == false) {
						visited[temp_y][temp_x] = true;
						tempQueue.add(new Point(temp_x, temp_y));

						if(map[temp_y][temp_x] > 0 && map[temp_y][temp_x] < age) {
//							System.out.println("(" + temp_x + "," + temp_y + ")  time : " + time);
							candiList.add(new Point(temp_x, temp_y));
						}
					}
				}
			}
			
			if(queue.isEmpty()) {
				nextTime++;
				if(candiList.isEmpty()) {
					queue.addAll(tempQueue);
					tempQueue.clear();
				}else {
					break;
				}
			}
		}
		
		if(candiList.size() >= 1) {
			if(candiList.size() >= 2) {
				candiList.sort(new SortList());
			}
			s = candiList.get(0);
		}
		
		return s;
	}

}

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class SortList implements Comparator<Point>{

	@Override
	public int compare(Point o1, Point o2) {
		//높이가 같다면.
		if(o1.y == o2.y) {
			//왼쪽것부터 먹는다.
			return o1.x > o2.x ? 1 : -1;
		}
		return o1.y > o2.y ? 1: -1;
	}
	
}
