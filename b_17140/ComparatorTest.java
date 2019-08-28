package b_17140;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
	
	public static void main(String args[]) {
		
		List<Integer> intList = new ArrayList<>();
		
		intList.add(5);
		intList.add(1);
		intList.add(3);
		intList.add(2);
		intList.add(6);
		intList.add(10);
		
		intList.sort(new SortTest());
		
		for(int i : intList) {
			System.out.println(i + " ");
		}
		
	}

}

class SortTest implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 > o2 ? 1 : -1;
	}
	
}
