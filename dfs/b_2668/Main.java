package dfs.b_2668;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static int[][] map = new int[101][101];
	static boolean[] visited = new boolean[101];
	
	static Set<Integer> numberSet = new HashSet<Integer>();
	
	static int N;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		for(int i=1; i<=N; i++) {
			map[0][i] = i;
			map[1][i] = scan.nextInt();
			numberSet.add(map[1][i]);
		}
		
		for(int i=1; i<=N; i++) {
			dfs(i);
		}
		
		scan.close();
	}
	
	static void dfs (int start) {
		
		//숫자를 포함하지 않으면 return;
		if(!numberSet.contains(start)) {
			return;
		}
		
	}

}
