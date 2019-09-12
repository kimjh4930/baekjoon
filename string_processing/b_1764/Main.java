package string_processing.b_1764;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static Set<String> inputSet = new HashSet<>();
	static List<String> resultList = new ArrayList<>();

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int N, M;
		String input;
		
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		
		for(int i=0; i<N; i++) {
			inputSet.add(scan.nextLine());
		}
		
		for(int i=0; i<M; i++) {
			input = scan.nextLine();
			if(inputSet.contains(input)) {
				resultList.add(input);
			}
		}
		
		resultList.sort(new SortList());
		
		System.out.println(resultList.size());
		for(String result : resultList) {
			System.out.println(result);
		}
		
		scan.close();
	}
}

class SortList implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		int length = o1.length();
		
		if(o1.length() > o2.length()) {
			length = o2.length();
		}
		
		for(int i=0; i<length; i++) {
			if(o1.charAt(i) == o2.charAt(i)) {
				continue;
			}
			return o1.charAt(i) > o2.charAt(i) ? 1 : -1;
		}
		
		return 0;
	}
}
