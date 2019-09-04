package b_2583;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[101][101];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	static int M, N, K;
	
	static int room = 0;
	static int divide = 0;
	
	static List<Integer> sizeList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		M = scan.nextInt();
		N = scan.nextInt();
		K = scan.nextInt();
		
		int x1, y1, x2, y2;
		
		for(int i=0; i<K; i++) {
			
			x1 = scan.nextInt();
			y1 = scan.nextInt();
			x2 = scan.nextInt();
			y2 = scan.nextInt();
			
			for(int y=y1; y<y2; y++) {
				for(int x=x1; x<x2; x++) {
					map[y][x] = 1;
				}
			}
			
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) {
					
					room++;
					map[i][j] = -1;
					dfs(j, i);
					
					sizeList.add(room);
					room=0;
					divide++;
				}
			}
		}
		
		
		String result = "";
		result += divide + "\n";
		
		sizeList.sort(new SortList());
		
		for(int i=0; i<sizeList.size(); i++) {
			result += sizeList.get(i) + " ";
		}
		
		System.out.println(result);
		
		scan.close();
	}
	
	static void dfs (int x, int y) {
		
		int temp_x, temp_y;

		for(int i=0; i<4; i++) {
			temp_x = x + dx[i];
			temp_y = y + dy[i];
			
			if(temp_x>=0 && temp_x<N && temp_y>=0 && temp_y<M) {
				if(map[y+dy[i]][x+dx[i]] == 0) {
					map[y+dy[i]][x+dx[i]] = -1;
					room++;
					
					dfs(x+dx[i], y+dy[i]);
				}
			}
		}
	}
}

class SortList implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 > o2 ? 1 : -1;
	}
	
}