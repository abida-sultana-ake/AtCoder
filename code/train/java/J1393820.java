import java.util.*;

public class Main {
  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);      
     
     String S = sc.next();
     
     int N = S.length();
     
     boolean flag = false;
     
     for(int i = 1;i < N;i++){
         if(isGoo(S)){
            if(!flag){
              flag = true;
            }else{
              System.out.println(S.length());
              return;
            }
         }
         S = S.substring(0,S.length() - 1);
     }          
     
  }
  
  private static boolean isGoo(String S){
      if(S.length()%2 != 0){
          return false;
      }      
      for(int i = 0;i < S.length()/2;i++){
          if(S.charAt(i) != S.charAt(S.length()/2 + i)){
              return false;
          }
      }     
      return true;
  }
  
}
