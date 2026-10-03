import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class Main {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static double d(double x, double y, double x2, double y2) {
		double dx = x - x2;
		double dy = y - y2;
		return Math.sqrt(dx*dx + dy*dy);
	}

	static double[][][] undirectedGraph(int n, int[] v1, int[] v2, double[] cost) {
		int[] cnt = new int[n];
		for (int i : v1) cnt[i]++;
		for (int i : v2) cnt[i]++;

		double[][][] g = new double[n][][];
		for (int i=0; i<n; i++) g[i] = new double[cnt[i]][2];
		for (int i=0; i<v1.length; i++) {
			int s = v1[i];
			int t = v2[i];

			g[s][--cnt[s]][0] = t;
			g[s][cnt[s]][1] = cost[i];

			g[t][--cnt[t]][0] = s;
			g[t][cnt[t]][1] = cost[i];
		}

		return g;
	}

	static double[] dijkstra(double[][][] g, int source) {
		int n = g.length;

		final double[] d = new double[n];
		Arrays.fill(d, 1L<<60);
		d[source] = 0;

		TreeSet<Integer> pQ = new TreeSet<Integer>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				if (d[a] != d[b]) return Double.compare(d[a], d[b]);
				return a - b;
			}
		});
		pQ.add(source);

		while (!pQ.isEmpty()) {
			int cur = pQ.pollFirst();

			for (int i=0; i<g[cur].length; i++) {
				int next = (int)g[cur][i][0];
				double dist = d[cur] + g[cur][i][1];
				if (dist < d[next]) {
					pQ.remove(next);
					d[next] = dist;
					pQ.add(next);
				}
			}
		}

		return d;
	}

	static void solve() {
		int sx = in.nextInt();
		int sy = in.nextInt();
		int gx = in.nextInt();
		int gy = in.nextInt();
		int n = in.nextInt();
		double[][] p = new double[n+2][3];
		for (int i=0; i<n; i++) {
			for (int j=0; j<3; j++) {
				p[i][j] = in.nextDouble();
			}
		}

		p[n][0] = sx; p[n][1] = sy;
		p[n+1][0] = gx; p[n+1][1] = gy;

		ArrayList<Integer> s = new ArrayList<>();
		ArrayList<Integer> t = new ArrayList<>();
		ArrayList<Double> c = new ArrayList<>();
		for (int i=0; i<n+2; i++) {
			for (int j=i+1; j<n+2; j++) {
				s.add(i); t.add(j);
				double d = d(p[i][0], p[i][1], p[j][0], p[j][1]);
				c.add(Math.max(0, d - p[i][2] - p[j][2]));
			}
		}

		int m = s.size();
		int[] ss = new int[m];
		int[] tt = new int[m];
		double[] cc = new double[m];
		for (int i=0; i<m; i++) {
			ss[i] = s.get(i);
			tt[i] = t.get(i);
			cc[i] = c.get(i);
		}

		double[][][] g = undirectedGraph(n+2, ss, tt, cc);

		double[] d = dijkstra(g, n);
		dump(d);
		out.printf("%.12f\n",d[n+1]);
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		solve();
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}