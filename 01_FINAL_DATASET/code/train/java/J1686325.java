import java.util.*;

public class Main {    
    
  private static int limit = 50;
  
  static int N,M;
  static int a[] = new int[limit];
  static int b[] = new int[limit];
  
  static boolean graph[][] = new boolean[limit][limit];
  static boolean visited[] = new boolean[limit];  
  
  static void dfs(int v){
      visited[v] = true;
      for(int v2 = 0;v2 < N;v2++){
          if(!graph[v][v2])continue;
          if(visited[v2])continue;
          dfs(v2);
      }      
  }
  
  public static void main(String[] args){
      
      Scanner sc =new Scanner(System.in);
     
      N = sc.nextInt();
      M = sc.nextInt();
      
      for(int i = 0;i < M;i++){
          a[i] = sc.nextInt() - 1;
          b[i] = sc.nextInt() - 1;
          graph[a[i]][b[i]] = graph[b[i]][a[i]] = true;          
      }
      
      int ans = 0;
      
      for(int i = 0;i < M;i++){
          graph[a[i]][b[i]] = graph[b[i]][a[i]] = false;
          
          for(int j = 0;j < N;j++)visited[j] = false;
          
          dfs(0);
          
          boolean bridge = false;
          for(int j = 0;j < N;j++){
              if(!visited[j]){
                  
                  bridge = true;
              }
          }
          if(bridge){
              ans++;
          }
          
          graph[a[i]][b[i]] = graph[b[i]][a[i]] = true;
      }
      
      System.out.println(ans);
  }
  
}
        
        
        