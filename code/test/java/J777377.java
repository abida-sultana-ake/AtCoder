import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        long[] collect = S.chars().boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .values().stream()
                .mapToLong(Long::longValue)
                .toArray();

        long odd = 0;
        long even = 0;
        for (long count : collect) {
            odd += count % 2;
            even += count / 2;
        }

        if (odd == 0) {
            System.out.println(even * 2);
        } else if (odd > even) {
            System.out.println(1);
        } else if (odd == even) {
            System.out.println(3);
        } else {
            System.out.println((even / odd) * 2  + 1);
        }
    }

    public static class Scanner {
        private BufferedInputStream inputStream;

        public Scanner(InputStream in) {
            inputStream = new BufferedInputStream(in);
        }

        public int nextInt() throws IOException {
            int num = 0;

            int read = skip();
            do {
                num = num * 10 + (read - 0x30);
            } while ((read = inputStream.read()) > 0x20);

            return num;
        }

        public int[] nextInt(int n) throws IOException {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }

            return array;
        }

        public long nextLong() throws IOException {
            long num = 0;

            int read = skip();
            do {
                num = num * 10 + (read - 0x30);
            } while ((read = inputStream.read()) > 0x20);

            return num;
        }

        public long[] nextLong(int n) throws IOException {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }

            return array;
        }

        public String next() throws IOException {
            StringBuilder builder = new StringBuilder();

            int read = skip();
            do {
                builder.append((char) read);
            } while ((read = inputStream.read()) > 0x20);

            return builder.toString();
        }

        private int skip() throws IOException {
            int read;
            while ((read = inputStream.read()) <= 0x20)
                ;

            return read;
        }
    }
}
