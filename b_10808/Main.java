package b_10808;

import java.util.Scanner;

public class Main {
	
	static int[] count = new int[26];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int length = input.length();
		
		for(int i=0; i<length; i++) {
			count[input.charAt(i)-'a']++;
		}
		
		String result ="";
		
		for(int i=0; i<26; i++) {
			result += count[i] + " ";
		}
		System.out.println(result);
		scan.close();
	}

}
