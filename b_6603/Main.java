package b_6603;

import java.util.Scanner;

public class Main {
	
	static int[] nums;
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);

		int n, i;
		
		int[] arr = new int[6];
		
		while(true) {
			n = scan.nextInt();
			if(n == 0) {
				break;
			}
			
			nums = new int[n];
			
			for(i=0; i<n; i++) {
				nums[i] = scan.nextInt();
			}
			
			combination(arr, 0, n, 6, 0);
			
			System.out.println("");
		}
		
		scan.close();
		
	}
	
	static void combination (int arr[], int arrSize, int n, int r, int index) {
		if(arrSize == r) {
			
			for(int i=0; i<6; i++) {
				System.out.print(nums[arr[i]] + " ");
			}
			System.out.println("");
			
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