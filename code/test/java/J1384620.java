import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {           
    
    private static int dfs(int index,int a,int b,int[] t){
        if(index == t.length){
            return Math.max(a,b);
        }
        
        return Math.min(
            dfs(index+1,a + t[index],b,t),  
            dfs(index+1,a,b + t[index],t)
        );
        
    }
    
    public static void main(String[] args) {		        
        Scanner sc = new Scanner(System.in);                                                                     
                                                               
         int N = sc.nextInt();
         
         int[] t = new int[N];
         
         for(int i = 0;i < N;i++){
             t[i] = sc.nextInt();
         }
      
         System.out.println(dfs(0,0,0,t));
        
  }
}
        
        
        