import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			
			return Long.parseLong(next());
		}

		BigInteger nextBigIntger() {
			BigInteger bb = new BigInteger(next());
			return bb;
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n  =sc.nextInt();
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++){
		int num = sc.nextInt();
		if(map.containsKey(num))
			map.remove(num);
		else
			map.put(num, 1);
		}
		System.out.println(map.size());
		
	}
}
