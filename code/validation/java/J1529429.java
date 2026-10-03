import java.util.*;

public class Main{ 
        
    public static void main(String[] args){
      
        Scanner sc = new Scanner(System.in);
                                               
        int N = sc.nextInt();
        
        int[] sticks = new int[N];
        
        for(int i = 0;i < N;i++){
            sticks[i] = sc.nextInt();
        }
        
        Arrays.sort(sticks);
                
        System.out.println(makeRectangle(sticks));
        
    }    
    
    static long makeRectangle(int[] sticks){
         
        int a = 0;
        int b = 0;
        int prev = -1; 
       
        for(int i = sticks.length - 1;i >= 0;i--){
            if(prev == sticks[i]){
                  if(a == 0){
                      a = sticks[i];
                      prev = -1;
                      continue;
                  }else{
                     b = sticks[i];
                     break;
                  }                
            }            
            prev = sticks[i];
        }
        
        return (long) a*b;
    }    
    
}       
