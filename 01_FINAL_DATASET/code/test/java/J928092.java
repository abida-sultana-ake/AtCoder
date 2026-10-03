import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public void solve() {
        int n = in.nextInt();
        BigInteger a = new BigInteger(in.next());
        BigInteger b = new BigInteger(in.next());
        BigInteger g = a.gcd(b);
        a = a.divide(g);
        b = b.divide(g);
        //out.println(a + " " + b);
        for (int i = 1; i < n; i++) {
            BigInteger x = new BigInteger(in.next());
            BigInteger y = new BigInteger(in.next());
            g = x.gcd(y);
            x = x.divide(g);
            y = y.divide(g);
            BigInteger k1 = a.divide(x);
            if (k1.multiply(x).compareTo(a) < 0)
                k1 = k1.add(BigInteger.ONE);
            BigInteger k2 = b.divide(y);
            if (k2.multiply(y).compareTo(b) < 0)
                k2 = k2.add(BigInteger.ONE);
            BigInteger k = k1.compareTo(k2) >= 0 ? k1 : k2;
            a = x.multiply(k);
            b = y.multiply(k);
            //out.println(a + " " + b);
        }
        out.println(a.add(b));
    }

    public static void main(String[] args)throws IOException {
        FastScanner in;
        boolean isLocalRun = args.length >= 1 && "local_run".equals(args[0]);
        if (isLocalRun)
            in = new FastScanner(new FileInputStream("input"));
        else
            in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testsCount = 1;
        for (int testNum = 0; testNum < testsCount; testNum++)
            new Main(in, out).solve();
        in.close();
        out.close();
    }

    final PrintWriter out;
    final FastScanner in;

    public Main(FastScanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }
}

class FastScanner {
    private StringTokenizer tokenizer;
    private BufferedReader reader;

    public FastScanner(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line == null)
                return null;
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tokenizer = null;
        return line;
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

