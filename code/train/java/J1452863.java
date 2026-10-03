
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static class Reader {

		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public Reader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
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

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Reader sn = new Reader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		int n = sn.nextInt();
		int k = sn.nextInt();
		int a[] = new int[n];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sn.nextInt();
			
		}
	/*	int res=0;
		for(int i=0; i<=n-k; i++){
			int aux=0;
			int j=i;
			int cont=0;
			while(true){
				if(cont==k){
					break;
				}
				aux = aux+a[j];
				j++;
				cont++;
			}
			res = Math.max(res, aux);
		}
		**/
		int res=0;
		Arrays.sort(a);
		for(int i=n-k; i<n; i++){
			res+=a[i];
		}
		
		out.println(res);
		out.close();
	}

}