package b_17135;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<int[]> combiList = new ArrayList<>();
	static int N, M, D;
	static int map[][][] = new int[2][15][15];
	static List<Point> killedList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		D = scan.nextInt();
		
		//입력받는다.
		for(int y=0; y<N; y++) {
			for(int x=0;x<M; x++) {
				map[0][y][x] = scan.nextInt();
			}
		}
		
		//combi
		int arr[] = new int[3];
		combination(arr, 0, M, 3, 0);
		int size, max=-1, count=0;
		
		for(int[] combi : combiList) {
			for(int y=N-1; y>=0; y--) {
				size = combi.length;
				for(int i=0; i<size; i++) {
					attack (y, combi[i]);
				}
				
				//죽인 적들 체크.
				for(Point p : killedList) {
					map[1][p.y][p.x] = 1;
				}
				killedList.clear();
			}
			//몇마리 죽였는지 확인.
			for(int y=0; y<N; y++) {
				for(int x=0; x<M; x++) {
					if(map[1][y][x] == 1){
						count++;
					}
					//확인하고 초기화
					map[1][y][x] = 0;
				}
			}
			
			if(count > max) {
				max = count;
			}
			
			//초기화
			count = 0;
		}
		
		System.out.println(max);
		
		
		scan.close();
	}
	
	static void attack (int y, int x) {
		
		int temp_x, temp_y, j;
		
		for(int d=0; d<D; d++) {
			j = 1;
			for(temp_x = x-d; temp_x<=x+d; temp_x++) {
				if(temp_x <= x) {
					j--;
				}else {
					j++;
				}
				temp_y = y + j;
				
				if(temp_x >=0 && temp_x < M && temp_y >= 0 && temp_y < N) {
					if(map[0][temp_y][temp_x] == 1 && map[1][temp_y][temp_x] == 0) {
						killedList.add(new Point(temp_x, temp_y));
						return;
					}
				}
			}
		}
	}
	
	static void combination(int[] arr, int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			combiList.add(arr.clone());
			return;
		}
		
		if(n == index){
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
