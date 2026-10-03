import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";
	
	static void solve()
	{
		int h = ni(), w = ni(), n = ni();
		LongHashSet co = new LongHashSet();
		for(int i = 0;i < n;i++){
			long r = nl()-1, c = nl()-1;
			co.add(r*w+c);
		}
		
		long[] F = new long[10];
		F[0] = (long)(h-2)*(w-2);
		for(int itr = co.next(0);itr < co.scale;itr = co.next(itr+1)){
			long r = co.keys[itr]/w, c = co.keys[itr]%w;
			for(int k = 0;k < 3;k++){
				inner:
				for(int l = 0;l < 3;l++){
					long br = r-k, bc = c-l;
					if(br >= 0 && br+2 < h && bc >= 0 && bc+2 < w){
						boolean ped = false;
						int ct = 0;
						for(int u = 0;u < 3;u++){
							for(int v = 0;v < 3;v++){
								if(u == k && l == v)ped = true;
								long code = (br+u)*w+(bc+v);
								boolean has = co.contains(code);
								if(!ped && has)continue inner;
								if(has)ct++;
							}
						}
						if(ct > 0){
							F[0]--;
							F[ct]++;
						}
					}
				}
			}
		}
		for(int i = 0;i <= 9;i++){
			out.println(F[i]);
		}
	}
	
	public static class LongHashSet {
		public long[] keys;
		public boolean[] allocated;
		private int scale = 1<<2;
		private int rscale = 1<<1;
		private int mask = scale-1;
		public int size = 0;
		
		public LongHashSet(){
			allocated = new boolean[scale];
			keys = new long[scale];
		}
		
		public boolean contains(long x)
		{
			int pos = h(x)&mask;
			while(allocated[pos]){
				if(x == keys[pos])return true;
				pos = pos+1&mask;
			}
			return false;
		}
		
		public boolean add(long x)
		{
			int pos = h(x)&mask;
			while(allocated[pos]){
				if(x == keys[pos])return false;
				pos = pos+1&mask;
			}
			if(size == rscale){
				resizeAndAdd(x);
			}else{
				keys[pos] = x;
				allocated[pos] = true;
			}
			size++;
			return true;
		}
		
		public boolean remove(long x)
		{
			int pos = h(x)&mask;
			while(allocated[pos]){
				if(x == keys[pos]){
					size--;
					// take last and fill rmpos
					int last = pos;
					pos = pos+1&mask;
					while(allocated[pos]){
						int lh = h(keys[pos])&mask;
						// lh <= last < pos
						if(
								lh <= last && last < pos ||
								pos < lh && lh <= last ||
								last < pos && pos < lh
								){
							keys[last] = keys[pos];
							last = pos;
						}
						pos = pos+1&mask;
					}
					keys[last] = 0;
					allocated[last] = false;
					
					return true;
				}
				pos = pos+1&mask;
			}
			return false;
		}
		
		private void resizeAndAdd(long x)
		{
			int nscale = scale<<1;
			int nrscale = rscale<<1;
			int nmask = nscale-1;
			boolean[] nallocated = new boolean[nscale];
			long[] nkeys = new long[nscale];
			for(int i = next(0);i < scale;i = next(i+1)){
				long y = keys[i];
				int pos = h(y)&nmask;
				while(nallocated[pos])pos = pos+1&nmask;
				nkeys[pos] = y;
				nallocated[pos] = true;
			}
			{
				int pos = h(x)&nmask;
				while(nallocated[pos])pos = pos+1&nmask;
				nkeys[pos] = x;
				nallocated[pos] = true;
			}
			allocated = nallocated;
			keys = nkeys;
			scale = nscale;
			rscale = nrscale;
			mask = nmask;
		}
		
		public int next(int itr)
		{
			while(itr < scale && !allocated[itr])itr++;
			return itr;
		}
		
		
//		public int h(int x)
//		{
//			x ^= x>>>16;
//			x *= 0x85ebca6b;
//			x ^= x>>>13;
//			x *= 0xc2b2ae35;
//			x ^= x>>>16;
//			return x;
//		}
		
		private int h(long x)
		{
			x ^= x>>>33;
			x *= 0xff51afd7ed558ccdL;
			x ^= x>>>33;
			x *= 0xc4ceb9fe1a85ec53L;
			x ^= x>>>33;
			return (int)(x^x>>>32);
		}
		
		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			for(int i = next(0);i < scale;i = next(i+1)){
				sb.append(",");
				sb.append(keys[i]);
			}
			return sb.length() == 0 ? "" : sb.substring(1);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		long S = System.currentTimeMillis();
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		solve();
		out.flush();
		long G = System.currentTimeMillis();
		tr(G-S+"ms");
	}
	
	private static boolean eof()
	{
		if(lenbuf == -1)return true;
		int lptr = ptrbuf;
		while(lptr < lenbuf)if(!isSpaceChar(inbuf[lptr++]))return false;
		
		try {
			is.mark(1000);
			while(true){
				int b = is.read();
				if(b == -1){
					is.reset();
					return true;
				}else if(!isSpaceChar(b)){
					is.reset();
					return false;
				}
			}
		} catch (IOException e) {
			return true;
		}
	}
	
	private static byte[] inbuf = new byte[1024];
	static int lenbuf = 0, ptrbuf = 0;
	
	private static int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
//	private static boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
	private static int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private static double nd() { return Double.parseDouble(ns()); }
	private static char nc() { return (char)skip(); }
	
	private static String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private static char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private static char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private static int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private static int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}
