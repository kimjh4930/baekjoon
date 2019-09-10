package greedy.b_11399;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static List<Integer> timeList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			timeList.add(scan.nextInt());
		}
		
		timeList.sort(new SortList());
		
		int sum = 0;
		int temp = 0;
		
		for(int i=0; i<N; i++) {
			temp += timeList.get(i);
			sum += temp;
		}
		
		System.out.println(sum);
		scan.close();
	}
}

class SortList implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 > o2 ? 1 : -1;
	}	
}