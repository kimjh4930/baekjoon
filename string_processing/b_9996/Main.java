package string_processing.b_9996;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		scan.nextLine();
		
		String[] fixes = scan.nextLine().split("\\*");
		String temp = "";
		
		next:
		for(int i=0; i<n; i++) {
			temp = scan.nextLine();
			
			for(int prefix=0; prefix<fixes[0].length(); prefix++) {
				if(fixes[0].charAt(prefix) != temp.charAt(prefix)) {
					System.out.println("NE");
					continue next;
				}
			}
			
			for(int surfix=0; surfix<fixes[1].length(); surfix++) {
				if(fixes[1].charAt(fixes[1].length()-1 - surfix) != temp.charAt(temp.length()-1 - surfix)) {
					System.out.println("NE");
					continue next;
				}
			}
			
			System.out.println("DA");
		}
		
		scan.close();
	}

}
