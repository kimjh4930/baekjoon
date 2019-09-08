package b_2908;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input[] = scan.nextLine().split(" ");
		
		int num[] = new int[2];
		
		for(int i=0; i<2; i++) {
			for(int j=2; j>=0; j--) {
				num[i] += (input[i].charAt(j) - '0');
				if(j != 0) {
					num[i] *= 10;
				}
			}
		}
		
		if(num[0] > num[1]) {
			System.out.println(num[0]);
		}else {
			System.out.println(num[1]);
		}
		
		scan.close();
	}

}
