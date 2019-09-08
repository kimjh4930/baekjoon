package b_10809;

import java.util.Scanner;

public class Main {
	
	static int visited[] = new int[26];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<26; i++) {
			visited[i] = -1;
		}
		
		String input = scan.nextLine();
		
		for(int i=0; i<input.length(); i++) {
			if(visited[(int)input.charAt(i) - 'a'] == -1) {
				visited[(int)input.charAt(i) - 'a'] = i;
			}
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(visited[i] + " ");
		}
		System.out.println("");
		
		scan.close();
	}

}
