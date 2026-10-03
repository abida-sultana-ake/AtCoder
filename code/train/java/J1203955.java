import java.util.*;
 
// ABC 21-C
// http://abc021.contest.atcoder.jp/tasks/abc021_c
 
public class Main {
	
	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int a = in.nextInt() - 1;
		int b = in.nextInt() - 1;
		
		ArrayList[] map = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		int m = in.nextInt();
		for (int i = 0; i < m; i++) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			
			map[x].add(y);
			map[y].add(x);
		}
		
		
		int[] numWay = new int[n]; // numWay[x] stores the number of way to reach x with minimum way
		int[] dist = new int[n];   // dist[x] stores the minimum path took to reach x
		int[] visited = new int[n];
		
		boolean isAnswerFound = false;
		
		// Stores prevNode, currNode, distToCurr
		ArrayList<Integer> q = new ArrayList<Integer>();
		q.add(-1);
		q.add(a);
		q.add(0);
		
		while (q.size() > 0) {
			int prev = q.remove(0);
			int curr = q.remove(0);
			int distToCurr = q.remove(0);

			// If it is already investigated,
			if (visited[curr] == 1) {
				// And if the distance to next is equal to that node
				if (dist[curr] == distToCurr) {
					numWay[curr] += numWay[prev];
					numWay[curr] %= 1000000007;
				}
				continue;
			}
			visited[curr] = 1;
			numWay[curr] = prev == -1 ? 1 : numWay[prev];
			dist[curr] = distToCurr;
			
			for (int i = 0; i < map[curr].size(); i++) {
				int next = (int) map[curr].get(i);
				
				if (visited[next] == 0) {
					q.add(curr);
					q.add(next);
					q.add(distToCurr + 1);
				} else if (dist[next] == distToCurr + 1) {
//					System.out.println("come here");
//					numWay[next] += numWay[curr];
//					numWay[curr] %= 1000000007;
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//			System.out.printf("%d: %d\n", i, numWay[i]);
//		}
		System.out.println(numWay[b]);
	}
}
