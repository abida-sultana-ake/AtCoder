
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * http://abc042.contest.atcoder.jp/tasks/abc042_b
 * @author Cummin
 */
public class Main {

    public static void main(String[] args) {
        int N, L ;
         // データの読み込み
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        
        List<String> array = new ArrayList<String>();
        for (int i=0 ; i<N; i++) {
            String s ;
            s = sc.next();
            array.add(s) ;
        }
        Collections.sort(array);
        for (String string : array) {
            System.out.printf("%s",string);
        }
    }
}
