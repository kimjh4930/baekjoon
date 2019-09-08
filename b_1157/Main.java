package b_1157;

import java.util.Scanner;

public class Main {
	
	static int visited[] = new int[26];
	static int max = -1;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine().toLowerCase();
		int index = 0;
		int count = 0;
		
		for(int i=0; i<input.length(); i++) {
			index = (int)input.charAt(i) - 'a';
			visited[index]++;
			
			if(visited[index] > max) {
				max = visited[index];
			}
		}
		
		for(int i=0; i<26; i++) {
			if(max == visited[i]) {
				count++;
				index = i;
			}
		}
		
		if(count >= 2) {
			System.out.println("?");
		}else {
			System.out.println((char)('A' + index));
		}
	
		
		scan.close();
	}

}
