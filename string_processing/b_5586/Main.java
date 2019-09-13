package string_processing.b_5586;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		String JOI = "JOI";
		String IOI = "IOI";
		int length = input.length();
		
		int joiCount = 0;
		int ioiCount = 0;
		
		for(int i=0; i<=length-3; i++) {
			for(int j=0; j<3; j++) {
				if(input.charAt(i+j) != JOI.charAt(j)) {
					break;
				}
				
				if(j==2) {
					i += 1;
					joiCount++;
				}
			}
			
			for(int j=0; j<3; j++) {
				if(input.charAt(i+j) != IOI.charAt(j)) {
					break;
				}
				
				if(j==2) {
					i += 1;
					ioiCount++;
				}
			}
		}
		
		System.out.println(joiCount + "\n" + ioiCount);
		
		scan.close();
	}
}
