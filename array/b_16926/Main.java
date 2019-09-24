package array.b_16926;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static List<Integer> tempList = new ArrayList<>();
	static int[][] map = new int[300][300];
	static Set<Integer> dupSet = new HashSet<>();
	
	static int N, M, turn;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		turn = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = scan.nextInt();
				dupSet.add(map[i][j]);
			}
		}
		
		if(dupSet.size() > 1) {
			turn();
		}
		printMap();
	
		scan.close();
	}
	
	static void turn () {
		int c = 0;
		if(N > M) {
			c = M/2;
		}else {
			c = N/2;
		}
		int x, y;
		int size = 0;
		int realTurn = 0;
		
		for(int t=0; t<c; t++) {
			x = t;
			y = t;
			
			//get
			for(; x<M-1-t; x++) {
				tempList.add(map[y][x]);
			}
			
			for(; y<N-1-t; y++) {
				tempList.add(map[y][x]);
			}
			
			for(; x>t; x--) {
				tempList.add(map[y][x]);
			}
			
			for(; y>t; y--) {
				tempList.add(map[y][x]);
			}
			
			size = tempList.size();
			realTurn = turn % size;
			
			for(; x<M-1-t; x++) {
				map[y][x] = tempList.get((realTurn)%size);
				realTurn++;
			}
			
			for(; y<N-1-t; y++) {
				map[y][x] = tempList.get((realTurn)%size);
				realTurn++;
			}
			
			for(; x>t; x--) {
				map[y][x] = tempList.get((realTurn)%size);
				realTurn++;
			}
			
			for(; y>t; y--) {
				map[y][x] = tempList.get((realTurn)%size);
				realTurn++;
			}
			
			tempList.clear();
		}
	}
	
	static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
