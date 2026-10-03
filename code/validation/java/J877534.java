import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	long h, w, n;
	Set<P> set;
	int[][] dx, dy;

	class P implements Comparable<P> {
		int x, y;

		P(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(P o) {
			if (this.x != o.x) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	void dxy() {
		dx = new int[][] {
			{ -2, -1, 0, -2, -1, 0, -2, -1 },
			{ -1, 0, 1, -1, 0, 1, -1, 1 },
			{ 0, 1, 2, 0, 1, 2, 1, 2 },
			{ -2, -1, 0, -2, -1, -2, -1, 0 },
			{ -1, 0, 1, -1, 1, -1, 0, 1 },
			{ 0, 1, 2, 1, 2, 0, 1, 2 },
			{ -2, -1, -2, -1, 0, -2, -1, 0 },
			{ -1, 1, -1, 0, 1, -1, 0, 1 },
			{ 1, 2, 0, 1, 2, 0, 1, 2 },
		};
		dy = new int[][] {
			{ -2, -2, -2, -1, -1, -1, 0, 0 },
			{ -2, -2, -2, -1, -1, -1, 0, 0 },
			{ -2, -2, -2, -1, -1, -1, 0, 0 },
			{ -1, -1, -1, 0, 0, 1, 1, 1 },
			{ -1, -1, -1, 0, 0, 1, 1, 1 },
			{ -1, -1, -1, 0, 0, 1, 1, 1 },
			{ 0, 0, 1, 1, 1, 2, 2, 2 },
			{ 0, 0, 1, 1, 1, 2, 2, 2 },
			{ 0, 0, 1, 1, 1, 2, 2, 2 },
		};
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		h = sc.nextInt();
		w = sc.nextInt();
		n = sc.nextInt();
		set = new TreeSet<P>();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			set.add(new P(b, a));
		}

		dxy();

		long[] ans = new long[10];
		for (P p : set) {
			L: for (int i = 0; i < 9; i++) {
				List<P> list = new LinkedList<P>();
				for (int j = 0; j < 8; j++) {
					int nx = p.x + dx[i][j];
					int ny = p.y + dy[i][j];
					P np = new P(nx, ny);
					if (nx < 0 || w <= nx || ny < 0 || h <= ny) {
						continue L;
					}
					if (!set.contains(np)) {
						continue;
					}
					if (np.compareTo(p) < 0) {
						continue L;
					}
					//					System.out.println(p + ": " + np);
					list.add(np);
				}
				//				System.out.println();
				ans[list.size() + 1]++;
			}
		}
		ans[0] = (h - 2) * (w - 2);
		for (int i = 1; i < 10; i++) {
			ans[0] -= ans[i];
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(ans[i]);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
