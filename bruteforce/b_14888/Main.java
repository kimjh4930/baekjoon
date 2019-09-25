package bruteforce.b_14888;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<int[]> permuList = new ArrayList<>();
	static List<Integer> numList = new ArrayList<>();
	static List<Character> operList = new ArrayList<>();
	
	static int N;
	static int oper;
	
	static int min = 0x7FFFFFFF;
	static int max = 0x80000000;
			
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		for(int i=0; i<N; i++) {
			numList.add(scan.nextInt());
		}
		
		for(int i=0; i<4; i++) {
			oper = scan.nextInt();
			for(int j=0; j<oper; j++) {
				switch(i) {
				case 0 :
					operList.add('+');
					break;
				case 1:
					operList.add('-');
					break;
				case 2:
					operList.add('*');
					break;
				case 3:
					operList.add('/');
					break;
				}
			}
		}
		
		int arr[] = new int[operList.size()];
		
		for(int i=0; i<operList.size(); i++) {
			arr[i] = i;
		}
		
		permutation(arr, 0, operList.size(), operList.size());
		
		int sum = 0;
		
		for(int[] perm : permuList) {
			sum = numList.get(0);
			for(int i=1; i<=perm.length; i++) {
				
				switch (operList.get(perm[i-1])) {
				case '+' :
					sum += numList.get(i);
					break;
				case '-' :
					sum -= numList.get(i);
					break;
				case '*' :
					sum *= numList.get(i);
					break;
				case '/' :
					sum /= numList.get(i);
					break;
				}
			}
			
			if(sum > max) {
				max = sum;
			}
			
			if(sum < min) {
				min = sum;
			}
		}
		
		System.out.println(max+"\n"+min);
		
		scan.close();
	}
	
	static void permutation (int[] arr, int arrSize, int n, int r) {
		if(arrSize == r) {
			permuList.add(arr.clone());
			return;
		}
		
		for(int i=arrSize; i<n; i++) {
			swap(arr, i, arrSize);
			permutation(arr, arrSize+1, n, r);
			swap(arr, i, arrSize);
		}
	}
	
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
