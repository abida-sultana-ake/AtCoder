import java.util.*;

public class Main {
    
   static int N;
   static int count;
   static ArrayList<ArrayList<Integer>> al;       
    
  public static void main(String[] args) {
      
       Scanner sc = new Scanner(System.in);              
              
       N = sc.nextInt();
       int M = sc.nextInt();
       
       al = new ArrayList<>();
       
       for(int i = 0; i < N; i++){
	   al.add(new ArrayList<>());
       } 
       
       for(int i = 0; i < M; i++) {
	   int a = sc.nextInt() - 1;
	   int b = sc.nextInt() - 1;
	   al.get(a).add(b);
	   al.get(b).add(a);
       }

       count = 0;
       boolean[] reach = new boolean[N];
       dfs(0, 0, reach);
       System.out.println(count);           
  } 
  
   static void dfs(int now, int num, boolean[] reach) {
		if (num == N - 1) {
			count++;
			return;
		}
                
		for (Integer v : al.get(now)) {
			reach[now] = true;
			if (!reach[v]) dfs(v, num + 1, reach);
			reach[now] = false;
		}          
                
   }
  
}