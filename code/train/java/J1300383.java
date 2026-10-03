import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Main {

	int N;
	int[] a;

	public void solve() {
		N = nextInt();
		a = new int[3 * N];
		for(int i = 0;i < 3 * N;i++){
			a[i] = nextInt();
		}

		long firstSum = 0;
		long secondSum = 0;
		PriorityQueue<Integer> minPq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxPq = new PriorityQueue<Integer>((a,b) -> b-a);

		for(int i = 0;i < N;i++){
			minPq.add(a[i]);
			firstSum += a[i];
		}

		for(int i = 0;i < N;i++){
			maxPq.add(a[2*N+i]);
			secondSum += a[2*N+i];
		}

		long ans = Long.MIN_VALUE;

		long[] firstSums = new long[N+1];
		long[] secondSums = new long[N+1];

		firstSums[0] = firstSum;
		secondSums[N] = secondSum;

		for(int i = 0;i < N;i++){
			minPq.add(a[N+i]);
			firstSum -= minPq.poll();
			firstSum += a[N+i];

			firstSums[i+1] = firstSum;
		}

		for(int i = 0;i < N;i++){
			maxPq.add(a[3*N-N-1-i]);
			secondSum -= maxPq.poll();
			secondSum += a[3*N-N-1-i];

			secondSums[N-i-1] = secondSum;
		}

		for(int i = 0;i <= N;i++){
			ans = Math.max(ans,firstSums[i]-secondSums[i]);
		}

		out.println(ans);
	}

	public static void main(String[] args) {
		out.flush();
		new Main().solve();
		out.close();
	}

	/* Input */
	private static final InputStream in = System.in;
	private static final PrintWriter out = new PrintWriter(System.out);
	private final byte[] buffer = new byte[2048];
	private int p = 0;
	private int buflen = 0;

	private boolean hasNextByte() {
		if (p < buflen)
			return true;
		p = 0;
		try {
			buflen = in.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (buflen <= 0)
			return false;
		return true;
	}

	public boolean hasNext() {
		while (hasNextByte() && !isPrint(buffer[p])) {
			p++;
		}
		return hasNextByte();
	}

	private boolean isPrint(int ch) {
		if (ch >= '!' && ch <= '~')
			return true;
		return false;
	}

	private int nextByte() {
		if (!hasNextByte())
			return -1;
		return buffer[p++];
	}

	public String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = -1;
		while (isPrint((b = nextByte()))) {
			sb.appendCodePoint(b);
		}
		return sb.toString();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}