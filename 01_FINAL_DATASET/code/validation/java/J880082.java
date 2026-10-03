import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.LongStream;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		Set<Box> fills = new HashSet<>();
		for (int i = 0; i < N; i++) {
			fills.add(new Box(sc.nextInt() - 1, sc.nextInt() - 1));
		}

		Set<Box> boards = new HashSet<Box>();
		for (Box box : fills) {
			for (int y = -2; y <= 0; y++) {
				for (int x = -2; x <= 0; x++) {
					int yy = box.y + y;
					int xx = box.x + x;
					if ((yy >= 0 && xx >= 0) && (yy < H - 2 && xx < W - 2)) {
						boards.add(new Box(yy, xx));
					}
				}
			}
		}

		long[] group = new long[10];
		for (Box box : boards) {
			int count = 0;
			for (int y = box.y; y <= box.y + 2; y++) {
				for (int x = box.x; x <= box.x + 2; x++) {
					if (fills.contains(new Box(y, x))) {
						count++;
					}
				}
			}
			group[count]++;
		}

		long zero = ((long) (H - 2) * (W - 2)) - LongStream.of(group).sum();
		System.out.println(zero);
		for (int i = 1; i < group.length; i++) {
			System.out.println(group[i]);
		}
	}

	private static class Box {
		public int y;
		public int x;

		public Box(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public int getX() {
			return x;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Box other = (Box) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Box [y=" + y + ", x=" + x + "]";
		}
	}

	public static class Scanner {
		private BufferedInputStream inputStream;

		public Scanner(InputStream in) {
			inputStream = new BufferedInputStream(in);
		}

		public int nextInt() throws IOException {
			int num = 0;
			int sign = 1;

			int read = skip();
			if (read == '-') {
				sign = -1;
				read = inputStream.read();
			}

			do {
				num = num * 10 + sign * (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
		}

		public void fill(int[] a) throws IOException {
			for (int i = 0; i < a.length; i++) {
				a[i] = nextInt();
			}
		}

		public void fill(int[] a, int[] b) throws IOException {
			if (a.length != b.length) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = nextInt();
				b[i] = nextInt();
			}
		}

		public long nextLong() throws IOException {
			long num = 0;
			int sign = 1;

			int read = skip();
			if (read == '-') {
				sign = -1;
				read = inputStream.read();
			}

			do {
				num = num * 10 + sign * (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
		}

		public void fill(long[] a) throws IOException {
			for (int i = 0; i < a.length; i++) {
				a[i] = nextLong();
			}
		}

		public void fill(long[] a, long[] b) throws IOException {
			if (a.length != b.length) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = nextLong();
				b[i] = nextLong();
			}
		}

		public long[] nextLong(int n) throws IOException {
			long[] array = new long[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextLong();
			}

			return array;
		}

		public String next() throws IOException {
			StringBuilder builder = new StringBuilder();

			int read = skip();
			do {
				builder.append((char) read);
			} while ((read = inputStream.read()) > 0x20);

			return builder.toString();
		}

		private int skip() throws IOException {
			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			return read;
		}
	}
}
