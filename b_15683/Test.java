package b_15683;

public class Test {
	
	static int[][] cameraStatus = {
			{0},
			{0, 2},
			{0, 3},
			{0, 2, 3},
			{0, 1, 2, 3}
	};
	
	public static void main (String args[]) {
		for(int i=0; i<5; i++) {
			System.out.println(cameraStatus[i].length);
		}
	}

}
