import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 整数の入力
        int watch = sc.nextInt();
        int time = sc.nextInt();
        if (watch < time) {
            System.out.println(0);
        } else {
            System.out.println(watch-time);
        }
    }
}