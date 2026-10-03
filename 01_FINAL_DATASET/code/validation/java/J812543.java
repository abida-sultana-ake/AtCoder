import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        String S; //文字列
        int    i; //整数
        
        Scanner scan = new Scanner(System.in);
        S = scan.next();
        i = scan.nextInt();

        System.out.println(S.substring(i-1,i));

    }

}
