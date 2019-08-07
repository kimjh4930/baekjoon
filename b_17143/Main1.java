//package b_17143;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main1 {
//	
//	static int R, C, M;
//	static Shark[][] map = new Shark[101][101];
//	
//	public static void main(String args[]) {
//		Scanner scan = new Scanner(System.in);
//		
//		R = scan.nextInt();		//y
//		C = scan.nextInt();		//x
//		M = scan.nextInt();		//상어 마리수.
//		
//		int r, c, s, d, z;
//		//y, x
//		
//		for(int i=0; i<M; i++) {
//			r = scan.nextInt();
//			c = scan.nextInt();
//			s = scan.nextInt();
//			d = scan.nextInt();
//			z = scan.nextInt();
//			
//			map[r][c] = new Shark(r, c, s, d, z);
//		}
//		
//		int king = 0;
//		int score = 0;
//		List<Shark> sharkList = new ArrayList<>();
//		
////		print();
//		
//		while(king < C) {
//			king++;
//			
//			for(int y=1; y<=R; y++) {
//				if(map[y][king] == null) {
//					continue;
//				}
//				score += map[y][king].size;
//				map[y][king] = null;
//				break;
//			}
//			
//			//상어 이동.
//			for(int y=1; y<=R; y++) {
//				for(int x=1; x<=C; x++) {
//					if(map[y][x] == null) {
//						continue;
//					}
//					
//					Shark tempShark = map[y][x];
//					for(int i=0; i<tempShark.v; i++) {
//						tempShark.move();
//					}
//					
//					sharkList.add(tempShark);
//				}
//			}
//			//상어 배치;
//			//1초기화.
//			for(int y=1; y<=R; y++) {
//				for(int x=1; x<=C; x++) {
//					map[y][x] = null;
//				}
//			}
//			//2.재배치
//			for(Shark tempShark : sharkList) {
//				if(map[tempShark.getY()][tempShark.getX()] == null) {
//					map[tempShark.getY()][tempShark.getX()] = tempShark;
//				}else {
//					if(map[tempShark.getY()][tempShark.getX()].size < tempShark.size) {
//						map[tempShark.getY()][tempShark.getX()] = tempShark;
//					}
//				}
//			}
//			sharkList.clear();
////			print();
//		}
//		
//		System.out.println(score);
//		
//		scan.close();
//	}
//	
//	static void print () {
//		System.out.println("=================");
//		for(int y=1; y<=R; y++) {
//			for(int x=1; x<=C; x++) {
//				if(map[y][x] == null) {
//					System.out.print("- ");
//				}else {
//					System.out.print("o ");
//				}
//			}
//			System.out.println("");
//		}
//	}
//
//}
//
//class Shark {
//	
//	int v, direction, size;
//	Point point;
//	
//	public Shark (int r, int c, int s, int d, int z) {
//		this.point = new Point(c, r);
//		this.v = s;
//		this.direction = d;
//		this.size = z;
//	}
//	
//	public int getX () {
//		return point.x;
//	}
//	
//	public int getY() {
//		return point.y;
//	}
//	
//	public void move () {
//		if(direction == 1) {		//위.
//			if(point.y == 1) {
//				direction = 2;
//				point.y++;
//			}else {
//				point.y--;
//			}
//		}else if(direction == 2) {	//아래.
//			if(point.y == Main1.R) {
//				direction = 1;
//				point.y--;
//			}else {
//				point.y++;
//			}
//		}else if(direction == 3) {	//오른쪽.
//			if(point.x == Main1.C) {
//				direction = 4;
//				point.x--;
//			}else {
//				point.x++;
//			}
//		}else if(direction == 4) {	//왼쪽.
//			if(point.x == 1) {
//				direction = 3;
//				point.x++;
//			}else {
//				point.x--;
//			}
//		}
//	}
//}
//
//class Point {
//	int x, y;
//	
//	public Point (int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
