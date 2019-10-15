package ss.b_13458;

import java.util.Scanner;

public class Main {
	
	static int N, B, C;
	static int[] classroom;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		classroom = new int[N];
		
		for(int i=0; i<N; i++) {
			classroom[i] = scan.nextInt();
		}
		
		B = scan.nextInt();
		C = scan.nextInt();
		
		int count = 0;
		int remain = 0;
		long sum = 0;
		
		for(int i=0; i<N; i++) {
			count = 0;
			remain = classroom[i] - B;
			count++;
			
			if(remain > 0) {
				count += (remain / C);
				if(remain % C != 0) {
					count++;
				}
			}
			
			sum += count;
		}
		
		System.out.println(sum);
		
		scan.close();
	}

}
