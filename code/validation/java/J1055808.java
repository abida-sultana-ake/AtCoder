import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
	int sx,sy,tx,ty;
	public void solve() {
		sx = nextInt();
		sy = nextInt();
		tx = nextInt();
		ty = nextInt();

		int R = tx - sx;
		int U = ty - sy;
		for(int i = 0;i < U;i++){
			out.print("U");
		}
		for(int i = 0;i < R;i++){
			out.print("R");
		}
		for(int i = 0;i < U;i++){
			out.print("D");
		}
		for(int i = 0;i < R;i++){
			out.print("L");
		}

		out.print("L");
		for(int i = 0;i < U + 1;i++){
			out.print("U");
		}
		for(int i = 0;i < R + 1;i++){
			out.print("R");
		}
		out.print("D");
		out.print("R");
		for(int i = 0;i < U + 1;i++){
			out.print("D");
		}
		for(int i = 0;i < R + 1;i++){
			out.print("L");
		}
		out.print("U");
		out.println();
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