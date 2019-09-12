package string_processing.b_10988;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		
		int length = input.length();
		
		int result = 1;
		
		if(length % 2 == 0) {
			for(int i=0; i<length/2; i++) {
				if(input.charAt((length/2-1-i)) != input.charAt(length/2+i)) {
					result = 0;
				}
			}
		}else {
			for(int i=0; i<=length/2-1; i++) {
				if(input.charAt(length/2-1-i) != input.charAt(length/2+1+i)) {
					result = 0;
				}
			}
		}
		
		System.out.println(result);
		
		scan.close();
	}
}
