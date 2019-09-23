package string_processing.b_2804;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input[] = scan.nextLine().split(" ");
		
		int x=0, y=0;
		
		outer:
		for(int i=0; i<input[0].length(); i++) {
			for(int j=0; j<input[1].length(); j++) {
				if(input[0].charAt(i) == input[1].charAt(j)){
					y = i;
					x = j;
					break outer;
				}
			}
		}
		
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i<input[1].length(); i++) {
			for(int j=0; j<input[0].length(); j++) {
				
				if(i == x) {
					builder.append(input[0].charAt(j));
				}else if(j == y) {
					builder.append(input[1].charAt(i));
				}else {
					builder.append(".");
				}
				
			}
			builder.append("\n");
		}
		
		System.out.println(builder.toString());
		
		scan.close();
	}

}
