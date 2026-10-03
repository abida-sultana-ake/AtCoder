import java.util.*;

public class Main {
    public static void main(String[] args){
        String result = "";
        Scanner sc = new Scanner(System.in);
        // 整数Nの入力
        long n = sc.nextLong();
        // 整数Mの入力
        long m = sc.nextLong();
        if (n * 2 < m) {
            result = String.valueOf((n + (m - n * 2) / 4));
        } else {
            result = String.valueOf(m / 2);
        }
        // 出力
        System.out.println(result);
    }
}