import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		ContestScanner scan = new ContestScanner();
		
		final int N = scan.nextInt();
		Box[] boxes = new Box[N];
		
		for(int i=0; i < N; i++)
		{
			int w = scan.nextInt();
			int h = scan.nextInt();
			
			boxes[i] = new Box(w, h);
		}
		
		(new Solve(N, boxes)).solve();
	}
}

class Box implements Comparable<Box> {
	public final int h;
	public final int w;
	
	public Box(final int w, final int h)
	{
		this.w = w;
		this.h = h;
	}
	
	public int compareTo(Box o)
	{
		return (this.w == o.w) ? ((this.h == o.h) ? 0 : this.h < o.h ? -1 : 1) : (this.w < o.w) ? -1 : 1; 
	}
}
	
class SegmentTree {
	private int[] tree;
	private int size;
	
	public SegmentTree(int size)
	{
		this.size = 1;
		
		while(this.size < size) this.size *= 2;
		
		tree = new int[this.size*2];
		
		Arrays.fill(tree, 0);
	}
	
	private int marge(int l, int r)
	{
		return Math.max(l, r);
	}
	
	public int update(int k, int v)
	{
		k += this.size-1;
		
		tree[k] = v;
		
		while(k > 0)
		{
			k = (k - 1) / 2;
			
			tree[k] = marge(tree[k*2+1], tree[k*2+2]);
		}
		
		return v;
	}
	
	public int query(int start, int end, int k, int l, int r)
	{
		if(r <= start || end <= l) return 0;
		else if(start <= l && r <= end) return tree[k];
		int lv = query(start, end, k*2+1, l, (l+r)/2);
		int rv = query(start, end, k*2+2, (l+r)/2, r);
		
		return marge(lv, rv);
	}
	
	public int query(int start, int end)
	{
		return query(start, end, 0, 0, this.size);
	}
}

class Solve {
	int N;
	Box[] boxes;
	
	public Solve(final int N, final Box[] boxes)
	{
		this.N = N;
		this.boxes = boxes;
	}
	
	public void solve()
	{
		Arrays.sort(this.boxes);
		
		SegmentTree st = new SegmentTree(100001);
		
		int answer = 0;
		
		int[] dp = new int[N];
		
		Arrays.fill(dp, 0);
		
		for(int i=0, len=N; i < len; )
		{
			int nexti = i+1;
			
			while(nexti < len && boxes[i].w == boxes[nexti].w) nexti++;
			
			for(int j=i; j < nexti; j++)
			{
				dp[j] = st.query(0, boxes[j].h) + 1;
				
				if(dp[j] > answer) answer = dp[j];
			}
			
			for(int j=i; j < nexti; j++)
			{
				st.update(boxes[j].h, Math.max(dp[j], st.query(boxes[j].h, boxes[j].h+1)));
			}
			
			i = nexti;
		}
		
		System.out.println(answer);
	}
}	
class ContestScanner {
	BufferedReader reader;
	String[] line;
	int index;
	public ContestScanner() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public ContestScanner(String filename) throws FileNotFoundException {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
	}
	
	public String nextToken() throws IOException {
		if(line == null || index >= line.length)
		{
			line = reader.readLine().trim().split(" ");
			index = 0;
		}
		
		return line[index++];
	}
	
	public String next() throws IOException {
		return nextToken();
	}
	
	public String readLine() throws IOException {
		line = null;
		index = 0;
		
		return reader.readLine();
	}
	
	public int nextInt() throws IOException, NumberFormatException {
		return Integer.parseInt(nextToken());
	}
	
	public long nextLong() throws IOException, NumberFormatException {
		return Long.parseLong(nextToken());
	}
	
	public double nextDouble() throws IOException, NumberFormatException {
		return Double.parseDouble(nextToken());
	}
	
	public int[] nextIntArray(int N) throws IOException, NumberFormatException {
		int[] result = new int[N];
		
		for(int i=0; i < N; i++) result[i] = nextInt();
		
		return result;
	}
	
	public long[] nextLongArray(int N) throws IOException, NumberFormatException {
		long[] result = new long[N];
		
		for(int i=0; i < N; i++) result[i] = nextLong();
		
		return result;
	}
	
	public double[] nexDoubleArray(int N) throws IOException, NumberFormatException {
		double[] result = new double[N];
		
		for(int i=0; i < N; i++) result[i] = nextDouble();
		
		return result;
	}
}
