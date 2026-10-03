
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	int N = Integer.parseInt(scan.next());
	List<X> xList = new ArrayList<X>(N);
	List<X> yList = new ArrayList<X>(N);
	
	for (int i = 0; i < N; i++) {
	    xList.add(new X(Integer.parseInt(scan.next()), i));
	    yList.add(new X(Integer.parseInt(scan.next()), i));
	}
	Collections.sort(xList);
	Collections.sort(yList);

	List<Edge> list = new ArrayList<Edge>();
	for (int i = 0; i < N-1; i++) {
	    list.add(new Edge(xList.get(i).index, xList.get(i+1).index, Math.abs(xList.get(i).x - xList.get(i+1).x)));
	    list.add(new Edge(yList.get(i).index, yList.get(i+1).index, Math.abs(yList.get(i).x - yList.get(i+1).x)));
	}
	Collections.sort(list);

	UnionFind uf = new UnionFind(N);
	int total = 0;
	for(Iterator<Edge> itr = list.iterator(); itr.hasNext();) {
	    Edge e = itr.next();
	    int idx1 = e.from;
	    int idx2 = e.to;

	    if(uf.root(idx1) != uf.root(idx2)) {
		uf.connect(idx1, idx2);
		total += e.cost;
	    }
	}
	
	System.out.println(total);
	scan.close();
    }
}

class X implements Comparable<X> {
    int x;
    int index;

    X(int x, int index) {
	this.x = x;
	this.index = index;
	}

    @Override
    public int compareTo(X o) {
	return x - o.x;
    }
}

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;

    Edge(int from, int to, int cost) {
	this.from = from;
	this.to = to;
	this.cost = cost;
	}

    @Override
    public int compareTo(Edge o) {
	return cost - o.cost;
    }
    
}

class UnionFind {
    int[] uni;

    UnionFind(int N) {
	uni = new int[N];
	for (int i = 0; i < N; i++) {
	    uni[i] = -1;
	}
    }

    int root(int a) {
	if(uni[a] < 0) return a;
	else return uni[a] = root(uni[a]);
    }

    boolean connect(int a, int b) {
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
