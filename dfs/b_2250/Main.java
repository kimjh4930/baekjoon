package dfs.b_2250;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int N;
	
	static Node[] nodeList;
	static int count=1;
	
	static Deque<Node> deque = new LinkedList<>();
	static Deque<Node> tempDeque = new LinkedList<>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		nodeList = new Node[N+1];
		
		int num, left, right;
		
		for(int i=1; i<=N; i++) {
			num = scan.nextInt();
			left = scan.nextInt();
			right = scan.nextInt();
			
			nodeList[num] = new Node(num, left, right);
		}
		
		int root = findRoot(1);
		
//		System.out.println("root : " + root);
		
		dfs(root, 1);
		deque.addLast(nodeList[root]);
		bfs();
		
		scan.close();
	}
	
	static int findRoot (int index) {
		
		int root = nodeList[index].num;
		
		for(int i=1; i<=N; i++) {
			if(nodeList[i].left == root || nodeList[i].right == root) {
				return findRoot(i);
			}
		}
		
		return root;
	}
	
	static void dfs (int index, int level) {
		Node node = nodeList[index];
		
		if(node.left != -1) {
			dfs(node.left, level+1);
		}
		//중
		node.level = level;
		node.order = count;
		count++;
		
		//우.
		if(node.right != -1) {
			dfs(node.right, level+1);
		}
	}
	
	static void bfs () {
		Node node;
		
		int max = 1;
		int size = 1;
		int level = 1;
		
		while(!deque.isEmpty()) {
			node = deque.poll();
			
			if(node.left != -1) {
				tempDeque.addLast(nodeList[node.left]);
			}
			
			if(node.right != -1) {
				tempDeque.addLast(nodeList[node.right]);
			}
			
			if(deque.isEmpty()) {
				
				if(!tempDeque.isEmpty()) {
					Node mostLeft = tempDeque.peekFirst();
					Node mostRight = tempDeque.peekLast();
					
					size = mostRight.order - mostLeft.order + 1;
					
					if(size > max) {
						level = mostLeft.level;
						max = size;
					}
				}
				
				deque.addAll(tempDeque);
				tempDeque.clear();
			}
		}
		
		System.out.println(level + " " + max);
	}
}

class Node {
	int num;
	int left, right;
	int order, level;	//순서, 레벨을 기록함.
	
	public Node(int num, int left, int right) {
		this.num = num;
		this.left = left;
		this.right = right;
	}
}
