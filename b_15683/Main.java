package b_15683;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[8][8];
//	static boolean[][] visited = new boolean[8][8];
	
	static List<Point> cameraList = new ArrayList<>();
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int[][] cameraStatus = {
			{0},
			{0},
			{0, 2},
			{0, 3},
			{0, 2, 3},
			{0, 1, 2, 3}
	};
	
	static int N, M, min=0x7FFFFFFF;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		boolean visited[][] = new boolean[8][8];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = scan.nextInt();
				
				if(map[i][j] > 0 && map[i][j] < 6) {
					cameraList.add(new Point(j, i, map[i][j]));
				}
				
				if(map[i][j] != 0) {
					visited[i][j] = true;
				}
			}
		}
		
//		printVisited(visited);
		
//		printMap();
		
		//dfs 진행.
		//0번 카메라부터 꺼내서 진행한다.
		
		dfs(0, visited);
		
		System.out.println(min);
		
		scan.close();
	}
	
	static void printMap () {
		System.out.println("==========================");
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	static void printVisited (boolean[][] visited) {
		System.out.println("==========================");
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] == true) {
					System.out.print("# ");
				}else {
					System.out.print("0 ");
				}
			}
			System.out.println("");
		}
	}
	
	static void dfs (int idx, boolean[][] visited) {
		int temp_x, temp_y, add = 0;
		
		boolean tempVisited[][] = new boolean[8][8];
		
		if(idx == cameraList.size()) {
			int count = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j] == false) {
						count++;
					}
				}
			}
			
//			printVisited(visited);
			
			if(min > count) {
				min = count;
			}
			// method를 종료한다.
			return;
		}
		
		Point camera = cameraList.get(idx);
		
		while(add<4) {
			
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					tempVisited[a][b] = visited[a][b];
				}
			}
			
			for(int i=0; i<cameraStatus[camera.status].length; i++) {
				
				temp_x = camera.x;
				temp_y = camera.y;
				
				while(true) {
//					System.out.println("(i+add)%4 : " + ((i+add)%4) );
					
					temp_x += dx[(cameraStatus[camera.status][i] + add)%4];
					temp_y += dy[(cameraStatus[camera.status][i] + add)%4];
					
//					System.out.println("temp : (" + temp_x + "," + temp_y + ")");
					
					if(temp_x>=0 && temp_x<M && temp_y>=0 && temp_y<N && map[temp_y][temp_x] != 6) {
						tempVisited[temp_y][temp_x] = true;
					}else {
						break;
					}
				}
			}
			
			//다음 카메라로 넘어간다.
			dfs(idx+1, tempVisited);
			add++;
		}
	}

}

class Point {
	int x, y, status;
	
	public Point(int x, int y, int status) {
		this.x = x;
		this.y = y;
		this.status = status;
	}
}
