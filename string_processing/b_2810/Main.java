package string_processing.b_2810;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		scan.nextLine();
		String input = scan.nextLine();
		
		int count = 0;
		int index = 0;
		boolean flag = false;
		
		while(index < input.length()) {
			if(input.charAt(index) == 'S') {
				count++;
				index++;
			}else if(index+1 < input.length() && input.charAt(index) == 'L' && input.charAt(index+1) == 'L') {
				if(flag == false) {
					flag = true;
				}
				count++;
				index+=2;
			}
			
			if(flag == true && index == N) {
				count++;
			}
		}
		
		System.out.println(count);
		
		scan.close();
	}

}
