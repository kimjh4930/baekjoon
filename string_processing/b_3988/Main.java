package string_processing.b_3988;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		scan.nextLine();
		
		String input;
		int count = 0;
		
		for(int i=0; i<n; i++) {
			input = scan.nextLine();
			
			stack.push(input.charAt(0));
			
			for(int j=1; j<input.length(); j++) {
				if(!stack.isEmpty() && stack.peek() == input.charAt(j)) {
					stack.pop();
				}else {
					stack.push(input.charAt(j));
				}
			}
			
			if(stack.isEmpty()) {
				count++;
			}
			
			stack.clear();
		}
		
		System.out.println(count);
		
		scan.close();
	}

}
