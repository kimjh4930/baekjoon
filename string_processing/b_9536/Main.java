package string_processing.b_9536;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static Set<String> animalSet = new HashSet<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		scan.nextLine();
		
		String[] input;
		String[] animal;
		
		for(int test_case=0; test_case<T; test_case++) {
			input = scan.nextLine().split(" ");
			animalSet.clear();
			
			StringBuffer str = new StringBuffer();
			
			while(true) {
				animal = scan.nextLine().split(" ");
				
				if("goes".equals(animal[1])) {
					animalSet.add(animal[2]);
				}else {
					break;
				}
			}
			
			for(int i=0; i<input.length; i++) {
				if(!animalSet.contains(input[i])) {
					str.append(input[i]).append(" ");
				}
			}
			
			System.out.println(str);
			
		}
		
		scan.close();
	}

}
