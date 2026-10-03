import java.util.Scanner;

/**
 * Created by ryosuke on 2016/06/22.
 */
public class Main {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.next());
        double ans = Math.pow(10, N-1);
        String ansString = String.format("%.0f", ans);
        System.out.print(ansString+"7");
    }
}
