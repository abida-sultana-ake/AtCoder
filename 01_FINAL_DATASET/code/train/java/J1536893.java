import java.util.*;

public class Main{      
    
    static int N;
    static int M;
    
    static boolean visit[];
    static boolean cycle[];    
    static boolean cycle2[];
    
    public static void main(String[] args){
       
        Scanner sc = new Scanner(System.in);             
                
        N = sc.nextInt();
        
        cycle = new boolean[N];        
        cycle2 = new boolean[N];
        
        M = sc.nextInt();        
        
        UnionFind uf = new UnionFind(N);                
        
        for(int i = 0;i < M;i++){
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;            
            
            if(uf.same(u, v)){
               cycle[u] = true;
               cycle[v] = true;               
            }
            
            uf.unite(u,v);                                     
        }                 
        
        for(int i = 0;i < N;i++){
            if(cycle[i]){
               int root = uf.find(i);
               cycle2[root] = true;
            }   
        }        
        
        System.out.println(uf.count());
        
    }       
    
    static class UnionFind{
        
        int par[]  = new int[N];
        int rank[] = new int[N];        
        
        UnionFind(int N){
            for(int i = 0;i < N;i++){
                par[i] = i;
               rank[i] = 0;
            }            
        }        
        
        int count(){
            int count = 0;
            for(int i = 0;i < N;i++){
              if(!cycle2[i] && i == find(i)){
                count++;
              }                
            }           
            return count;
        }
        
        int find(int x){
            if(par[x] == x){
                return x;
            }else{
                return par[x] = find(par[x]);   
            }            
        }
        
        void unite(int x,int y){
            x = find(x);
            y = find(y);
            
            if(x == y)
                return;
            
            if(rank[x] < rank[y]){
                par[x] = y;
            }else{
                par[y] = x;
                if(rank[x] == rank[y]) rank[x]++;
            }            
        }
        
        boolean same(int x,int y){
            return find(x) == find(y);
        }
                
    }        
}
