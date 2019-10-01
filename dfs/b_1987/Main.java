package dfs.b_1987;

import java.util.Scanner;

public class Main {
	
	static char[][] map = new char[20][20];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int R, C;
	static int max = -1;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		R = scan.nextInt();
		C = scan.nextInt();
		scan.nextLine();
		
		String input;
		
		for(int i=0; i<R; i++) {
			input = scan.nextLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		boolean[][] visitedMap = new boolean[20][20];
		boolean[] alpha = new boolean[26];
		
		dfs(0, 0, visitedMap, alpha, 1);
		System.out.println(max);
		
		scan.close();
	}
	
	static void dfs (int x, int y, boolean[][] visitedMap, boolean[] alpha, int count) {
		boolean[][] tempMap = copyMap(visitedMap);
		boolean[] tempAlpha = copyStatus(alpha);
		
		tempMap[y][x] = true;
		tempAlpha[map[y][x] - 'A'] = true;
		
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				if(tempMap[i][j]) {
//					System.out.print("1 ");
//				}else {
//					System.out.print("0 ");
//				}
//			}
//			System.out.println("");
//		}
		
		int cnt = 0;
		
		for(int i=0; i<26; i++) {
			if(tempAlpha[i]) {
				cnt++;
			}
		}
		
		if(cnt == 26) {
			max = 26;
			return;
		}
		
		
		int temp_x, temp_y;
		
		for(int i=0; i<4; i++) {
			temp_x = x + dx[i];
			temp_y = y + dy[i];
			
			if(temp_x>=0 && temp_x<C && temp_y>=0 && temp_y<R && tempMap[temp_y][temp_x] == false) {
				if(tempAlpha[map[temp_y][temp_x] - 'A'] == false) {
					dfs(temp_x, temp_y, tempMap, tempAlpha, count+1);
				}
			}
		}
		
		if(count > max) {
			max = count;
		}
		return;
	}
	
	static boolean[][] copyMap (boolean[][] visitedMap) {
		boolean[][] temp = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				temp[i][j] = visitedMap[i][j];
			}
		}
		
		return temp;
	}
	
	static boolean[] copyStatus (boolean[] alpha) {
		boolean[] temp = new boolean[26];
		
		for(int i=0; i<26; i++) {
			temp[i] = alpha[i];
		}
		
		return temp;
	}
	
	static void printMap () {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
