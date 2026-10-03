import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by guoxiang.li on 2017/02/13.
 */
public class Main {

    private int count=0;
    private ArrayList[] graph;
    boolean[] visited;
    public int undirectedGraphTraversalWays(int[][] nums,int n){

       graph=new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList();
        }

        visited=new boolean[n];

        for(int i=0;i<nums.length;i++){
            graph[nums[i][0]-1].add(nums[i][1]-1);
            graph[nums[i][1]-1].add(nums[i][0]-1);
        }


        visited[0]=true;
        undirectedGraphTraversalWaysHelper(graph[0]);
        return count;

    }


    private boolean undirectedGraphTraversalWaysHelper(ArrayList nodes){


        boolean flag=true;
        for(boolean visitedFlag:visited){
            flag&=visitedFlag;
        }

        if(flag){
            return true;
        }


        for(Object node:nodes){

            int index=((Integer) node).intValue();

            if(visited[index]){
                continue;
            }
            visited[index]=true;

            if(undirectedGraphTraversalWaysHelper(graph[index])){
                count++;
            }

            visited[index]=false;
        }

        return false;



    }

    public static void main(String[] args) {



        Main sol=new Main();
        Scanner sc = new Scanner(System.in);
        // get a integer
        int n = sc.nextInt();
        // get two integers separated with half-width break
        int m = sc.nextInt();

        int[][] edges=new int[m][2];
        for(int i=0;i<m;i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.println(sol.undirectedGraphTraversalWays(edges,n));


    }


}