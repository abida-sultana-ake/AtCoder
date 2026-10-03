
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
        int A = ni();
        int B = ni();

        int result = A + B;
        if(result > 23)
            result -= 24;
        out.println(result);
        out.flush();
    }

    static int ni() {
        return Integer.parseInt(in.next());
    }
}