package b_2468;

import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[100][100];
	static int[][] tempMap = new int[100][100];
	static boolean[][] visited = new boolean[100][100];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int N;
	static int maxHeight = -1;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		int height_count = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = scan.nextInt();
				
				//최대높이 설정.
				if(map[i][j] >= maxHeight) {
					maxHeight = map[i][j];
					height_count++;
				}
			}
		}

		if(height_count == N * N) {
			System.out.println(1);
		}else {
			int count = 0;
			int maxCount = -1;
			
			for(int h=1; h<=maxHeight; h++) {
				
				//copy
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						tempMap[i][j] = map[i][j];
						visited[i][j] = false;
					}
				}
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(visited[i][j] == false && tempMap[i][j] > h) {
							dfs(j, i, h);
							count++;
						}
					}
				}
				
				if(count > maxCount) {
					maxCount = count;
				}
				
				//초기화.
				count = 0;
			}
			
			System.out.println(maxCount);
		}
		
		scan.close();
	}
	
	static void dfs(int x, int y, int h) {
		int temp_x, temp_y;
		
		visited[y][x] = true;
		
		for(int i=0; i<4 ;i++) {
			temp_x = x + dx[i];
			temp_y = y + dy[i];
			
			if(temp_x>=0 && temp_x<N && temp_y>=0 && temp_y<N) {
				if(visited[temp_y][temp_x] == false && tempMap[temp_y][temp_x] > h) {
					dfs(temp_x, temp_y, h);
				}
			}
		}
	}

}
