import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Nurie nurie = new Nurie();
		nurie.exec();
	}
}

class Nurie {
	
	int N;
	List<Integer>[] adj;
	
	long[] dpF;
	long[] dpG;

	
	long MOD = (long) Math.pow(10, 9) + 7;
	
	Nurie() {
		Scanner cin = new Scanner(System.in);
		this.N = cin.nextInt();
		this.adj = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			int a = cin.nextInt() - 1;
			int b = cin.nextInt() - 1;
			adj[a].add(b);
			adj[b].add(a);
		}
		
		this.dpF = new long[N];
		this.dpG = new long[N];
	}
	
	void exec() {
		
		long ans = f(0, -1);
		System.out.println(ans % MOD);
	}
	
	long f(int x, int p) {	
		if (dpF[x] > 0)
			return dpF[x];
		
		if (adj[x].size() == 1 && adj[x].get(0) == p)
			return 2;
		
		long white = g(x, p);
		long black = 1;
		for (int child: adj[x]) {
			if (child == p)
				continue;
			
			black *= g(child, x) % MOD;
			black %= MOD;
		}
		return dpF[x] = (white + black) % MOD;
	}
	
	long g(int x, int p) {
		
		if (dpG[x] > 0)
			return dpG[x];
		
		if (adj[x].size() == 1 && adj[x].get(0) == p)
			return 1;
		
		long count = 1;
		for (int child: adj[x]) {
			if (child == p)
				continue;
			
			count *= f(child, x) % MOD;
			count %= MOD;
		}
		return dpG[x] = count;
	}
	
}
