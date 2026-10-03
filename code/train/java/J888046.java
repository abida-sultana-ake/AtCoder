import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
 
import java.util.*;
 
public class Main {
	int N,M,Q;
	int[] rank,uf;
	ArrayList<F> query;
	
	private class F{
		int a,b,c,type;
		public F(int type,int a,int b,int c){
			this.type = type;
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	private class P{
		int f,s;
		public P(int f,int s){
			this.f = f;
			this.s = s;
		}
	}
	
	public void init(){
		uf = new int[N];
		rank = new int[N];
		
		for(int i = 0;i < N;i++){
			uf[i] = i;
			rank[i] = 1;
		}
	}
	
	public boolean same(int x,int y){
		return find(x) == find(y);
	}
	
	public int find(int x){
		if(uf[x] == x)return x;
		return uf[x] = find(uf[x]);
	}
	
	public void unite(int x,int y){
		x = find(x);
		y = find(y);
		
		if(x == y)return;
		
		if(x < y){
			uf[x] = y;
			rank[x] += rank[y];
			rank[y] = rank[x];
		}else{
			uf[y] = x;
			rank[y] += rank[x];
			rank[x] = rank[y];
		}
	}
	
	public void solve() {
		N = nextInt();
		M = nextInt();
		init();
		query = new ArrayList<F>();
		for(int i = 0;i < M;i++){
			int a = nextInt() - 1;
			int b = nextInt() - 1;
			int y = nextInt();
			
			query.add(new F(1,y,a,b));
		}
		
		Q = nextInt();
		for(int i = 0;i < Q;i++){
			int v = nextInt() - 1;
			int w = nextInt();
			query.add(new F(2,w,v,i));
		}
		
		Collections.sort(query,new Comparator<F>(){
			public int compare(F f1,F f2){
				if(f1.a == f2.a){
					return f2.type - f1.type;
				}
				return f2.a - f1.a;
			}
		});
		ArrayList<P> ans = new ArrayList<P>();
		for(F f : query){
			if(f.type == 1){
				unite(f.b,f.c);
			}else{
				ans.add(new P(f.c,rank[find(f.b)]));
			}
		}
		
		Collections.sort(ans,new Comparator<P>(){
			public int compare(P p1,P p2){
				return p1.f - p2.f;
			}
		});
		
		for(int i = 0;i < ans.size();i++){
			out.println(ans.get(i).s);
		}
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