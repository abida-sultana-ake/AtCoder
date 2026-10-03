import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        // Here your code !
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        long N = 1000000007;
        long a = A%N;
        long b = B%N;
        long c = C%N;
        long ab = (a*b)%N;
        long answer = (ab*c)%N;

        System.out.println(answer);
    }
    
    
}
