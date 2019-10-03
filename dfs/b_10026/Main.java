package dfs.b_10026;

import java.util.Scanner;

public class Main {
	
	static char[][][] map = new char[2][100][100];
	static boolean[][] visited = new boolean[100][100];
	
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
				map[0][i][j] = input.charAt(j);
				
				if(map[0][i][j] == 'G') {
					map[1][i][j] = 'R';
				}else {
					map[1][i][j] = map[0][i][j];
				}
			}
		}
		
		int normal = 0;
		int abnormal = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					normal++;
					dfs(j, i, true);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				visited[i][j] = false;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					abnormal++;
					dfs(j, i, false);
				}
			}
		}
		
		System.out.println(normal + " " + abnormal);
		
		scan.close();
	}
	
	static void dfs (int x, int y, boolean normal) {
		
		int temp_x, temp_y;
		
		for(int i=0; i<4; i++) {
			temp_x = x + dx[i];
			temp_y = y + dy[i];
			
			if(temp_x>=0 && temp_x<N && temp_y >=0 && temp_y<N && visited[temp_y][temp_x] == false) {
				
				if(normal) {
					if(map[0][y][x] == map[0][temp_y][temp_x]) {
						visited[temp_y][temp_x] = true;
						dfs(temp_x, temp_y, true);
					}
				}else {
					if(map[1][y][x] == map[1][temp_y][temp_x]) {
						visited[temp_y][temp_x] = true;
						dfs(temp_x, temp_y, false);
					}
				}
			}
		}
	}
}
