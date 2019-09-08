package b_1152;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int length = input.split(" ").length;
		
		if(input.charAt(0) == ' ' && length != 0) {
			length -= 1;
		}
		
		System.out.println(length);
		
		scan.close();
	}

}
