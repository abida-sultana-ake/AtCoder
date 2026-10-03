import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
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
		for(int bmask=1;bmask<(1<<nodeSize);++bmask){
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
		for(int i=0;i<nodeList.size();++i){
			for(int j=i+1;j<nodeList.size();++j){
				if(!graph[nodeList.get(i)][nodeList.get(j)])return false;
			}
		}
		return true;
	}
}