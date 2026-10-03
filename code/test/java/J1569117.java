import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class Point {
		private int x;
		private int y;
		private int a;

		Point(int x, int y ,int a) {
			this.x = x;
			this.y = y;
			this.a = a;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int point_W = sc.nextInt();
		int point_H = sc.nextInt();
		int lines = sc.nextInt();

		List<Point> list = new ArrayList<>();
		for (int i =  0;  i < lines; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();
			list.add(new Point(x, y, a));
		}

		int cells[][] = new int[point_H][point_W];
		fillCells(cells, 0);
		for (Point pt : list) {
			FlipCells(cells, pt, 1);
		}

		int areaNum = 0; 
		for (int i =  0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j] == 0) {
					areaNum++; 
				}
			}
		}	
		System.out.println(areaNum);
	}

	static void fillCells(int cells[][], int value) {
		for (int[] cell : cells) {
			for (int j = 0; j < cell.length; j++) {
				cell[j] = value;
			}
		}	
	}	

	static void FlipCells(int cells[][], Point pt, int value) {
		switch(pt.a) {
			case 1:
			{
				for (int i =  0; i < cells.length; i++) {
					for (int j = 0; j < pt.x; j++) {
						cells[i][j] = value;
					}
				}	
			}
			break;
			case 2:
			{
				for (int i =  0; i < cells.length; i++) {
					for (int j = pt.x; j < cells[i].length; j++) {
						cells[i][j] = value;
					}
				}	
			}
			break;
			case 3:
			{
				for (int i = 0; i < pt.y; i++) {
					for (int j = 0 ; j <cells[i].length; j++) {
						cells[i][j] = value;
					}
				}	
			}
			break;
			case 4:
			{
				for (int i = pt.y; i < cells.length; i++) {
					for (int j =  0; j < cells[i].length; j++) {
						cells[i][j] = value;
					}
				}	
			}
			break;
		}
	} 

}
