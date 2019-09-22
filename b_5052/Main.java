package b_5052;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<String> numList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m;
		String input;
		String former;
		
		next : 
		for(int i=0; i<n; i++) {
			m = scan.nextInt();
			scan.nextLine();
			
			numList.clear();
			
			for(int j=0; j<m; j++) {
				input = scan.nextLine();
				numList.add(input);
			}
			numList.sort(new SortList());
			
			former = numList.get(0);
			
			for(int k=1; k<numList.size(); k++) {
				if(numList.get(k).contains(former)) {
					System.out.println("NO");
					continue next;
				}
				former = numList.get(k);
			}
			
			System.out.println("YES");
			
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
			if(o1.charAt(i) > o2.charAt(i)) {
				return 1; 
			}else if(o1.charAt(i) < o2.charAt(i)) {
				return -1;
			}
		}
		
		return o1.length() > o2.length() ? 1 : -1;
		
	}
}
