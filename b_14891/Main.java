package b_14891;

import java.util.Scanner;

public class Main {

	static int map[][] = new int[4][8];
	static int curIdx[] = { 0, 0, 0, 0 };
	static int nextIdx[] = { 0, 0, 0, 0 };

	static boolean visited[] = new boolean[4];

	static int[] dx = { -1, 1 };

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		String input = "";

		for (int i = 0; i < 4; i++) {
			input = scan.nextLine();

			for (int j = 0; j < 8; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		int K, circle, direction;

		K = scan.nextInt();

		for (int k = 0; k < K; k++) {
			circle = scan.nextInt();
			direction = scan.nextInt();

			// 선택한 톱니바퀴.
			visited[circle - 1] = true;
			nextIdx[circle - 1] = direction;
			
			dfs(circle-1, nextIdx[circle-1]);

			for (int i = 0; i < 4; i++) {
				curIdx[i] -= nextIdx[i];
				nextIdx[i] = 0;

				if (curIdx[i] > 7) {
					curIdx[i] = 0;
				} else if (curIdx[i] < 0) {
					curIdx[i] = 7;
				}
			}

			// 초기화
			for (int i = 0; i < 4; i++) {
				visited[i] = false;
			}
		}

		// 회전이 끝났을 때;

		int result = 0;
		int mul = 1;

		for (int i = 0; i < 4; i++) {
			if (map[i][curIdx[i]] == 1) {
				result += (1 * mul);
			}
			mul *= 2;
		}

		System.out.println(result);

		scan.close();
	}
	
	static void dfs (int circle, int direction) {
		
		int temp_x;
		
		for(int i=0; i<2; i++) {
			temp_x = circle + dx[i];
			
			if(temp_x >= 0 && temp_x < 4 && visited[temp_x] == false && direction != 0) {
				visited[temp_x] = true;
				
				if(temp_x < circle) {
					if(map[temp_x][(curIdx[temp_x] + 2) % 8] != map[circle][(curIdx[circle] + 6) % 8]) {
						if(direction == 1) {
							nextIdx[temp_x] = -1;
						}else if(direction == -1) {
							nextIdx[temp_x] = 1;
						}else {
							nextIdx[temp_x] = 0;
						}
						
						
					}
					dfs(temp_x, nextIdx[temp_x]);
				}else if (circle < temp_x) {
					if(map[circle][(curIdx[circle] + 2) % 8] != map[temp_x][(curIdx[temp_x] + 6) % 8]) {
						if(direction == 1) {
							nextIdx[temp_x] = -1;
						}else if(direction == -1) {
							nextIdx[temp_x] = 1;
						}else {
							nextIdx[temp_x] = 0;
						}
					}
					dfs(temp_x, nextIdx[temp_x]);
				}
			}
		}
		
	}
	


	static void printMap() {

		System.out.println("========map=======");
		int times = 0;
		for (int i = 0; i < 4; i++) {
			while (times < 8) {
				System.out.print(map[i][(curIdx[i] + times) % 8] + " ");
				times++;
			}
			times = 0;
			System.out.println("");
		}
	}

	static void printIndex() {

		System.out.println("========index=======");

		for (int i = 0; i < 4; i++) {
			System.out.print(curIdx[i] + " ");
		}
		System.out.println("");
		for (int i = 0; i < 4; i++) {
			System.out.print(map[i][curIdx[i]] + " ");
		}
		System.out.println("");
	}
}
