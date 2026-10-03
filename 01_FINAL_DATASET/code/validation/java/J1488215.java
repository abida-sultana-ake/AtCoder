import java.util.Scanner;

public class Main {
	private Scanner sc;
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		sc = new Scanner(System.in);

		String[] nico = sc.nextLine().split(" ");
		int h = Integer.parseInt(nico[0]);
		int w = Integer.parseInt(nico[1]);
		
		int[][] map = new int[h][w];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = 0;
			}
		}
		
		int n = Integer.parseInt(sc.nextLine());
		
		int ix = 0;
		int iy = 0;
		for (int i = 0; i < n; i++) {
			int c = sc.nextInt();
			
			for (int j = 0; j < c; j++) {
				map[iy + (ix + j) / w][(ix + j) % w] = (i + 1);
			}

			int tx = ix;
			ix = (c + tx) % w;
			iy = ((c + tx) / w) + iy;
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				int index = j;
				if ((i % 2) != 0) index = map[0].length - j - 1;
				
				if (j == 0) System.out.print(map[i][index]);
				else System.out.print(" " + map[i][index]);
			}
			System.out.println();
		}
	}
}