
import java.util.Scanner;

/**
 *  http://abc047.contest.atcoder.jp/tasks/abc047_b
 * @author おとうさん
 */
public class Main {
    public static void main(String[] args) {
        String S ;
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        char[] s ;
        s = S.toCharArray() ;
        int cnt = 0 ;
        for (int i=1 ; i< s.length; i++){
            if (s[i-1] != s[i]) cnt ++ ;
        }
        System.out.println(cnt) ;      

    }
    
}
