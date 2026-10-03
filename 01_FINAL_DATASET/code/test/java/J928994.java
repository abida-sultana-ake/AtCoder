import java.io.*;
import java.util.*;

/**
 * Created by fcdkbear on 15.10.16.
 */
public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        String s = in.next();
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'p') {
                count++;
            }
        }
        int canUse = s.length() / 2;
        out.println(canUse - count);
        out.close();
    }

    static class Pair {
        private long first;
        private int second;

        public Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }

        public long getFirst() {
            return first;
        }

        public void setFirst(long first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }

}
