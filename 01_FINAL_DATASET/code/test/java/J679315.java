import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
 
public class Main {
	public static void main(String[] args) throws NumberFormatException,
	IOException {Solve solve = new Solve();solve.solve();}
}
class Solve{
	void dump(int[]a){for(int i=0;i<a.length;i++)System.out.print(a[i]+" ");System.out.println();}
	void dump(int[]a,int n){for(int i=0;i<a.length;i++)System.out.printf("%"+n+"d",a[i]);System.out.println();}
	void dump(long[]a){for(int i=0;i<a.length;i++)System.out.print(a[i]+" ");System.out.println();}
	void dump(char[]a){for(int i=0;i<a.length;i++)System.out.print(a[i]);System.out.println();}
	String itob(int a,int l){return String.format("%"+l+"s",Integer.toBinaryString(a)).replace(' ','0');}
	void solve() throws NumberFormatException, IOException{
		final ContestScanner in = new ContestScanner();
		Writer out = new Writer();
		int n = in.nextInt();
		int m = in.nextInt();
		int t = in.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
		}
		List<Edge>[] city = new List[n];
		List<Edge>[] rcity = new List[n];
		for(int i=0; i<n; i++){
			city[i] = new ArrayList<>();
			rcity[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++){
			int ca = in.nextInt()-1;
			int cb = in.nextInt()-1;
			int c = in.nextInt();
			city[ca].add(new Edge(cb, c));
			rcity[cb].add(new Edge(ca, c));
		}
		long[] distGo = dijkstra(city, n);
		long[] distBack = dijkstra(rcity, n);
		long max = 0;
		for(int i=0; i<n; i++){
			if(distGo[i]+distBack[i]>t) continue;
			long earn = (t-distGo[i]-distBack[i])*a[i];
			if(earn>max) max = earn;
		}
		System.out.println(max);
	}
	
	long[] dijkstra(List<Edge>[] city, int n){
		Queue<Pos> qu = new PriorityQueue<>();
		BitSet used = new BitSet(n);
		qu.add(new Pos(0, 0));
		long[] dist = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE/2);
		while(!qu.isEmpty()){
			Pos pos = qu.poll();
			if(used.get(pos.p)) continue;
			used.set(pos.p);
			dist[pos.p] = pos.cost;
			for(Edge e: city[pos.p]){
				qu.add(new Pos(e.to, pos.cost+e.cost));
			}
		}
		return dist;
	}
}

class Pos implements Comparable<Pos>{
	long cost;
	int p;
	Pos(int p, long cost){
		this.cost = cost;
		this.p = p;
	}
	@Override
	public int compareTo(Pos o) {
		return Long.compare(cost, o.cost);
	}
}

class Edge{
	int to, cost;
	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}

class MultiSet<T> extends HashMap<T, Integer>{
	@Override
	public Integer get(Object key){return containsKey(key)?super.get(key):0;}
	public void add(T key,int v){put(key,get(key)+v);}
	public void add(T key){put(key,get(key)+1);}
	public void sub(T key)
	{final int v=get(key);if(v==1)remove(key);else put(key,v-1);}
}
class Timer{
	long time;
	public void set(){time=System.currentTimeMillis();}
	public long stop(){return time=System.currentTimeMillis()-time;}
	public void print()
	{System.out.println("Time: "+(System.currentTimeMillis()-time)+"ms");}
	@Override public String toString(){return"Time: "+time+"ms";}
}
class Writer extends PrintWriter{
	public Writer(String filename)throws IOException
	{super(new BufferedWriter(new FileWriter(filename)));}
	public Writer()throws IOException{super(System.out);}
}
class ContestScanner {
	private InputStreamReader in;private int c=-2;
	public ContestScanner()throws IOException 
	{in=new InputStreamReader(System.in);}
	public ContestScanner(String filename)throws IOException
	{in=new InputStreamReader(new FileInputStream(filename));}
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
}