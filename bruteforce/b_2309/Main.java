package bruteforce.b_2309;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<int[]> combiList = new ArrayList<>();
	static List<Integer> personList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextInt()) {
			personList.add(scan.nextInt());
		}
		
		int[] arr = new int[7];
		combination(arr, 0, personList.size(), 7, 0);
		
		int sum = 0;
		List<Integer> dwarfList = new ArrayList<>();
		
		for(int[] combi : combiList) {
			sum = 0;
			for(int i=0; i<7; i++) {
				sum += personList.get(combi[i]);
			}
			
			if(sum == 100) {
				for(int i=0; i<7; i++) {
					dwarfList.add(personList.get(combi[i]));
				}
				break;
			}
		}
		
		dwarfList.sort(new SorgtList());
		
		for(int i=0; i<7; i++) {
			System.out.println(dwarfList.get(i));
		}
		
		scan.close();
	}
	
	static void combination (int[] arr, int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			combiList.add(arr.clone());
			return;
		}
		
		if(index == n) {
			return;
		}
		
		arr[arrSize] = index;
		
		combination(arr, arrSize+1, n, r, index+1);
		combination(arr, arrSize, n, r, index+1);
	}

}

class SorgtList implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 > o2 ? 1 : -1;
	}
	
}
