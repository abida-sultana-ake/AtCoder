import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static int N,M,R;
    private static int[] TOWNS;
    private static final int INF = 100000000;
    private static int[][] costs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        TOWNS = new int[R];
        for(int i = 0; i < R; i++) {
            TOWNS[i] = sc.nextInt() - 1;
        }
        costs = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                costs[i][j] = i==j ? 0 : INF;
            }
        }
        for(int i = 0; i < M; i++) {
            int a,b,c;
            a = sc.nextInt()-1;
            b = sc.nextInt()-1;
            c = sc.nextInt();
            costs[a][b] = costs[b][a] = c;
        }
        //Warshall-Floyd
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }
        //DFS
        LinkedList<DfsNode> stack = new LinkedList<>();
        stack.add(new DfsNode());
        List<List<Integer>> perms = new ArrayList<>();
        while(!stack.isEmpty()) {
            DfsNode node = stack.pop();
            if(node.route.size() == R) {
                perms.add(node.route);
                continue;
            }
            for(int i = 0; i < R; i++) {
                if(node.isVisited(i)) continue;
                stack.add(node.child(i));
            }
        }

        int ans = INF;
        for(List<Integer> perm : perms) {
            int dist = 0;
            for(int i = 0; i < R-1; i++) {
                dist += costs[TOWNS[perm.get(i)]][TOWNS[perm.get(i+1)]];
            }
            ans = Math.min(ans, dist);
        }
        System.out.println(ans);
    }

    private static class DfsNode {
        ArrayList<Integer> route;
        DfsNode() {
            this(new ArrayList<Integer>());
        }
        DfsNode(ArrayList<Integer> route) {
            this.route = (ArrayList<Integer>)route.clone();
        }
        DfsNode child(int i) {
            DfsNode child = new DfsNode(this.route);
            child.route.add(i);
            return child;
        }
        boolean isVisited(int i) {
            return this.route.contains(i);
        }
    }
}
