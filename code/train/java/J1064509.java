import java.io.*;
import java.util.*;
public class Main {
    
    static int n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        a=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){ a[i]=Integer.parseInt(st.nextToken()); }
        System.out.println(dfs(0,1000000000,0));
    }
    
    static long dfs(int index,int prev,long count){
        if(index==n){ return 0; }
        if(prev>=a[index]){ return dfs(index+1,a[index],1)+1; }
        return dfs(index+1,a[index],count+1)+1+count;
    }
    
}
