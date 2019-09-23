package string_processing.b_1543;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String state = scan.nextLine();
		String word = scan.nextLine();
		
		int index = 0;
		int temp = 0;
		int count = 0;
		int i=0;
		
		next:
		while(temp < state.length()) {
			if(state.charAt(temp) == word.charAt(0)) {
				for(i=1; i<word.length() && temp+i< state.length(); i++) {
					if(state.charAt(temp+i) != word.charAt(i)) {
						index++;
						temp = index;
						continue next;
					}
				}
				
				if(i == word.length()) {
					count++;
				}
				
				index += i;
				
			}else {
				index++;
			}
			temp = index;
		}
		
		System.out.println(count);
		
		scan.close();
	}

}
