package string_processing.b_4949;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static Map<Character, Character> map = new HashMap<>();
	static Stack<Character> stack = new Stack<>(); 
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		map.put(')', '(');
		map.put(']', '[');
		
		String input;
		char c;
		
		next : 
		while(true) {
			input = scan.nextLine();
			
			if(input.charAt(0) == '.') {
				break;
			}
			
			stack.clear();
			
			for(int i=0; i<input.length(); i++) {
				
				c = input.charAt(i);
				
				if(c == '(' || c == ')' || c == '[' || c == ']') {
				
					if(c == '(' || c == '[') {
						stack.push(c);
					}else {
						if(!stack.isEmpty() && stack.peek() == map.get(c)) {
							stack.pop();
						}else {
							System.out.println("no");
							continue next;
						}
					}
				
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
		}
		
		scan.close();
	}

}
