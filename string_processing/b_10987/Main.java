package string_processing.b_10987;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int length = input.length();
		char c;
		int count = 0;
		
		for(int i=0; i<length; i++) {
			c = input.charAt(i);
			
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				count++;
			}
		}
		
		System.out.println(count);
		
		scan.close();
	}

}
