package b_17142;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[50][50];
	static int[][] tempMap = new int[50][50];
	static boolean[][] visited = new boolean[50][50];
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static List<int[]> combiList = new ArrayList<>();
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> tempQueue = new LinkedList<>();
	
	static List<Point> virusList = new ArrayList<>();
	
	static int N, M;
	
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		int room = 0;
		
		//입력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = scan.nextInt();
				
				if(map[i][j] == 2) {
					virusList.add(new Point(j, i));
				}else if (map[i][j] == 0) {
					room++;
				}
			}
		}
		
		if(room == 0) {
			System.out.println(0);
		}else {
			
			int arr[] = new int[M];
			combination(arr, 0, virusList.size(), M, 0);
			
			int min = 100000;
			int count = 0;
			
			//combination
			for(int[] combi : combiList) {
				
				//복사
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						tempMap[i][j] = map[i][j];
						visited[i][j] = false;
					}
				}
				
				queue.clear();
				tempQueue.clear();
				
				for(int i=0; i<M; i++) {
					queue.add(virusList.get(combi[i]));
					visited[virusList.get(combi[i]).y][virusList.get(combi[i]).x] = true;
				}
				
				count = bfs(room);
				
				if(min > count) {
					min = count;
				}
			}
			
			if(min == 100000) {
				System.out.println(-1);
			}else {
				System.out.println(min);
			}
		}
		
		scan.close();
	}
	
	static int bfs (int r) {
		int temp_x, temp_y;
		Point v;
		int count = 0;
		int room = r;
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			
			for(int i=0; i<4; i++) {
				temp_x = v.x + dx[i];
				temp_y = v.y + dy[i];
				
				if(temp_x >= 0 && temp_x<N && temp_y>=0 && temp_y < N) {
					if(visited[temp_y][temp_x] == false && tempMap[temp_y][temp_x] != 1) {
						tempQueue.add(new Point(temp_x, temp_y));
						visited[temp_y][temp_x] = true;
						
						if(tempMap[temp_y][temp_x] == 0) {
							room--;
						}
						tempMap[temp_y][temp_x] = 3;
					}
				}
			}
			
			
			if(queue.isEmpty()) {
				count++;
				if(!tempQueue.isEmpty()) {
					queue.addAll(tempQueue);
					tempQueue.clear();
				}
				
				if(room == 0) {
					break;
				}
			}
		}
		
		if(room != 0) {
			count = 100000;
		}
		
		return count;
	}
	
	static void printMap() {
		System.out.println("=========================");
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(tempMap[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	static void combination(int arr[], int arrSize, int n, int r, int index) {
		
		if(arrSize == r) {
			combiList.add(arr.clone());
			return;
		}
		
		if(index == n) {
			return;
		}
		
		arr[arrSize] = index;
		combination(arr, arrSize+1, n, r, index+1);
		combination(arr, arrSize, n, r, index+1);
		
	}

}

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
