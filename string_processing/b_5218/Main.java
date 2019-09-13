package string_processing.b_5218;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		scan.nextLine();
		
		String input;
		String[] str;
		
		int length;
		
		for(int i=0; i<N; i++) {
			input = scan.nextLine();
			str = input.split(" ");
			
			length = str[0].length();
			
			System.out.print("Distances: ");
			for(int j=0; j<length; j++) {
				if(str[0].charAt(j) <= str[1].charAt(j)) {
					System.out.print(str[1].charAt(j) - str[0].charAt(j) + " ");
				}else {
					System.out.print((26 + (int)(str[1].charAt(j)-'a'+1) - (int)(str[0].charAt(j)-'a'+1)) + " ");
				}
			}
			System.out.println("");
		}
		
		scan.close();
	}

}
