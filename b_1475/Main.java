package b_1475;

import java.util.Scanner;

public class Main {
	
	static int[] count = new int[10];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int index = 0;
		int max = -1;
		
		for(int i=0; i<input.length(); i++) {
			index = input.charAt(i) - '0';
			
			if(index == 6 || index == 9) {
				if(count[6] > count[9]) {
					count[9]++;
				}else {
					count[6]++;
				}
			}else {
				count[index]++;
			}
		}
		
		for(int i=0; i<10; i++) {
			if(max < count[i]) {
				max = count[i];
			}
		}
		
		System.out.println(max);
		
		scan.close();
	}

}
