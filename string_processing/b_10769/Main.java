package string_processing.b_10769;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String pattern = ":-";
		String input = scan.nextLine();
		
		int happy = 0, sad = 0;
		int index = 0;
		
		next :
		while(true) {
			
			if(index >= input.length()) {
				break;
			}
			
			if(input.charAt(index) == ':') {
				for(int j=0; j<3; j++) {
					if(j<2) {
						if(pattern.charAt(j) != input.charAt(index+j)) {
							index++;
							continue next;
						}
					}else if(j == 2) {
						if(input.charAt(index+j) == ')') {
							happy++;
							index += 2;
						}else if(input.charAt(index+j) == '(') {
							sad++;
							index += 2;
						}
					}
				}
			}
			index++;
		}
		
		if(happy > sad) {
			System.out.println("happy");
		}else if(sad > happy){
			System.out.println("sad");
		}else if (sad == 0 && happy == 0){
			System.out.println("none");
		}else if(sad == happy){
			System.out.println("unsure");
		}
		
		scan.close();
	}

}
