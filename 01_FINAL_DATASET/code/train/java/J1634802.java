import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] g = new int[N][N];
		for(int i=0; i<M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			g[a][b] = 1;
			g[b][a] = 1;
		}
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=1; i<N; i++) {
			l.add(i);
		}
		System.out.println(dfs(0, l, g));
	}
	
	static int dfs(int c, ArrayList<Integer> l, int[][] g) {
		if(l.isEmpty()) return 1;
		int ret = 0;
		for(int i=0; i<l.size(); i++) {
			int next = l.get(i);
			if(g[c][next] == 1) {
				ArrayList<Integer> tmpl = (ArrayList<Integer>)l.clone();
				tmpl.remove(l.get(i));
				ret += dfs(next, tmpl, g);
			}
		}
		return ret;
	}
	
	static long lcm(long a, long b) {
		return a*(b/gcd(a, b));
	}
	
	static long gcd(long a, long b) {
		long ta = Math.max(a, b);
		long tb = Math.min(a, b);
		long tmp;
		while((tmp = ta%tb) != 0) {
			ta = tb;
			tb = tmp;
		}
		return tb;
	}
	
	static long modcomb(long n, long k, long mod) {
		if(k==1) {
			return n;
		}
		
		long ans = 1;
		for(long i=n; i>=n-k+1; i--) {
			ans = (ans * i)%mod;
		}
		for(long i=k; 0<i; i--) {
			ans = (ans * modpow(i, mod-2, mod)) % mod;
		}
		return ans;
	}
	
	static long modpow(long a, long b, long mod) {
		if(b==0) return 1;
		if(b%2==0) {
			long d = modpow(a, b/2, mod);
			return (d*d)%mod;
		} else {
			return (a*modpow(a, b-1, mod))%mod;
		}
	}
	
	static int disit(long a, long d) {
		int count = 0;
		while(a!=0) {
			a = a/d;
			count++;
		}
		return count;
	}
}
