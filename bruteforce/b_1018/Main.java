package bruteforce.b_1018;

import java.util.Scanner;

public class Main {
	
	static char[][] map = new char[51][51];
	static char[][] color = {{'W', 'B'}, {'B', 'W'}};
	static int y, x;
	
	static int N, M;
	static int min = (1<<31)-1;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		
		String line;
		
		for(int i=0; i<N; i++) {
			line = scan.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int count = 0;
		int temp = 0;
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				for(y=0; y<=1; y++) {
					x = 0;
					count = 0;
					temp = y;
					for(int k=i; k<i+8; k++) {
						for(int l=j; l<j+8; l++) {
							if(map[k][l] != color[temp][x]) {
								count++;
							}
							x++;
							x %= 2;
						}
						temp++;
						temp %= 2;
					}
					if(min > count) {
						min = count;
					}
				}
				
			}
		}
		
		System.out.println(min);
		
		scan.close();
	}
}
