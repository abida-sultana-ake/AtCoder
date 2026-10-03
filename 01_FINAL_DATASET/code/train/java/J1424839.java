import java.util.*;

public class Main {
	static class Tree {
		public class Edge {
			int to, rev;

			public Edge(int to, int rev) {
				this.to = to;
				this.rev = rev;
			}
		}
		
		int V;
		ArrayList<ArrayList<Edge>> G;
		int root;
		int[] p;
		int[] depth;
		int[] childNum;
		
		public Tree(int[] a, int[] b) {
			this.V = a.length+1;
			p = new int[V];
			depth = new int[V];
			childNum = new int[V];
			
			G = new ArrayList<ArrayList<Edge>>();
			for(int i=0; i<V; i++) {
				G.add(new ArrayList<Edge>());
			}
			
			for(int i=0; i<V-1; i++) {
				G.get(a[i]).add(new Edge(b[i], G.get(b[i]).size()));
				G.get(b[i]).add(new Edge(a[i], G.get(a[i]).size()-1));
			}
			setRoot(0);
		}
		
		public void setRoot(int root) {
			this.root = root;
			setRoot(root, -1);
		}
		public void setRoot(int cur, int parent) {
			p[cur] = parent;
			if(parent!=-1)
				depth[cur] = depth[parent]+1;
			childNum[cur] = 1;
			for(int i=0; i<G.get(cur).size(); i++) {
				int next = G.get(cur).get(i).to;
				if(next!=parent) {
					setRoot(next, cur);
					childNum[cur] += childNum[next];
				}
			}
		}
		
		public int getDepth(int idx) {
			return depth[idx];
		}
		
		public int getAncesstor(int idx, int x) {
			while(x>0) {
				idx = p[idx];
				x--;
			}
			return idx;
		}
		
		public int countChild(int idx) {
			return childNum[idx];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] a = new int[N-1];
		int[] b = new int[N-1];
		for(int i=0; i<N-1; i++) {
			a[i] = sc.nextInt()-1;
			b[i] = sc.nextInt()-1;
		}
		Tree t = new Tree(a, b);
		
		int depth = t.getDepth(N-1);
		int whiteRoot = t.getAncesstor(N-1, (depth-1)/2);

		System.out.println(t.countChild(whiteRoot)>=(N+1)/2 ? "Snuke" : "Fennec");
		
		sc.close();
	}
}
