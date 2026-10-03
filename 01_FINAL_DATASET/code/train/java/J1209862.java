import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeMap;
 
public class Main {
	static ContestScanner in;static Writer out;static StringBuilder sb=new StringBuilder();
	public static void main(String[] args)
	{try{in=new ContestScanner();out=new Writer();Main solve=new Main();solve.solve();
//	{try{in=new ContestScanner("in");out=new Writer("out");Main solve=new Main();solve.solve();
	in.close();out.flush();out.close();}catch(IOException e){e.printStackTrace();}}
	static void dump(int[]a,int n){for(int i=0;i<a.length;i++)out.printf("%"+n+"d ",a[i]);out.println();}
	static long pow(long a,int n){long r=1;while(n>0){if((n&1)==1)r*=a;a*=a;n>>=1;}return r;}
	static String itob(int a,int l){return String.format("%"+l+"s",Integer.toBinaryString(a)).replace(' ','0');}
	@SuppressWarnings("unchecked")
	static List<Integer>[]graph(int n){List<Integer>[]g=new List[n];
	for(int i=0;i<n;i++)g[i]=new ArrayList<>();return g;}
	void solve() throws NumberFormatException, IOException{
		int n = in.nextInt();
		int m = in.nextInt();
		long x0 = 0, y0 = 0;
		long X = 0, Y = 0;
		x0 = in.nextLong();
		for(int i=1; i<n; i++){
			long x = in.nextLong();
			X = (X+(x-x0)*coef(i, n-1))%mod;
			x0 = x;
		}
		y0 = in.nextLong();
		for(int i=1; i<m; i++){
			long y = in.nextLong();
			Y = (Y+(y-y0)*coef(i, m-1))%mod;
			y0 = y;
		}
		System.out.println(X*Y%mod);
	}
	
	final long mod = 1000000007;
	// 1-indexed
	long coef(long id, long n){
		final long min = Math.min(id, n-id+1);
		final long max = Math.max(id, n-id+1);
		return sum(min) + sum(n-max+1) + (max-min-1)*min%mod;
	}
	
	long sum(long n){
		return n*(n+1)%mod*modinv(2, mod)%mod;
	}
	
	long modinv(long n, long mod){
		return modpow(n, mod-2, mod);
	}
	
	long modpow(long n, long a, long mod){
		long res = 1;
		while(a > 0){
			if((a&1)==1) res = (res*n)%mod;
			n = (long)(((long)n*n)%mod);
			a >>= 1;
		}
		return (long)res;
	}
}

@SuppressWarnings("serial")
class MultiSet<T> extends HashMap<T, Integer>{
	@Override public Integer get(Object key){return containsKey(key)?super.get(key):0;}
	public void add(T key,int v){put(key,get(key)+v);}
	public void add(T key){put(key,get(key)+1);}
	public void sub(T key){final int v=get(key);if(v==1)remove(key);else put(key,v-1);}
	public MultiSet<T> merge(MultiSet<T> set)
	{MultiSet<T>s,l;if(this.size()<set.size()){s=this;l=set;}else{s=set;l=this;}
	for(Entry<T,Integer>e:s.entrySet())l.add(e.getKey(),e.getValue());return l;}
}
class Pair implements Comparable<Pair>{
	int a,b;final int hash;Pair(int a,int b){this.a=a;this.b=b;hash=(a<<16|a>>16)^b;}
	public boolean equals(Object obj){Pair o=(Pair)(obj);return a==o.a&&b==o.b;}
	public int hashCode(){return hash;}
	public int compareTo(Pair o){if(a!=o.a)return a<o.a?-1:1;else if(b!=o.b)return b<o.b?-1:1;return 0;}
	@Override
	public String toString() {
		return String.format("(%d, %d)", a, b);
	}
}
class Writer extends PrintWriter{
	public Writer(String filename)throws IOException
	{super(new BufferedWriter(new FileWriter(filename)));}
	public Writer()throws IOException{super(System.out);}
}
class ContestScanner implements Closeable{
	private BufferedReader in;private int c=-2;
	public ContestScanner()throws IOException 
	{in=new BufferedReader(new InputStreamReader(System.in));}
	public ContestScanner(String filename)throws IOException
	{in=new BufferedReader(new InputStreamReader(new FileInputStream(filename)));}
	public String nextToken()throws IOException {
		StringBuilder sb=new StringBuilder();
		while((c=in.read())!=-1&&Character.isWhitespace(c));
		while(c!=-1&&!Character.isWhitespace(c)){sb.append((char)c);c=in.read();}
		return sb.toString();
	}
	public String readLine()throws IOException{
		StringBuilder sb=new StringBuilder();if(c==-2)c=in.read();
		while(c!=-1&&c!='\n'&&c!='\r'){sb.append((char)c);c=in.read();}
		return sb.toString();
	}
	public long nextLong()throws IOException,NumberFormatException
	{return Long.parseLong(nextToken());}
	public int nextInt()throws NumberFormatException,IOException
	{return(int)nextLong();}
	public double nextDouble()throws NumberFormatException,IOException 
	{return Double.parseDouble(nextToken());}
	public void close() throws IOException {in.close();}
}