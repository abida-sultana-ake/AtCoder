import java.util.*;

public class Main{

        static int h;
	static int w;
	static int t;
	static char[][] map;
	
	static int startr = 0;
	static int startc = 0;
	static int goalr = 0;
	static int goalc = 0;
	
	static boolean canReachGoal;
	static int[] dx = new int[]{-1, 0, 1, 0};
	static int[] dy = new int[]{0, -1, 0, 1};

	public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
		
		h = in.nextInt();
		w = in.nextInt();
		t = in.nextInt();
		
		map = new char[h][w];
		for (int i = 0; i < h; i++) {
			map[i] = in.next().toCharArray();
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 'S') {
					startr = i;
					startc = j;
				}
				if (map[i][j] == 'G') {
					goalr = i;
					goalc = j;
				}
			}
		}
		
		System.out.println(binarysearch());
	}
	
	public static int binarysearch() {
		int low = 1;
		int high = t;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			if (canReachGoalWithX(mid)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high;
	}
	
	public static boolean canReachGoalWithX(int x) {
		PriorityQueue<CustomClass> q = new PriorityQueue<CustomClass>();
		q.add(new CustomClass(startr, startc, 0));
		
		int[][] visited = new int[h][w];
		
		int[][] dist = new int[h][w];
		for (int i = 0; i < h; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE / 2 - 1);
		}
		dist[startr][startc] = 0;
		
		while (q.size() > 0) {
			CustomClass curr = q.poll();
			
			if (curr.r == goalr && curr.c == goalc) {
				break;
			}
			if (visited[curr.r][curr.c] == 1) {
				continue;
			}
			
			visited[curr.r][curr.c] = 1;
			for (int i = 0; i < 4; i++) {
				int newr = curr.r + dx[i];
				int newc = curr.c + dy[i];
				
				if (0 <= newr && newr < h && 0 <= newc && newc < w && visited[newr][newc] == 0) {
					int cost = map[newr][newc] == '#' ? x : 1;
					
					if (dist[curr.r][curr.c] + cost < dist[newr][newc]) {
						dist[newr][newc] = dist[curr.r][curr.c] + cost;
						q.add(new CustomClass(newr, newc, dist[newr][newc]));
					}
				}
			}
		}
		return dist[goalr][goalc] <= t;
		
	}
	
	
}

class CustomClass implements Comparable<CustomClass> {
	int r;
	int c;
	int dist;
	
	public CustomClass(int r, int c, int dist) {
		this.r = r;
		this.c = c;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(CustomClass o) {
		return this.dist - o.dist;
	}
	
	
}
        