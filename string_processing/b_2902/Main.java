package string_processing.b_2902;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int length = input.length();
		
		String result = "";
		result += input.charAt(0);
		
		for(int i=1; i<length; i++) {
			if(input.charAt(i) == '-') {
				result += input.charAt(i+1);
			}
		}
		
		System.out.println(result);
		
		scan.close();
	}

}
