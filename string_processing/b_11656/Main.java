package string_processing.b_11656;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static Set<String> strSet = new HashSet<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int size = input.length();
		
		String substring = "";
		
		for(int i=0; i<size; i++) {
			substring = input.substring(i, size);
			if(!strSet.contains(substring)) {
				strSet.add(substring);
			}
		}
		
		List<String> strList = new ArrayList<>(strSet);
		
		strList.sort(new SortList());
		
		for(String str : strList) {
			System.out.println(str);
		}
		scan.close();
	}

}

class SortList implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		int size = o1.length();
		
		if(o1.length() > o2.length()) {
			size = o1.length();
		}else {
			size = o2.length();
		}
		
		for(int i=0; i<size; i++) {
			
			if(i > o1.length()-1) {
				return -1;
			}
			
			if(i > o2.length()-1) {
				return 1;
			}
			
			if(o1.charAt(i) != o2.charAt(i)) {
				return o1.charAt(i) > o2.charAt(i) ? 1 : -1;
			}
		}
		
		return 0;
	}
	
}
