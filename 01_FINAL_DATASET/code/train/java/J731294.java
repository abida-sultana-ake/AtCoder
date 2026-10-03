import java.util.*;

public class Main{

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int N = sc.nextInt();
		
		long UD[][] = new long[N][2];
		
		for (int i = 0; i  < N; i++){
			UD[i][0] = sc.nextLong();
			UD[i][1] = sc.nextLong();
		}
		Arrays.sort(UD, cmp);
//		debug(UD);
		long T = 0;
		long X = 0;

		for (int i = 0; i < N; i++){
			T += UD[i][0];
			if (T > X) X = T;
			T -= UD[i][1];
		}
		
		System.out.println(X);
	}
	
	static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}	
	
	static Comparator<long[]> cmp = new Comparator<long[]>(){
		@Override
		public int compare(long[] a, long[] b) {
//			cool magic should be earlier
			long sa1 = a[0] - a[1];
			long sa2 = b[0] - b[1];
			if (sa1>0 & sa2<0) return 1;
			if (sa1<0 & sa2>0) return -1;
			
			long tmp1 = a[0] - a[1] + b[0];
			 tmp1 = Math.max(a[0], tmp1);
			long tmp2 = b[0] - b[1] + a[0];
			tmp2 = Math.max(b[0], tmp2);
			if (tmp1 > tmp2)
				return 1;
			else if(tmp1 < tmp2)
				return -1;
			else{
				if(a[1] > b[1] ){
//					System.out.println((a[1]-a[2])+" " + (b[1] -b[2]));
					return 1;
				}else{
					return -1;
				}
			}
		}
	};
	
	static class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}
		long nextLong() {
			return Long.parseLong(next());
		}

		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}

}
