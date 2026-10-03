import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
public class Main {

	int N,K;
	double[][] dp;
	/* dfs(n,k) = n枚目のせんべいを見た時、残りk枚のせんべいを食べることができるとき、
	 * N枚目のせんべいを食べることが出来る確率を返す。
	 */
	public double dfs(int n,int k){

		if(k == 0){
			// せんべいを食べれる回数kが0なので、今後Nを得ることが出来ないため確率は0。
			return 0.0;
		}else if(k >= N - n + 1){
			// 今後出てくるせんべいをすべて食べることが出来るので、必ずNを得ることが出来る。
			return 1.0;
		}

		if(dp[n][k] != -1){
			return dp[n][k];
		}

		/* n枚目のせんべいがNである確率 */
		// 残りN - n + 1枚のうち1枚がNであるため 1.0 / (N - n + 1)
		double NSenbei = 1.0 / (N - n + 1);

		// 1.0 - maxP = n枚目のせんべいがNでない確率
		double notNSenbei = (1.0 - NSenbei);

		// 1.0 / n = n枚目までで最大のせんべいである確率
		// n枚までの中で最大は一つしか存在しないので、1 / n
		double maxSenbei = 1.0 / n;

		// n枚目のせんべいがNではなくて、n枚までで最大のせんべいの確率
		double notNMaxSenbei = notNSenbei * maxSenbei;

		/* n枚目のせんべいを食べてNを得ることが出来る確率 */
		double eat = dfs(n + 1,k - 1) * notNMaxSenbei + NSenbei;

		// n枚目のせんべいを食べないでNを得ることが出来る確率
		double notEat = dfs(n + 1,k) * notNMaxSenbei;

		//n枚目のせんべいが、n枚までで最大でない確率
		double notMaxSenbei = 1.0 - maxSenbei;

		//n枚目のせんべいがNでもなく、n枚までで最大でもない確率
		double notNnotMaxSenbei = notNSenbei * notMaxSenbei;

		return dp[n][k] = notNnotMaxSenbei * dfs(n + 1,k) + Math.max(eat, notEat);
	}

	public void solve() {
		N = nextInt();
		K = nextInt();

		dp = new double[N + 1][N + 1];

		for(int i = 0;i <= N;i++){
			Arrays.fill(dp[i],-1.0);
		}

		out.println(String.format("%.9f",dfs(1,K)));

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