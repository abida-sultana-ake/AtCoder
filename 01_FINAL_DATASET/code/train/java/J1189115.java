import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if (N % 10 >= 7) {
			System.out.println((N / 10) * 100 + 100);
		} else {
			System.out.println((N / 10) * 100 + (N % 10) * 15);
		}
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}

	private class Tuple<T1, T2> {
		private final T1 item1;
		private final T2 item2;

		public Tuple(T1 item1, T2 item2) {
			this.item1 = item1;
			this.item2 = item2;
		}

		public T1 getItem1() {
			return item1;
		}

		public T2 getItem2() {
			return item2;
		}

		@Override
		public String toString() {
			return "Tuple [item1=" + item1 + ", item2=" + item2 + "]";
		}
	}

	private class Tuple3<T1, T2, T3> {
		private final T1 item1;
		private final T2 item2;
		private final T3 item3;

		public Tuple3(T1 item1, T2 item2, T3 item3) {
			this.item1 = item1;
			this.item2 = item2;
			this.item3 = item3;
		}

		public T1 getItem1() {
			return item1;
		}

		public T2 getItem2() {
			return item2;
		}

		public T3 getItem3() {
			return item3;
		}

		@Override
		public String toString() {
			return "Tuple [item1=" + item1 + ", item2=" + item2 + "]";
		}
	}

	public static class Scanner {
		private BufferedInputStream inputStream;

		public Scanner(InputStream in) {
			inputStream = new BufferedInputStream(in);
		}

		public int nextInt() throws IOException {
			int num = 0;

			int read = skip();
			do {
				num = num * 10 + (read - 0x30);
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

			int read = skip();
			do {
				num = num * 10 + (read - 0x30);
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
