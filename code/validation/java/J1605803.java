import java.util.*;

public class Main {            
    
   static int N;
   static int K;
   
   static int t[][];
    
   public static void main(String[] args) {   
     
       Scanner sc = new Scanner(System.in);                                                                                     

       N = sc.nextInt();
       K = sc.nextInt();
       
       t = new int[N][K];
                 
       for(int i = 0;i < N;i++){
           for(int j = 0;j < K;j++){
               t[i][j] = sc.nextInt();  
           }
       }
     
       if(dfs(0,0)){
           System.out.println("Found");
       }else{
           System.out.println("Nothing");           
       }
       
   }         
   
   public static boolean dfs(int numberOfQuestion,int value){       
       
       if(numberOfQuestion == N){
           return value == 0;
       }
       
       for(int i = 0;i < K;i++){
         if(dfs(numberOfQuestion+1,value^t[numberOfQuestion][i])){
             return true;
         }
       }    
       
       return false;
   }    
   
}
