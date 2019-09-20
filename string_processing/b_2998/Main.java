package string_processing.b_2998;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int length = input.length();
	
		String octa = "";
		
		if(length % 3 != 0) {
			if(length % 3 == 1) {
				input = "00" + input;
			}else {
				input = "0" + input;
			}
		}
		
		int octaInt = 0;
		int num;
		
		for(int i=0; i<input.length(); i += 3) {
			
			num = 4;
			octaInt = 0;
			
			for(int j=0; j<3; j++) {
				octaInt += (input.charAt(i+j)-'0')*num;
				num /= 2;
			}			
			
			octa += octaInt;
		}
		
		System.out.println(octa);
		
		scan.close();
	}
}
