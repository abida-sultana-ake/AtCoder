
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static int N;
    private static int K;
    private static int L;

    public static void main(String[] args) {
	N = Integer.parseInt(scan.next());
	K = Integer.parseInt(scan.next());
	L = Integer.parseInt(scan.next());

	UnionFind k = new UnionFind(N);
	UnionFind l = new UnionFind(N);
	
	for (int i = 0; i < K; i++) {
	    int p = Integer.parseInt(scan.next()) - 1;
	    int q = Integer.parseInt(scan.next()) - 1;
	    k.connect(p, q);
	}
	for (int i = 0; i < L; i++) {
	    int r = Integer.parseInt(scan.next()) - 1;
	    int s = Integer.parseInt(scan.next()) - 1;
	    l.connect(r, s);
	}

	Pair[] pairs = new Pair[N];
	Map<Pair, Integer> map = new HashMap<Pair, Integer>(N);
	for (int i = 0; i < N; i++) {
	    pairs[i] = new Pair(k.root(i), l.root(i));
	    if(map.containsKey(pairs[i])) {
		int count = map.get(pairs[i]).intValue();
		map.put(pairs[i], count+1);
	    } else {
		map.put(pairs[i], 1);
	    }
	}

	for (int i = 0; i < N; i++) {
	    if(i>0) System.out.print(' ');
	    System.out.print(map.get(pairs[i]).intValue());
	}
	System.out.println();
	scan.close();
    }

    private static class UnionFind {
	int[] uni;

	public UnionFind(int N) {
	    uni = new int[N];
	    for (int i = 0; i < N; i++) {
		uni[i] = -1;
	    }
	}

	public int root(int a) {
	    if(uni[a] < 0) return a;
	    else return uni[a] = root(uni[a]);
	}

	public boolean connect(int a, int b) {
	    a = root(a);
	    b = root(b);

	    if(a == b) return false;
	    if(uni[a] > uni[b]) {
		int tmp = a;
		a = b;
		b = tmp;
	    }
	    uni[a] += uni[b];
	    uni[b] = a;
	    return true;
	}
    }

    private static class Pair {
	private final int x;
	private final int y;

	public Pair(int x, int y) {
	    this.x = x;
	    this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
	    if(obj instanceof Pair) {
		Pair p = (Pair)obj;
		return this.x == p.x && this.y == p.y;
	    } else {
		return false;
	    }
	}

	@Override
	public int hashCode() {
	    return Objects.hash(x, y);
	}
    }
}
