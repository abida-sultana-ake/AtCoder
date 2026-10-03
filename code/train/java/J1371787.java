import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] w = new int[N];
		int[] v = new int[N];
		sc.fill(w, v);

		long[] weight = new long[4];
		for (int i = 0; i < weight.length; i++) {
			weight[i] = w[0] + i;
		}

		List<List<Integer>> tmp = new ArrayList<>(4);
		for (int i = 0; i < 4; i++) {
			tmp.add(new ArrayList<>());
		}
		for (int i = 0; i < N; i++) {
			tmp.get(w[i] - w[0]).add(v[i]);
		}

		int[][] group = new int[4][];
		for (int i = 0; i < 4; i++) {
			group[i] = tmp.get(i).stream()
					.sorted(Comparator.reverseOrder())
					.mapToInt(Integer::intValue)
					.toArray();
		}

		long max = 0;
		for (int i = 0; i <= group[0].length; i++) {
			for (int j = 0; j <= group[1].length; j++) {
				for (int k = 0; k <= group[2].length; k++) {
					for (int l = 0; l <= group[3].length; l++) {
						long weightSum = weight[0] * i + weight[1] * j + weight[2] * k + weight[3] * l;
						if (W < weightSum) {
							break;
						}

						long value = (long) IntStream.of(group[0]).limit(i).sum()
								+ IntStream.of(group[1]).limit(j).sum()
								+ IntStream.of(group[2]).limit(k).sum()
								+ IntStream.of(group[3]).limit(l).sum();

						if (max < value) {
							max = value;
						}
					}
				}
			}
		}
		System.out.println(max);
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
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