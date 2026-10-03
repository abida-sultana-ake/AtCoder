import java.util.*;

public class Main {    
    
    public static void main(String[] args){
       
       Scanner sc = new Scanner(System.in);       
                       
       long a = sc.nextLong();
       long b = sc.nextLong();
       long x = sc.nextLong();
       
       System.out.println(f(b,x) - f(a-1,x));       
              
    }  

    static long f(long a,long x){
        if(a == -1){
           return 0;
        }else{
           return (long)(a/x + 1);
        }
    }
    
}
        