import java.util.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		Node[] nodes=new Node[n];
		Edge[] edges=new Edge[n-1];
		
		for(int i=0;i<n;i++) {
			nodes[i]= new Node();
			nodes[i].no=i;
		}
		

		for (int i=0;i<n-1;i++) {
			Edge e=new Edge();
			int a=sc.nextInt();
			int b=sc.nextInt();
			e.from=nodes[a-1];
			e.to=nodes[b-1];
			nodes[a-1].edges.add(e);
			nodes[b-1].edges.add(e);
			edges[i]=e;
		}
		List<Node>path = new ArrayList<Node>();
		path.add(nodes[0]);
		path=dfs(nodes,edges, path, nodes[n-1], new boolean[n]);
		
		for(int i=0;i<path.size();i++) {
			if(i*2<path.size()) {
				path.get(i).color=1;
			}
			else {
				path.get(i).color=-1;
			}
		}
		
		dfs2(nodes,edges,nodes[0], new boolean[n],(byte)1);
		dfs2(nodes,edges,nodes[n-1], new boolean[n],(byte)-1);

		int fennec=0;
		int snuke=0;
		for(int i=0;i<n;i++) {
			if(nodes[i].color==1) {
				fennec++;
			}
			else {
				snuke++;
			}
		}
		System.out.println(fennec>snuke ? "Fennec" : "Snuke");
	}
	
	static List<Node> dfs(Node[] nodes, Edge[] edges, List<Node> path, Node destination, boolean[] looked) {
		Node current=path.get(path.size()-1);
		if(current==destination) {
			return path;
		}
		else {
			looked[current.no]=true;
			for (Edge e : current.edges) {
				Node next= e.from==current ? e.to : e.from;
				if(!looked[next.no]) {
				path.add(next);
				return dfs(nodes, edges, path, destination, looked);
				}
			}
			path.remove(path.size()-1);
			return dfs(nodes,edges,path,destination,looked);
		}
	}
	
	static void dfs2 (Node[] nodes, Edge[] edges, Node current, boolean[] looked, byte color) {
		looked[current.no]=true;
		current.color=color;
		for(Edge e : current.edges) {
			Node next= e.from==current ? e.to : e.from;
			if(!looked[next.no] && color*next.color!=-1) {
			dfs2(nodes, edges, next, looked, color);
			}
		}
	}
}

class Node {
	int no;
	List<Edge> edges=new ArrayList<Edge>();
	byte color;
}

class Edge {
	Node from;
	Node to;
}