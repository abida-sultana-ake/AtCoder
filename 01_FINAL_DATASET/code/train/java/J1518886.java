import java.util.*;

public class Main{   
    
      static int N;
      static int W;
      static int[] w;
      static int[] v;
      
      static Map<String,Long> memo = new HashMap<>();
    
      public static void main(String[] args) {          
          
        Scanner sc = new Scanner(System.in);
      
        N = sc.nextInt();
        W = sc.nextInt();
        
        w = new int[N];
        v = new int[N];
        
        for(int i = 0;i < N;i++){
             w[i] = sc.nextInt();
             v[i] = sc.nextInt();
        }
        
        System.out.println(calc(0,0));
        
      }
      
      static long calc(int d,long weight){
          String key = d + ":" + weight;
          
          if(d >= N){
              return 0;
          }
          
          if(memo.containsKey(key)){
              return memo.get(key);
          }
          
          long v1 = 0;
          
          if(weight + w[d] <= W){
              v1 = calc(d+1,weight + w[d]) + v[d];
          }
          
          long v2 = calc(d+1,weight);
          
          long vr = Math.max(v1,v2);
          
          memo.put(key,vr);
          
          return vr;          
      }
      
}       