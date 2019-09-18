package string_processing.b_1919;

import java.util.Scanner;

public class Main {
	
	static int[] first = new int[26];
	static int[] second = new int[26];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input1 = scan.nextLine();
		int remove = 0;
		
		for(int i=0; i<input1.length(); i++) {
			first[input1.charAt(i) - 'a']++;
		}
		
		String input2 = scan.nextLine();
		
		for(int i=0; i<input2.length(); i++) {
			second[input2.charAt(i) - 'a']++;
		}
		
		for(int i=0; i<26; i++) {
			if(first[i] != 0 && second[i] != 0) {
				remove += Math.abs(first[i] - second[i]);
			}else {
				remove += first[i] + second[i];
			}
		}
		
		System.out.println(remove);
		
		
		scan.close();
	}

}
