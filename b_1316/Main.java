package b_1316;

import java.util.Scanner;

public class Main {
	
	static boolean[] visited = new boolean[26];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		scan.nextLine();
		
		String input;
		char former = 0;
		int group = 0;
		int index = 0;
		
		outer:
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<26; j++) {
				visited[j] = false;
			}
			former = 0;
			
			input = scan.nextLine();
			
			for(int j=0; j<input.length(); j++) {
				index = input.charAt(j) - 'a';
				if(visited[index] == false) {
					visited[index] = true;
					former = input.charAt(j);
				}else if(visited[index] == true && former == input.charAt(j)) {
					continue;
				}else {
					continue outer;
				}
			}
			group++;
		}
		
		System.out.println(group);
		
		scan.close();
	}

}
