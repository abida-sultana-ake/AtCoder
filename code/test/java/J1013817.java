import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int INF = Integer.MAX_VALUE / 2;
	static LinkedList<edge>[] g1, g2;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N, M, T;
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		T = scanner.nextInt();
		
		int[] money = new int[N];
		for(int i = 0; i < N; i++){
			money[i] = scanner.nextInt();
		}
		
		g1 = new LinkedList[N];
		g2 = new LinkedList[N];
		
		for(int i = 0; i < N; i++){
			g1[i] = new LinkedList<edge>();
			g2[i] = new LinkedList<edge>();
		}
		
		for(int i = 0; i < M; i++){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();

			
			g1[a-1].add(new edge(b - 1, c));
			g2[b-1].add(new edge(a - 1, c));
		}
		
		int [] d1 = dijkstra(0,g1);
		int [] d2 = dijkstra(0,g2);
		
		
		long ans = 0;
		for(int i = 0; i < N; i++){
			ans = Math.max(ans, (long)(T - d1[i] - d2[i]) * money[i]);
		}
		
		System.out.println(ans);
	}

	
	static class edge{
		int to;
		int cost;
		public edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	
	static class node implements Comparable <node>{
		int id;
		int cost;
		
		public node(int id, int cost){
			this.id = id;
			this.cost = cost;
		}
		
		public int compareTo(node o){
			return this.cost - o.cost; 
		}
	}
	
	static public int[] dijkstra(int start, LinkedList<edge>[] g){
		int[] distance = new int[g.length];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		Queue<node> q = new PriorityQueue<node>();
		q.add(new node(start, 0));
		
		boolean[] used = new boolean[g.length];
		Arrays.fill(used, false);
		
		while(q.size() > 0){
			node now = q.poll();
			if(used[now.id] == true)continue;
			used[now.id] = true;
			
			for(Iterator<edge> it = g[now.id].iterator();it.hasNext();){
				edge next = it.next();
				if(distance[next.to] > distance[now.id] + next.cost){
					distance[next.to] = distance[now.id] + next.cost;
					q.add(new node(next.to, distance[next.to]))	;
				}
			}
		}
		
		
		return distance;
	}
}
