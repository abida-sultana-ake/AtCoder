import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Sandeep Pandey
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        FactorsOfFactorial solver = new FactorsOfFactorial();
        solver.solve(1, in, out);
        out.close();
    }

    static class FactorsOfFactorial {
        private static int MOD = 1000000007;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int number = in.readInt();
            List<Integer> primeList = getPrimes(number);
            MyIntBasedPair[] numberWithExponent = new MyIntBasedPair[primeList.size()];
            int i = 0;
            for (Integer prime : primeList) {

                int exponent = 0;
                int div = prime;
                while (true) {
                    long x = number / div;
                    if (x > 0) {
                        exponent += x;
                        div = prime * div;
                    } else {
                        break;
                    }
                }
                numberWithExponent[i++] = new MyIntBasedPair(prime, exponent);
            }


            long result = 1;
            for (MyIntBasedPair myIntBasedPair : numberWithExponent) {
                result = result * (myIntBasedPair.getSecond() + 1);
                while (result > MOD) {
                    result -= MOD;
                }

                while (result < 0) {
                    result += MOD;
                }
            }
            out.printLine(result % MOD);


        }

        private List<Integer> getPrimes(int givenLimit) {
            List<Integer> primeList = new ArrayList<>();
            int[] flagAt = new int[givenLimit + 1];
            Arrays.fill(flagAt, 1);
            flagAt[0] = flagAt[1] = 0;

            for (int from = 2; from * from <= givenLimit; from++) {
                if (flagAt[from] == 1) {
                    for (int j = 2 * from; j <= givenLimit; j += from) {
                        flagAt[j] = 0;
                    }
                }
            }

            for (int from = 0; from <= givenLimit; from++) {
                if (flagAt[from] == 1)
                    primeList.add(from);
            }
            return primeList;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {

            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {

            for (int i = 0; i < objects.length; i++) {

                if (i != 0)

                    writer.print(' ');

                writer.print(objects[i]);

            }

        }

        public void printLine(Object... objects) {

            print(objects);

            writer.println();

        }

        public void close() {

            writer.close();

        }

    }

    static class MyIntBasedPair implements Comparable<MyIntBasedPair> {
        private int first;
        private int second;

        public MyIntBasedPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }


            if (!(o instanceof MyIntBasedPair)) {
                return false;
            }

            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }

            MyIntBasedPair myIntBasedPair = (MyIntBasedPair) o;

            return this.getFirst() == myIntBasedPair.getFirst()
                    && this.getSecond() == myIntBasedPair.getSecond();
        }

        public int hashCode() {
            int result = first;
            result = 31 * result ^ second;
            return result;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }


        public int compareTo(MyIntBasedPair toCompare) {
            // add some default implementation
            if (first < toCompare.first)
                return -1;
            if (first > toCompare.first)
                return 1;
            if (second < toCompare.second)
                return -1;
            if (second > toCompare.second)
                return 1;
            return 0;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {

            this.stream = stream;

        }

        public int read() {

            if (numChars == -1)

                throw new InputMismatchException();

            if (curChar >= numChars) {

                curChar = 0;

                try {

                    numChars = stream.read(buf);

                } catch (IOException e) {

                    throw new InputMismatchException();

                }

                if (numChars <= 0)

                    return -1;

            }

            return buf[curChar++];

        }

        public int readInt() {

            int c = read();

            while (isSpaceChar(c))

                c = read();

            int sgn = 1;

            if (c == '-') {

                sgn = -1;

                c = read();

            }

            int res = 0;

            do {

                if (c < '0' || c > '9')

                    throw new InputMismatchException();

                res *= 10;

                res += c - '0';

                c = read();

            } while (!isSpaceChar(c));

            return res * sgn;

        }

        public boolean isSpaceChar(int c) {

            if (filter != null)

                return filter.isSpaceChar(c);

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;

        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

