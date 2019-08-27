package b_14889;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<int[]> combiList = new ArrayList<>();
	
	static List<Integer> home = new ArrayList<>();
	static List<Integer> away = new ArrayList<>();
	
	static int[][] map = new int[20][20];
	static boolean[] divide = new boolean[20];
	static int N;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[j][i] = scan.nextInt();
			}
		}
		
		int min = (1<<31)-1;
		int home_score = 0;
		int away_score = 0;
		int diff = 0;
		
		int arr[] = new int[N/2];
		combination(arr, 0, N, N/2, 0);
		
		for(int[] combi : combiList) {
			for(int i=0; i<N/2; i++) {
				divide[combi[i]] = true;
				home.add(combi[i]);
			}
			
			home_score = getTotalScore(home);
			
			for(int i=0; i<N; i++) {
				if(divide[i] == false) {
					away.add(i);
				}
			}
			
			away_score = getTotalScore(away);
			
			diff = Math.abs(home_score - away_score);
			
			if(min > diff) {
				min = diff;
			}
			
			//clear
			for(int i=0; i<20; i++) {
				divide[i] = false;
			}
			home.clear();
			away.clear();
		}
		
		System.out.println(min);
		
		scan.close();
	}
	
	static int getTotalScore (List<Integer> team) {
		
		int size = team.size();
		int score = 0;
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(i != j) {
					score += map[team.get(i)][team.get(j)];
				}
			}
		}
		
		return score;
		
	}
	
	static void combination(int[] arr, int arrSize, int n, int r, int index) {
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
