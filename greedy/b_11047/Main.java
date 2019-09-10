package greedy.b_11047;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static Stack<Integer> stack = new Stack<>();
	static int N;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int N, coin;
		
		N = scan.nextInt();
		coin = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			stack.push(scan.nextInt());
		}
		
		int value = 0;
		int num = 0;
		
		while(!stack.isEmpty() && coin != 0) {
			value = stack.pop();
			
			if(value > coin) {
				continue;
			}else {
				num += coin / value;
				coin %= value;
			}
		}
		
		System.out.println(num);
		
		scan.close();
	}
}
