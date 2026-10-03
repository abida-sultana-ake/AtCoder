import java.util.*;
public class Main {
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner sc = new Scanner(System.in);
  int N = sc.nextInt();
  double P = 1;
  for(int i=1;i<=N;i++){
   P = (P*i)%(Math.pow(10.0,9.0) + 7.0);
  }
  System.out.println((int)P);
 }
}