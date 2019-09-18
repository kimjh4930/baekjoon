package string_processing.b_2857;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String FBI = "FBI";
		String input;
		int j=0;
		int num = 0;
		
		outer :
		for(int i=1; i<=5; i++) {
			input = scan.nextLine();
			
			j=0;
			
			next :
			while(j < input.length()) {
				
				for(int k=j, l=0; k<input.length() && k<=j+2; k++, l++) {
					if(input.charAt(k) != FBI.charAt(l)) {
						j++;
						continue next;
					}
				}
				
				System.out.print(i + " ");
				num++;
				continue outer;
			}
		}
		
		if(num ==0) {
			System.out.print("HE GOT AWAY!");
		}
		
		System.out.println("");
		
		scan.close();
	}

}
