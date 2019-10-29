package dynamic.b_1463;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean visited[] = new boolean[1000001];
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> tempQueue = new LinkedList<>();
	
	static int count = 0;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		queue.add(num);
		
		if(num != 1) {
			bfs();
		}
		
		System.out.println(count);
		
		scan.close();
	}
	
	static void bfs () {
		
		int temp;
		
		while(!queue.isEmpty()) {
			temp = queue.poll();
			
			int result;
			
			if(temp % 2 == 0 && visited[temp%2] == false) {
				result = temp / 2;
				
				if(result == 1) {
					count++;
					return;
				}
				
				visited[temp/2] = true;
				tempQueue.add(temp/2);
			}
			if(temp % 3 == 0 && visited[temp%3] == false) {
				
				result = temp / 3;
				
				if(result == 1) {
					count++;
					return;
				}
				
				visited[temp/3] = true;
				tempQueue.add(temp/3);
			}
			if(temp-1 >= 1 && visited[temp-1] == false) {
				
				result = temp - 1;
				
				if(result == 1) {
					count++;
					return;
				}
				
				visited[temp-1] = true;
				tempQueue.add(temp-1);
			}
			
			
			if(queue.isEmpty()) {
				count++;
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
			
		}
	}
}
