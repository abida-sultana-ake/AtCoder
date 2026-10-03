import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int m;
    static int count=0;
    static Set<Integer>[]  a;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        a=new Set[n];
        int aa,bb;
        for(int i=0;i<n;i++){ a[i]=new HashSet<>(); }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            aa=Integer.parseInt(st.nextToken())-1;
            bb=Integer.parseInt(st.nextToken())-1;
            a[aa].add(bb);
            a[bb].add(aa);
        }
        
        /*
        for(int i=0;i<n;i++){
            System.out.println(i);
            for(int nn:a[i]){ System.out.print(nn+" "); }
            System.out.println();
        }*/
        
        boolean[] dp=new boolean[n];
        Arrays.fill(dp,false);
        dp[0]=true;
        dfs(dp,0);
        System.out.println(count);
    }
    
    static void dfs(boolean[] dp,int index){
        int c=0;
        while(c<dp.length&&dp[c]){ c++; }
        if(c==dp.length){ count++; return; }
        boolean[] table=Arrays.copyOf(dp, dp.length);
        for(int next:a[index]){
            if(!table[next]){
                table[next]=true;
                dfs(table,next);
                table[next]=false;
            }
        }
    }
    
}
