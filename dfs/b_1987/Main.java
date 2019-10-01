package dfs.b_1987;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static char[][] map = new char[20][20];
	static Set<Character> sortSet = new HashSet<>();
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static boolean[][] visitedMap = new boolean[20][20];
	static boolean[] alpha = new boolean[26];
	
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
				sortSet.add(map[i][j]);
			}
		}
		visitedMap[0][0] = true;
		alpha[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
		
		scan.close();
	}
	
	static void dfs (int x, int y, int count) {
		
		if(count > max) {
			max = count;
		}
		
		if(max == sortSet.size()) {
			return;
		}
		
		int temp_x, temp_y;
		
		for(int i=0; i<4; i++) {
			temp_x = x + dx[i];
			temp_y = y + dy[i];
			
			if(temp_x>=0 && temp_x<C && temp_y>=0 && temp_y<R && visitedMap[temp_y][temp_x] == false) {
				if(alpha[map[temp_y][temp_x] - 'A'] == false) {
					alpha[map[temp_y][temp_x] - 'A'] = true;
					visitedMap[temp_y][temp_x] = true;
					dfs(temp_x, temp_y, count+1);
				}
			}
		}
		
		visitedMap[y][x] = false;
		alpha[map[y][x] - 'A'] = false;
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
