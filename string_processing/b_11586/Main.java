package string_processing.b_11586;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<String> strList = new ArrayList<>();
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int mirror = 0;
		scan.nextLine();
		
		for(int i=0; i<N; i++) {
			strList.add(scan.nextLine());
		}
		mirror = scan.nextInt();
		
		if(mirror == 1) {
			for(int i=0; i<N; i++) {
				System.out.println(strList.get(i));
			}
		}else if(mirror == 2) {
			for(int i=0; i<N; i++) {
				for(int j=strList.get(i).length()-1; j>=0; j--) {
					System.out.print(strList.get(i).charAt(j));
				}
				System.out.println("");
			}
		}else {
			for(int i=N-1; i>=0; i--) {
				System.out.println(strList.get(i));
			}
		}
		
		scan.close();
		
	}
	

}
