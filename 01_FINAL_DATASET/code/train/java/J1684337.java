import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
public class Main{
 static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {

            return Long.parseLong(next());
        }

        BigInteger nextBigIntger() {
            BigInteger bb = new BigInteger(next());
            return bb;
        }
    }
public static void main(String[] args){
 FastReader sc = new FastReader();
        int a =sc.nextInt();
        int b =sc.nextInt();
      int c = sc.nextInt();
if(a==b)
System.out.println(c);
else if(c==b)
System.out.println(a);
if(a==c)
System.out.println(b);

}
}