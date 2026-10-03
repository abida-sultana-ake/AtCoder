import java.util.*;
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc=new Scanner(System.in);
		List<Node> l1 = new ArrayList<Node>();
		List<Node> l2 = new ArrayList<Node>();
		int n=sc.nextInt();
		for (int i=0;i<n;i++) {
			Node nd=new Node();
			nd.num=i;
			nd.x=sc.nextInt();
			nd.y=sc.nextInt();
			l1.add(nd);
			l2.add(nd);
		}
		
		Collections.sort(l1, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.x-n2.x;
			}
		});
		Collections.sort(l2, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.y-n2.y;
			}
		});
		
		List<Edge> l3=new ArrayList<Edge>();
		for(int i=0;i<n-1;i++) {
			Edge e=new Edge();
			e.from=l1.get(i).num;
			e.to=l1.get(i+1).num;
			e.length=l1.get(i+1).x-l1.get(i).x;
			l3.add(e);
			
			e=new Edge();

			e.from=l2.get(i).num;
			e.to=l2.get(i+1).num;
			e.length=l2.get(i+1).y-l2.get(i).y;
			l3.add(e);
		}
		
		Collections.sort(l3, new Comparator<Edge> () {
			public int compare(Edge e1, Edge e2) {
				return e1.length-e2.length;
			}
		});
		
		UnionFind u=new UnionFind(n);
		
		long price=0;
		
		for(Edge e : l3) {
			if(u.find(e.from)!=u.find(e.to)) {
				u.union(e.from,e.to);
				price+=e.length;
			}
		}
		
		System.out.println(price);
		
	}

}

class Node {
	int num;
	int x;
	int y;
}

class Edge  {
	int from;
	int to;
	int length;
}

class UnionFind {
	int[] parent;
	int[] rank;
	public UnionFind(int size) {
		parent = new int[size];
		rank = new int[size];
		for(int i=0;i<size;i++) {
			parent[i]=i;
			rank[i]=0;
		}
	}
	public int find(int x) {
		if(parent[x]==x) {
			return x;
		} else {
			return(find(parent[x]));
		}
	}
	public void union(int x, int y) {
		int xRoot=find(x);
		int yRoot=find(y);
		if(rank[xRoot] < rank[yRoot]) {
			parent[xRoot]=yRoot;
		} else if (rank[xRoot] > rank[yRoot]) {
			parent[yRoot]=xRoot;
		} else if (xRoot!=yRoot) {
			parent[yRoot]=xRoot;
			rank[xRoot]++;
		}
	}
}