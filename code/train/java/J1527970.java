import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		StdIn in = new StdIn();
		String A=in.next();
		int[][] next = new int[A.length()][26];
		Arrays.fill(next[A.length()-1], A.length());
		for(int i=A.length()-2; i>=0; --i) {
			next[i]=Arrays.copyOf(next[i+1], 26);
			next[i][A.charAt(i+1)-'a']=i+1;
		}
		int[] dp = new int[A.length()+1];
		char[] nextChar = new char[A.length()];
		dp[A.length()]=0;
		for(int i=A.length()-1; i>=0; --i) {
			int min=Integer.MAX_VALUE;
			char minC=0;
			for(char c='a'; c<='z'; ++c) {
				if(dp[next[i][c-'a']]<min) {
					min=dp[next[i][c-'a']];
					minC=c;
				}
			}
			dp[i]=min+1;
			nextChar[i]=minC;
		}
		int[] next2 = Arrays.copyOf(next[0], 26);
		next2[A.charAt(0)-'a']=0;
		int min=Integer.MAX_VALUE;
		char minC=0;
		for(char c='a'; c<='z'; ++c) {
			if(dp[next2[c-'a']]<min) {
				min=dp[next2[c-'a']];
				minC=c;
			}
		}
		int i=next2[minC-'a'];
		System.out.print(minC);
		while(i<A.length()) {
			System.out.print(nextChar[i]);
			//if(nextChar[i]==A.charAt(i))
			//	System.out.print(nextChar[i]);
			i=next[i][nextChar[i]-'a'];
		}
		System.out.println();
	}
	
	interface Input {
		public String next();
		public String nextLine();
		public int nextInt();
		public long nextLong();
		public double nextDouble();
	}
	static class StdIn implements Input {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public StdIn() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
		
		public StdIn(String filename) {
			try{
				din = new DataInputStream(new FileInputStream(filename));
			} catch(Exception e) {
				throw new RuntimeException();
			}
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
		
		public String next() {
			int c;
			while((c=read())!=-1&&(c==' '||c=='\n'||c=='\r'));
			StringBuilder s = new StringBuilder();
			while (c != -1)
			{
				if (c == ' ' || c == '\n'||c=='\r')
					break;
				s.append((char)c);
				c=read();
			}
			return s.toString();
		}

		public String nextLine() {
			int c;
			while((c=read())!=-1&&(c==' '||c=='\n'||c=='\r'));
			StringBuilder s = new StringBuilder();
			while (c != -1)
			{
				if (c == '\n'||c=='\r')
					break;
				s.append((char)c);
				c = read();
			}
			return s.toString();
		}

		public int nextInt() {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
			{
				ret = ret * 10 + c - '0';
			}  while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}
		
		public int[] readIntArray(int n) {
			int[] ar = new int[n];
			for(int i=0; i<n; ++i)
				ar[i]=nextInt();
			return ar;
		}

		public long nextLong() {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
		
		public long[] readLongArray(int n) {
			long[] ar = new long[n];
			for(int i=0; i<n; ++i)
				ar[i]=nextLong();
			return ar;
		}

		public double nextDouble() {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');

			if (c == '.')
			{
				while ((c = read()) >= '0' && c <= '9')
				{
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() {
			try{
				if (bufferPointer == bytesRead)
					fillBuffer();
				return buffer[bufferPointer++];
			} catch(IOException e) {
				throw new RuntimeException();
			}
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}