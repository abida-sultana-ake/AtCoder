import java.util.Scanner;
import java.util.HashMap;
import java.util.Objects;
import java.util.Collection;

public class Main {
	public static void main(String[] args) {
		
		SunukeColoring sc = new SunukeColoring();
		sc.run();
		
	}
}

class SunukeColoring {
	
	int H;
	int W;
	int N;
	Point[] points;
	
	SunukeColoring() {
		Scanner cin = new Scanner(System.in);
		this.H = cin.nextInt();
		this.W = cin.nextInt();
		this.N = cin.nextInt();
		this.points = new Point[N];
		for (int i = 0; i < N; i++) {
			int x = cin.nextInt();
			int y = cin.nextInt();
			points[i] = new Point(x, y);
		}
	}
	
	void run() {
		
		HashMap<Point, Long> map = new HashMap<Point, Long>();
		for (Point point: points) {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					
					Point target = new Point(point.x + i, point.y + j);
					
					if (target.invalid()) {
						continue;
					}
					
					if (map.containsKey(target)) {
						long count = map.get(target);
						map.put(target, count + 1);
					} else {
						map.put(target, (long)1);
					}
					
				}
			}
		}
		
		Collection<Long> values = map.values();
		long[] ans = new long[10];
		
		long allCount = 0;
		for (long num: values) {
			ans[(int)num]++;
			allCount++;
		}
		
		long all = (long) (H - 2) * (W - 2);
		ans[0] = all - allCount;
		
		for (long a: ans) {
			System.out.println(a);
		}
	}
	
	class Point {
		
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		boolean invalid() {
			return x <= 1 || H <= x || y <= 1 || W <= y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point point = (Point) obj;
				return this.x == point.x && this.y == point.y;
			} else {
				return false;
			}
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
