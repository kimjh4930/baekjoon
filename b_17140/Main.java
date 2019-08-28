package b_17140;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[][] map = new int[101][101];
	static int R = 3, C = 3;
	static int nextR=3, nextC=3;
	
	static int[] countNum = new int[201];
	
	static List<Number> numberList = new ArrayList<>();
	
	static int r, c, k;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		r = scan.nextInt();
		c = scan.nextInt();
		k = scan.nextInt();
		
		int r_length = 3;
		int c_length = 3;
		
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		int time = 0;
		while(true) {
			if(map[r][c] == k) {
				break;
			}
			if(time > 100) {
				time = -1;
				break;
			}
			
			if(R >= C) {
				operR();
				
				if(nextC > C) {
					C = nextC;
				}
			}else {
				operC();
				
				if(nextR > R) {
					R = nextR;
				}
			}
			
//			printMap();
			
			time++;
			//clear
			for(int i=0; i<=100; i++) {
				countNum[i] = 0;
			}
		}
		
		System.out.println(time);

		scan.close();
	}
	
	static void printMap () {
		System.out.println("==========================");
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	static void operR () {
		
		int i;
		int x, y;
		int size;
		
		for(y=1; y<=R; y++) {
			//행 정보를 정리한다.
			for(x=1; x<=C; x++) {
				countNum[map[y][x]]++;
			}
			
			//sort한다.
			for(i=1; i<=200; i++) {
				if(countNum[i] > 0 ) {
					numberList.add(new Number(i, countNum[i]));
				}
			}
			
			numberList.sort(new SortList());
			//넣는다.
			
			size = numberList.size();
			
			if(size * 2 > nextC) {
				nextC = size * 2;
			}
			
			//clear
			for(i=1; i<=100; i++) {
				map[y][i] = 0;
			}
			for(i=1; i<=200; i++) {
				countNum[i] = 0;
			}
			
			//input
			for(i=1; i<=size; i++) {
				map[y][i*2-1] = numberList.get(i-1).num;
				map[y][i*2] = numberList.get(i-1).times;
			}
			
			numberList.clear();
		}
	}
	
	static void operC () {
		
		int i=0;
		int x, y;
		int size;
		int max = -1;
		
		for(x=1; x<=C; x++) {
			
			//count한다.
			for(y=1; y<=R; y++) {
				countNum[map[y][x]]++;
				
				if(map[y][x] > max) {
					max = map[y][x];
				}
			}
			
			//sort한다.
			for(i=1; i<=max; i++) {
				if(countNum[i] != 0) {
					numberList.add(new Number(i, countNum[i]));
				}
			}
			
			numberList.sort(new SortList());
			
			size = numberList.size();
			
			if(size * 2 > nextR) {
				nextR = size*2;
			}
			
			//clear
			for(i=1; i<=100; i++) {
				map[i][x] = 0;
			}
			for(i=1; i<=200; i++) {
				countNum[i] = 0;
			}
			
			for(i=1; i<=size; i++) {
				map[i*2-1][x] = numberList.get(i-1).num;
				map[i*2][x] = numberList.get(i-1).times;
			}
			
			numberList.clear();
		}
		
	}

}

class SortList implements Comparator<Number> {

	@Override
	public int compare(Number o1, Number o2) {
		// TODO Auto-generated method stub
		if(o1.times == o2.times) {
			return o1.num > o2.num ? 1 : -1;
		}
		return o1.times > o2.times ? 1 : -1;
	}

	
}

class Number {
	int num;
	int times;
	
	public Number (int num, int times) {
		this.num = num;
		this.times = times;
	}
	
	public void increaseTimes () {
		times++;
	}
	
}
