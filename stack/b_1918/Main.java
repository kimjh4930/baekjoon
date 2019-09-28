package stack.b_1918;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input =  scan.nextLine();
		
		System.out.println(makePostfix(input.toCharArray()));
		
		scan.close();
	}
	
	static String makePostfix (char[] input) {
		
		StringBuilder postfix = new StringBuilder();
		
		for(int i=0; i<input.length; i++) {
			switch(input[i]) {
			case '(' :
				stack.push(input[i]);
				break;
			case '*' :
			case '/' :
				while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					postfix.append(stack.pop());
				}
				stack.push(input[i]);
				break;
			case '+' :
			case '-' :
				while(!stack.isEmpty() && stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				stack.push(input[i]);
				break;
			case ')' :
				while(stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				stack.pop();
				break;
			default :
				postfix.append(input[i]);
			}
			
		}
		
		while(!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		
		return postfix.toString();
	}

}
