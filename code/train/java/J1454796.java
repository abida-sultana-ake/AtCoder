import java.util.Scanner;
public class Main {
  static int j = 0;
  static int[] abc = new int[3];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    for(int i = 0; i<abc.length; i++){
      abc[i] = sc.nextInt();
    }
    for(; j<2; j++){
      sub();
    }
    System.out.println(abc[1]);
  }

  public static void sub() {
    for(int i = 0; i<abc.length-1-j; i++){
      if(abc[i] == Math.max(abc[i],abc[i+1])){
      }else{
        int free = abc[i];
        abc[i] = abc[i+1];
        abc[i+1] = free;
      }
    }
  }
}
