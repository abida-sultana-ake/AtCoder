import java.util.*;
 
/**
 * http://abc002.contest.atcoder.jp/tasks/abc002_4
 */
public class Main {
 
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean graph[][] = new boolean[N][N];
		for(int i=0; i<M; i++){
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			graph[n1-1][n2-1] = true;
			graph[n2-1][n1-1] = true;
		}
		sc.close();
	
		System.out.println(maxCluster(graph));	
	}

	public static int maxCluster(boolean[][] graph){
		int nodeSize = graph.length;
		
		int result = 0;
		for(int bmask=1; bmask < (1<<nodeSize); ++bmask){
			List<Integer> candidate = new ArrayList<>();
			int tmp = bmask;
			int shift=0;
			while(tmp != 0){
				if((tmp&1)!=0)candidate.add(shift);
				tmp>>=1;
				++shift;
			}
			if(isFullyConnected(graph, candidate))result=Math.max(result,candidate.size());
		}
		return result;
	}

	public static boolean isFullyConnected(boolean[][] graph, List<Integer>  nodeList){
		for(int i=0; i < nodeList.size(); ++i){
			for(int j=i+1; j < nodeList.size(); ++j){
				if(!graph[nodeList.get(i)][nodeList.get(j)])return false;
			}
		}
		return true;
	}

	
	public static int maxClusterDfs(boolean[][] graph){
		Map<Integer, Integer> memoization = new HashMap<Integer,Integer>();
		
		boolean[] visited = new boolean[graph.length];
		int result = 0;
		for(int start = 0; start < graph.length; ++start){
			visited[start] = true;
			result = Math.max(1 + dfs(graph, start, visited, memoization), result);
			visited[start] = false;
		}
		return result;
	}
	
	public static boolean isFullyConnected(boolean[][] graph, boolean[] visited, int newNode){
		for(int i = 0; i < graph.length; ++i){
			if(visited[i] && !graph[i][newNode]) return false;
		}
		return true;
	}
	
	public static int dfs(boolean[][] graph, int currentNode, boolean[] visited, Map<Integer, Integer> memoization){
		int memoizationKey = (1 << currentNode) << graph.length;
		for(int i = 0; i < graph.length; ++i) if(visited[i]) memoizationKey |= (1 << i);
		if(memoization.containsKey(memoizationKey)) return memoization.get(memoizationKey);

		int result = 0;
		for(int nextNode = 0; nextNode < graph.length; ++nextNode){
			if(!graph[currentNode][nextNode])continue;
			if(visited[nextNode])continue;
			if(isFullyConnected(graph, visited, nextNode)){
				visited[nextNode] = true;
				result = Math.max(result, 1 + dfs(graph, nextNode, visited, memoization));
				visited[nextNode] = false;
			}
		}
		
		memoization.put(memoizationKey, result);
		return result;
	}
}


