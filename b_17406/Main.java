package b_17406;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<int[]> permutationList = new ArrayList<>();
	static List<Point> pointList = new ArrayList<>();
	static List<Integer> valueList = new ArrayList<>();
	
	static int[][] map = new int[51][51];
	static int[][] tempMap = new int[51][51];
	static int N, M, K;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		K = scan.nextInt();
		
		int arr[] = new int[K];
		
		for(int i=0; i<K; i++) {
			arr[i] = i;
		}
		permutation(arr, 0, K, K);
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		int x, y, r;
		
		for(int i=0; i<K; i++) {
			y = scan.nextInt();
			x = scan.nextInt();
			r = scan.nextInt();
					
			pointList.add(new Point(x, y, r));
		}
		
		Point tempPoint = null;
		int min = 987654321;
		int sum = 0;
		
		for(int[] per : permutationList) {
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					tempMap[i][j] = 0;
					tempMap[i][j] = map[i][j];
				}
			}
			
			for(int i=0; i<per.length; i++) {
				tempPoint = pointList.get(per[i]);
				turnMap(tempPoint.x, tempPoint.y, tempPoint.r);
			}
			
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=M; k++) {
					sum += tempMap[j][k];
				}
				
				if(min > sum) {
					min = sum;
				}
				
				sum = 0;
			}
			
//			printMap(N, M);
		}
		
		System.out.println(min);
		
		scan.close();
	}
	
	static void printMap (int N, int M) {
		System.out.println("==========");
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				System.out.print(tempMap[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	static void turnMap (int x, int y, int range) {
		int temp_x, temp_y, index, size;
		for(int r=1; r<=range; r++) {
			temp_x = x-r;
			temp_y = y-r;
			
			//get value
			
			for(; temp_x<x+r; temp_x++) {
				valueList.add(tempMap[temp_y][temp_x]);
			}
			
			for(; temp_y<y+r; temp_y++) {
				valueList.add(tempMap[temp_y][temp_x]);
			}
			
			for(; temp_x > x-r; temp_x--) {
				valueList.add(tempMap[temp_y][temp_x]);
			}
			
			for(; temp_y > y-r; temp_y--) {
				valueList.add(tempMap[temp_y][temp_x]);
			}
			
			temp_x = x-r;
			temp_y = y-r;
			size = valueList.size();
			index = size-1;
			//set value;
			
			for(; temp_x<x+r; temp_x++) {
				tempMap[temp_y][temp_x] = valueList.get(index%size);
				index++;
			}
			
			for(; temp_y<y+r; temp_y++) {
				tempMap[temp_y][temp_x] = valueList.get(index%size);
				index++;
			}
			
			for(; temp_x > x-r; temp_x--) {
				tempMap[temp_y][temp_x] = valueList.get(index%size);
				index++;
			}
			
			for(; temp_y > y-r; temp_y--) {
				tempMap[temp_y][temp_x] = valueList.get(index%size);
				index++;
			}
			
			valueList.clear();
			
		}
	}
	
	static void permutation(int arr[], int arrSize, int n, int r) {
		if(arrSize == r) {
			permutationList.add(arr.clone());
			return;
		}
		
		for(int i=arrSize; i<n; i++) {
			swapArr(arr, i, arrSize);
			permutation(arr, arrSize+1, n, r);
			swapArr(arr, i, arrSize);
		}
	}
	
	static void swapArr(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}

class Point {
	int x, y, r;
	
	public Point(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
}
