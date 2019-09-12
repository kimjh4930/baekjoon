package string_processing.b_1032;

import java.util.Scanner;

public class Main {
	
	static char c[] = new char[50];
	static int N;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		scan.nextLine();
		
		String input = scan.nextLine();
		int length = input.length();
		
		for(int i=0; i < length; i++) {
			c[i] = input.charAt(i);
		}
		
		for(int i=1; i<N; i++) {
			input = scan.nextLine();
			
			for(int j=0; j<length; j++) {
				if(c[j] == '?') {
					continue;
				}
				
				if(c[j] != input.charAt(j)) {
					c[j] = '?';
				}
			}
		}
		
		String result = "";
		
		for(int i=0; i<length; i++) {
			result += c[i];
		}
		
		System.out.println(result);
		
		scan.close();
	}

}
