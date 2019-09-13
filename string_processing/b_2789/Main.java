package string_processing.b_2789;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		String result = "";
		int length = input.length();
		
		for(int i=0; i<length; i++) {
			switch(input.charAt(i)) {
			case 'C':
			case 'A':
			case 'M':
			case 'B':
			case 'R':
			case 'I':
			case 'D':
			case 'G':
			case 'E':
				break;
			default :
				result += input.charAt(i);	
			}
		}
		
		System.out.println(result);
		
		
		scan.close();
	}

}
