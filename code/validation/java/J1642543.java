import java.util.*;
 
public class Main{
  public static void main (String[] args){
                Scanner sc = new Scanner(System.in);
		// get a integer
		int X = sc.nextInt();
		int t = sc.nextInt();
               int ans = X - t < 0 ? 0 : X - t;
                System.out.println( ans ) ;
 
 }
}