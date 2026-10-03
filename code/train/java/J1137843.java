import java.util.*;


public class Main{
    
    public static void  dfs(int n,String s){
        if(n == 0){
            System.out.println(s);
            return;
        }
        for(char c = 'a'; c <='c';c++){
            dfs(n-1,s+c);
        }        
    }
    
    public static void main(String[] args){            
       
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        dfs(N,"");        
                
    }                                       
}