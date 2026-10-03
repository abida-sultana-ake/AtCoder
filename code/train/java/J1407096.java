import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 整数の入力
    int a = sc.nextInt();
    // スペース区切りの整数の入力
    int b = sc.nextInt();
    int c = sc.nextInt();

//    int ab = a + b;
//    int bc = b + c;
//    int ac = a+c;
//
//    int result = Math.min(ab, Math.min(bc , ac));

    int max = Math.max(a, Math.max(b, c));

    System.out.println(a + b + c - max);
  }
}
