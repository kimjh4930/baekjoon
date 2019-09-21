package string_processing.b_2941;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int index = 0;
		int size = input.length();
		int count = 0;
		
		while(true) {
			if(index >= size) {
				break;
			}
			
			if(input.charAt(index) == 'c' && index+1 < size) {
				if(input.charAt(index+1) == '=') {
					index +=2;
				}else if(input.charAt(index+1) == '-') {
					index += 2;
				}else {
					index++;
				}
				count++;
			}else if(input.charAt(index) == 'd') {
				if(index+1 < size && input.charAt(index+1) == '-') {
					index += 2;
				}else if(index+2 < size && input.charAt(index+1) == 'z' && input.charAt(index+2) == '=') {
					index += 3;
				}else {
					index++;
				}
				count++;
			}else if(input.charAt(index) == 'l' && index+1 < size) {
				if(input.charAt(index+1) == 'j') {
					index += 2;
				}else {
					index++;
				}
				count++;
			}else if(input.charAt(index) == 'n' && index+1 < size) {
				if(input.charAt(index+1) == 'j') {
					index += 2;
				}else {
					index++;
				}
				count++;
			}else if(input.charAt(index) == 's' && index+1 < size) {
				if(input.charAt(index+1) == '=') {
					index += 2;
				}else {
					index++;
				}
				count++;
			}else if(input.charAt(index) == 'z' && index+1 < size) {
				if(input.charAt(index+1) == '=') {
					index += 2;
				}else {
					index++;
				}
				count++;
			}else {
				index++;
				count++;
			}
		}
		
		System.out.println(count);
		
		scan.close();
	}

}
