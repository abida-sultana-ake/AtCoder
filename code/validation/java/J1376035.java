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
        int M = ni();

        Long combi = N == M ? 2L: 1L;

        if(N - M > 1 || N - M < -1)
            combi = 0L;
        else
        {
            int i;
            for (i = N; i >= 1; i--)
            {
                combi *= i;
                combi = combi % 1000000007;
            }
            for (i =M; i >= 1; i--)
            {
                combi *= i;
                combi = combi % 1000000007;
            }
        }
        out.println(combi);
        out.flush();
    }

    static int ni() {
        return Integer.parseInt(in.next());
    }
}