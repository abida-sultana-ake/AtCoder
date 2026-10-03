import java.util.Scanner;

/**
 * Created by sonetsuyoshi on 2016/07/31.
 */
public class Main {

    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sts = sc.nextLine().split(" ");
        long ans = 0;
        if(sts[1].equals("+")) {
            ans = Long.parseLong(sts[0]) + Long.parseLong(sts[2]);
        } else {
            ans = Long.parseLong(sts[0]) - Long.parseLong(sts[2]);
        }
        System.out.print(ans);
    }
}