package string_processing.b_1371;

import java.util.Scanner;

public class Main {
	
	static int count[] = new int[26];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input;
		int size = 0;
		int max = -1;
		int index = 0;
		
		while(scan.hasNextLine()) {
			
			input = scan.nextLine();
			size = input.length();
			
			for(int i=0; i<size; i++) {
				
				if(input.charAt(i) == ' ') {
					continue;
				}
				
				index = (input.charAt(i) - 'a');
				count[index]++;
				
				if(count[index] > max) {
					max = count[index];
				}
			}
		}
		
		String result = "";
		
		for(int i=0; i<26; i++) {
			if(count[i] == max) {
				result += (char)('a'+i);
			}
		}
		
		System.out.println(result);
		
		scan.close();
	}

}
