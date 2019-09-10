package greedy.b_1931;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N, start, end;
	static List<Room> timeList = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			start = scan.nextInt();
			end = scan.nextInt();
			
			timeList.add(new Room(start, end));
		}
		
		timeList.sort(new SortList());
		
		int count = 1;
		Room room = timeList.get(0);
		
		for(int i=1; i<timeList.size(); i++) {
			if(room.end <= timeList.get(i).start) {
				count++;
				room = timeList.get(i);
			}
		}
		
		System.out.println(count);
		
		scan.close();
	}

}

class Room {
	int start;
	int end;
	
	public Room (int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class SortList implements Comparator<Room>{

	@Override
	public int compare(Room o1, Room o2) {
		if(o1.end == o2.end) {
			return o1.start > o2.start ? 1 : -1;
		}
		return o1.end > o2.end ? 1 : -1;
	}
}
