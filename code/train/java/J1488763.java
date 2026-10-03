import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";
	
	
	static class NP
	{
		Node r0, r1;

		public NP(Node r0, Node r1, int front) {
			this.r0 = r0;
			this.r1 = r1;
			this.front = front;
		}
		int front;
	}
	
	static void solve()
	{
		int n = ni();
		int[] p = na(n);
//		for(int i = 0;i < n;i++)p[i]--;
		
		// even
		Node root0 = null;
		Node root1 = null;
		for(int i = 0;i < n/2;i++){
			root0 = insert(root0, count(root0), new Node(p[2*i]));
			root1 = insert(root1, count(root1), new Node(p[2*i+1]));
		}
		PriorityQueue<NP> pq = new PriorityQueue<>((x, y) -> x.front - y.front);
		pq.add(new NP(root0, root1, root0.arg.v));
		
		for(int rep = 0;rep < n/2;rep++){
			NP cur = pq.poll();
			
			out.print(cur.front + " ");
			Node argmin = cur.r0.arg;
			int index = index(argmin);
//			tr("Z", index, count(cur.r0), count(cur.r1));
			Node[] r0 = split(cur.r0, index);
			Node[] r1 = split(cur.r1, index);
			r0[1] = erase(r0[1], 0);
			Node argmin2 = r1[1].arg;
			out.print(argmin2.v + " ");
			int index2 = index(argmin2);
			
			Node[] rr1 = split(r1[1], index2);
			rr1[1] = erase(rr1[1], 0);
			Node[] rr0 = split(r0[1], index2);
			
			if(r0[0] != null)pq.add(new NP(r0[0], r1[0], r0[0].arg.v));
			if(rr0[1] != null)pq.add(new NP(rr0[1], rr1[1], rr0[1].arg.v));
			if(rr1[0] != null)pq.add(new NP(rr1[0], rr0[0], rr1[0].arg.v));
		}
		out.println();
	}
	
	
	public static Random gen = new Random();
	
	static public class Node
	{
		public int v; // value
		public long priority;
		public Node left, right, parent;
		
		public int count;
		
		public int min; 
		public Node arg;
		
		public Node(int v)
		{
			this.v = v;
			priority = gen.nextLong();
			update(this);
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [v=");
			builder.append(v);
			builder.append(", count=");
			builder.append(count);
			builder.append(", parent=");
			builder.append(parent != null ? parent.v : "null");
			builder.append(", min=");
			builder.append(min);
			builder.append("]");
			return builder.toString();
		}
	}

	public static Node update(Node a)
	{
		if(a == null)return null;
		a.count = 1;
		if(a.left != null)a.count += a.left.count;
		if(a.right != null)a.count += a.right.count;
		
		a.min = a.v;
		a.arg = a;
		if(a.left != null){
			if(a.left.min < a.min){
				a.min = a.left.min;
				a.arg = a.left.arg;
			}
		}
		if(a.right != null){
			if(a.right.min < a.min){
				a.min = a.right.min;
				a.arg = a.right.arg;
			}
		}
		return a;
	}
	
	public static Node disconnect(Node a)
	{
		if(a == null)return null;
		a.left = a.right = a.parent = null;
		return update(a);
	}
	
	public static Node root(Node x)
	{
		if(x == null)return null;
		while(x.parent != null)x = x.parent;
		return x;
	}
	
	public static int count(Node a)
	{
		return a == null ? 0 : a.count;
	}
	
	public static void setParent(Node a, Node par)
	{
		if(a != null)a.parent = par;
	}
	
//	public static int min(Node a, int L, int R)
//	{
//		if(a == null || L >= R || L >= count(a) || R <= 0)return Integer.MAX_VALUE / 2;
//		if(L <= 0 && R >= count(a)){
//			return a.min;
//		}else{
//			int lmin = min(a.left, L, R);
//			int rmin = min(a.right, L-count(a.left)-1, R-count(a.left)-1);
//			int min = Math.min(lmin, rmin);
//			if(L <= count(a.left) && count(a.left) < R)min = Math.min(min, a.v);
//			return min;
//		}
//	}
	
//	public static void add(Node a, int L, int R, int V)
//	{
//		if(a == null || L >= R || L >= count(a) || R <= 0)return;
//		if(L <= 0 && R >= count(a)){
//			a.v += V;
//		}else{
//			add(a.left, L, R, V);
//			add(a.right, L-count(a.left)-1, R-count(a.left)-1, V);
//			if(L <= count(a.left) && count(a.left) < R)a.v += V;
//		}
//		update(a);
//	}
	
	public static Node merge(Node a, Node b)
	{
		if(b == null)return a;
		if(a == null)return b;
		if(a.priority > b.priority){
			setParent(a.right, null);
			setParent(b, null);
			a.right = merge(a.right, b);
			setParent(a.right, a);
			return update(a);
		}else{
			setParent(a, null);
			setParent(b.left, null);
			b.left = merge(a, b.left);
			setParent(b.left, b);
			return update(b);
		}
	}
	
	// [0,K),[K,N)
	public static Node[] split(Node a, int K)
	{
		if(a == null)return new Node[]{null, null};
		if(K <= count(a.left)){
			setParent(a.left, null);
			Node[] s = split(a.left, K);
			a.left = s[1];
			setParent(a.left, a);
			s[1] = update(a);
			return s;
		}else{
			setParent(a.right, null);
			Node[] s = split(a.right, K-count(a.left)-1);
			a.right = s[0];
			setParent(a.right, a);
			s[0] = update(a);
			return s;
		}
	}
	
	public static Node insert(Node a, int K, Node b)
	{
		if(a == null)return b;
		if(b.priority < a.priority){
			if(K <= count(a.left)){
				a.left = insert(a.left, K, b);
				setParent(a.left, a);
			}else{
				a.right = insert(a.right, K-count(a.left)-1, b);
				setParent(a.right, a);
			}
			return update(a);
		}else{
			Node[] ch = split(a, K);
			b.left = ch[0]; b.right = ch[1];
			setParent(b.left, b);
			setParent(b.right, b);
			return update(b);
		}
	}
	
	// delete K-th
	public static Node erase(Node a, int K)
	{
		if(a == null)return null;
		if(K < count(a.left)){
			a.left = erase(a.left, K);
			setParent(a.left, a);
			return update(a);
		}else if(K == count(a.left)){
			setParent(a.left, null);
			setParent(a.right, null);
			Node aa = merge(a.left, a.right);
			disconnect(a);
			return aa;
		}else{
			a.right = erase(a.right, K-count(a.left)-1);
			setParent(a.right, a);
			return update(a);
		}
	}
	
	public static Node get(Node a, int K)
	{
		while(a != null){
			if(K < count(a.left)){
				a = a.left;
			}else if(K == count(a.left)){
				break;
			}else{
				K = K - count(a.left)-1;
				a = a.right;
			}
		}
		return a;
	}
	
	static Node[] Q = new Node[100];
	public static Node update(Node a, int K, int v)
	{
		int p = 0;
		while(a != null){
			Q[p++] = a;
			if(K < count(a.left)){
				a = a.left;
			}else if(K == count(a.left)){
				break;
			}else{
				K = K - count(a.left)-1;
				a = a.right;
			}
		}
		a.v = v;
		while(p > 0){
			update(Q[--p]);
		}
		return a;
	}
	
	public static int index(Node a)
	{
		if(a == null)return -1;
		int ind = count(a.left);
		while(a != null){
			Node par = a.parent;
			if(par != null && par.right == a){
				ind += count(par.left) + 1;
			}
			a = par;
		}
		return ind;
	}
	
	public static Node[] nodes(Node a) { return nodes(a, new Node[count(a)], 0, count(a)); }
	public static Node[] nodes(Node a, Node[] ns, int L, int R)
	{
		if(a == null)return ns;
		nodes(a.left, ns, L, L+count(a.left));
		ns[L+count(a.left)] = a;
		nodes(a.right, ns, R-count(a.right), R);
		return ns;
	}
	
	public static String toString(Node a, String indent)
	{
		if(a == null)return "";
		StringBuilder sb = new StringBuilder();
		sb.append(toString(a.left, indent + "  "));
		sb.append(indent).append(a).append("\n");
		sb.append(toString(a.right, indent + "  "));
		return sb.toString();
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
