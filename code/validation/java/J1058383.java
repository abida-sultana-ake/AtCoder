import java.util.*;
import java.io.*;

public class Main {

    static final int INF = (int) Math.pow(10, 9);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        //頂点の数
        int v = Integer.parseInt(st.nextToken());

        //枝の数
        int m = Integer.parseInt(st.nextToken());

        //それぞれの枝の出発点と到着点とそのコスト(a_i→b_iにかかるコストc_i)
        int[] a = new int[m];
        int[] b = new int[m];
        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken()) - 1;
            b[i] = Integer.parseInt(st.nextToken()) - 1;
            c[i] = Integer.parseInt(st.nextToken());
        }
        
        /*
        //-----------------------------ダイクストラ法 O(V+M+logV)？-------------------------
        double start=System.nanoTime();
        node[] nodes=new node[v];
        for(int i=0;i<v;i++){
            nodes[i]=new node();
            nodes[i].point=i;
            nodes[i].cost=INF;
        }
        
        for(int j=0;j<m;j++){
            nodes[a[j]].next_list.add(b[j]); nodes[a[j]].next_cost.add(c[j]);
            nodes[b[j]].next_list.add(a[j]); nodes[b[j]].next_cost.add(c[j]);
        }
        
        PriorityQueue<node> pq=new PriorityQueue(new my());
        
        //スタートをセット
        nodes[0].cost=0;
        nodes[0].hist.add(0);
        pq.offer(nodes[0]);
        
        //最短経路探索
        while(!pq.isEmpty()){
            node n=pq.poll();
            for(int i=0;i<n.next_list.size();i++){
                int next=n.next_list.get(i);
                int cost=n.cost+n.next_cost.get(i);
                if(cost<nodes[next].cost){
                    nodes[next].cost=cost;
                    nodes[next].hist=new ArrayList<>(n.hist);
                    nodes[next].hist.add(next);
                    if(!pq.contains(nodes[next])) pq.offer(nodes[next]);
                }
            }
        }System.out.println(nodes[v-1].cost);
        System.out.println("処理時間："+(System.nanoTime()-start)/1000000+"ms");
        //------------------------------------------------------------------------
        */
        
        
        
        //------------------ワーシャルフロイド法------------------------------------
        //double start=System.nanoTime();
        int[][] dp=new int[v][v];
        for(int i=0;i<v;i++){ Arrays.fill(dp[i],INF); }
        for(int i=0;i<m;i++){
            dp[a[i]][b[i]]=c[i];
            dp[b[i]][a[i]]=c[i];
        }
        
        for(int k=0;k<v;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    dp[i][j]=(int)Math.min(dp[i][j],(dp[i][k]+dp[k][j]));
                }
            }
        }//System.out.println(dp[0][v-1]);
        //System.out.println("処理時間："+(System.nanoTime()-start)/1000000+"ms");
        
        int count=0;
        for(int i=0;i<m;i++){
            if(dp[a[i]][b[i]] < c[i]) count++;
        }System.out.println(count);
        
    }
}

class node {
    int point;
    int cost;
    List<Integer> hist = new ArrayList<>();
    List<Integer> next_list=new ArrayList<>();
    List<Integer> next_cost=new ArrayList<>();
}

//昇順の優先度付きキュー
class my implements Comparator {

    public int compare(Object arg0, Object arg1) {
        node x = (node) arg0;
        node y = (node) arg1;
        if (x.cost > y.cost) {
            return 1;
        } else if (x.cost < y.cost) {
            return -1;
        } else {
            return 0;
        }
    }
}