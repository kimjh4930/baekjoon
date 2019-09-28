package stack.b_1935;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static Stack<Double> stack = new Stack<>();
	static Map<Character, Double> map = new HashMap<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		scan.nextLine();
		
		char[] input = scan.nextLine().toCharArray();
		int num;
		
		for(int i=0; i<input.length; i++) {
			if(input[i] >= 'A' && input[i] <= 'Z') {
				if(!map.containsKey(input[i])) {
					num = scan.nextInt();
					map.put(input[i], (double)num);
				}
			}
		}
		
		System.out.printf("%.2f\n", calPostfix(input));
		
		scan.close();
	}
	
	static double calPostfix (char[] input) {
		double val1 = 0, val2 = 0;
		
		for(int i=0; i<input.length; i++) {
			if(input[i] >= 'A' && input[i] <= 'Z') {
				stack.push(map.get(input[i]));
			}else {
				val1 = stack.pop();
				val2 = stack.pop();
				switch(input[i]) {
				case '*':
					stack.push(val2 * val1);
					break;
				case '/':
					stack.push(val2 / val1);
					break;
				case '+':
					stack.push(val2 + val1);
					break;
				case '-':
					stack.push(val2 - val1);
					break;
				}
			}
		}
		
		return stack.pop();
	}

}
