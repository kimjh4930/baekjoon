package string_processing.b_1100;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = "";
		int count = 0;
		
		for(int i=0; i<8; i++) {
			input = scan.nextLine();
			for(int j=0; j<8; j++) {
				if(i % 2 == 0 && j % 2 == 0 && input.charAt(j) == 'F') {
					count++;
				}
				
				if(i % 2 == 1 && j % 2 == 1 && input.charAt(j) == 'F') {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		scan.close();
	}

}
