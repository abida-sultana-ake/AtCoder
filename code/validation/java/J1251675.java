import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by hikigineer on 2017/03/04.
 */
public class Main {
    static Scanner in;
    static PrintWriter out;
    static String INPUT = "";

    public static void main(String[] args) throws Exception
    {
        in = INPUT.isEmpty() ? new Scanner(System.in) : new Scanner(INPUT);
        out = new PrintWriter(System.out);
        int N = ni();
        int T = ni();
        int[] t = new int[N + 1];
        int i;
        for(i = 0; i < N; i++)
            t[i] = ni();
        t[N] = 2000000000;
        long total = 0L;
        for(i = 0; i < N; i++)
        {
            total += t[i + 1] - t[i] < T ? t[i + 1] - t[i] : T;
        }
        out.println(total);
        out.flush();
    }

    static int ni() {
        return Integer.parseInt(in.next());
    }
}