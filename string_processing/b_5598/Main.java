package string_processing.b_5598;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int length = input.length();
		
		String result = "";
		
		for(int i=0; i<length; i++) {
			switch(input.charAt(i)) {
			case 'A':
				result += 'X';
				break;
			case 'B':
				result += 'Y';
				break;
			case 'C' :
				result += 'Z';
				break;
			default:
				result += (char)(input.charAt(i) - 3);	
			}
		}
		
		System.out.println(result);
		
		scan.close();
	}

}
