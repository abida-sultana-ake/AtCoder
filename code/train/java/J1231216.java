import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		ABC002DDSolve solve = new ABC002DDSolve();
		solve.main();
	}
}

class ABC002DDSolve {
	
	int N;
	int M;
	int[][] adj;
	
	ABC002DDSolve() {
		Scanner cin = new Scanner(System.in);
		this.N = cin.nextInt();
		this.M = cin.nextInt();
		this.adj = new int[N][N];
		for (int i = 0; i < M; i++) {
			int x = cin.nextInt() - 1;
			int y = cin.nextInt() - 1;
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
	}
	
	void main() {
		int max = 0;
		for (int i = 0; i < 1 << N; i++) {
			
			int size = Integer.bitCount(i);			
			int[] members = new int[size];
			
			int index = 0;
			for (int j = 0; j < N; j++) {
				if ((i >> j & 1) == 1) {
					members[index] = j;
					index++;
				}
			}
			
			breakLabel: for (int s = 0; s < size; s++) {
				for (int t = s + 1; t < size; t++) {
					if (adj[members[s]][members[t]] == 0) {
						size = 0;
						break breakLabel;
					}
				}
			}
			max = Math.max(max, size);
			
		}
		System.out.println(max);
	}
	
}
