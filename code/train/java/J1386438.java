import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays;
import java.math.*;

class Edge {
	public int u, v, w;
	public Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
}

class CompKey_e implements Comparator<Edge> {
	public int compare(Edge x, Edge y) {
		return x.w-y.w;
	}
}

class CompKey implements Comparator<Integer> {
	int[] val;
	public CompKey(int[] val) {	
		this.val = val;
	}
	public int compare(Integer x, Integer y) {
		return this.val[x]-this.val[y];
	}
}

class DisjointSet {
	int[] p;
	public DisjointSet(int n) {
		p = new int[n];
		for (int i = 0; i < n; ++i)
			p[i] = -1;
	}
	public int getRoot(int u) {
		if (p[u] == -1) return u;
		return p[u] = getRoot(p[u]);
	}
	public boolean isConnected(int u, int v) {
		u = getRoot(u); 
		v = getRoot(v);
		if (u == v) return true;
		p[u] = v;
		return false;
	}
}

class Main {
	static BufferedReader jvin = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter jvout = new PrintWriter(System.out);
	
	int N;
	int[] X_Coor, Y_Coor;
	Integer[] X_id, Y_id;
	Edge[] E;
	DisjointSet d;
	
	public static void main(String[] args) throws IOException {
		Main instance = new Main();
		instance.passStaticVar();
	}


	public void passStaticVar() throws IOException {
		N = Integer.parseInt(jvin.readLine());
		X_Coor = new int[N]; X_id = new Integer[N];
		Y_Coor = new int[N]; Y_id = new Integer[N];
		for (int i = 0; i < N; ++i) {
			String[] t = jvin.readLine().split(" ");
			X_Coor[i] = Integer.parseInt(t[0]);
			Y_Coor[i] = Integer.parseInt(t[1]);
			X_id[i] = Y_id[i] = i;
		}
		
		Arrays.sort(X_id, new CompKey(X_Coor));
		Arrays.sort(Y_id, new CompKey(Y_Coor));
		E = new Edge[2*N-2];
		int m = 0;
		for (int i = 1; i < N; ++i) {
			E[m++] = new Edge(X_id[i], X_id[i-1], X_Coor[X_id[i]]-X_Coor[X_id[i-1]]);
			E[m++] = new Edge(Y_id[i], Y_id[i-1], Y_Coor[Y_id[i]]-Y_Coor[Y_id[i-1]]);
		}
		Arrays.sort(E, new CompKey_e());
		d = new DisjointSet(N);
		long res = 0;
		for (int i = 0; i < m; ++i) 
			if (!d.isConnected(E[i].u, E[i].v)) 
				res += E[i].w;
		jvout.println(res);
		jvout.flush();
	}
}
