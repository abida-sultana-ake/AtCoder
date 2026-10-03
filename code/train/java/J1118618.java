import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.*;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n=in.nextInt();
		String s =in.nextToken();
        char[][] c = new char[4][n];

        c[0][0] = 'S';
        c[0][1] = 'S';
        c[1][0] = 'S';
        c[1][1] = 'W';
        c[2][0] = 'W';
        c[2][1] = 'S';
        c[3][0] = 'W';
        c[3][1] = 'W';

        for(int i=1; i<n-1; i++) {
            for(int j=0; j<4; j++) {
                if(c[j][i] == 'S') {
                    if(s.charAt(i)=='o') {
                        c[j][i+1] = c[j][i-1];
                    } else {
                        c[j][i+1] = rev(c[j][i-1]);
                    }
                } else{
                    if(s.charAt(i)=='o') {
                        c[j][i+1] = rev(c[j][i-1]);
                    }else{
                        c[j][i+1] = c[j][i-1];
                    }
                }
            }
        }
        boolean ans = false;
        int ansN=0;
        for(int j=0; j<4; j++) {
            boolean a = check(c[j][n-1], s.charAt(n-1), c[j][n-2], c[j][0]);
            boolean b = check(c[j][0], s.charAt(0), c[j][n-1], c[j][1]);
            if(a && b) {
                ans = true;
                ansN = j;
                break;
            }
        }

        if(ans == false) {
            out.println(-1);
        }else {
            out.println(new String(c[ansN]));
        }
		out.flush();
	}

    public static boolean check(char Ani, char say, char n1, char n2) {
        if(Ani == 'S') {
            if(say=='o') {
                if(n1 == n2) {
                    return true;
                }
            } else {
                if(n1 != n2) {
                    return true;
                }
            }
        } else {
            if(say=='o') {
                if(n1 != n2) {
                    return true;
                }
            } else {
                if(n1 == n2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static char rev(char c) {
        if(c == 'S') {
            return 'W';
        }else {
            return 'S';
        }
    }

	// ----------------------

	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int next() {
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

		public char nextChar() {
			int c = next();
			while (isSpaceChar(c))
				c = next();
			if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
				return (char) c;
			}
			throw new InputMismatchException();
		}

		public String nextToken() {
			int c = next();
			while (isSpaceChar(c))
				c = next();
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = next();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public int nextInt() {
			int c = next();
			while (isSpaceChar(c))
				c = next();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = next();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c-'0';
				c = next();
			} while (!isSpaceChar(c));
			return res*sgn;
		}

		public long nextLong() {
			int c = next();
			while (isSpaceChar(c))
				c = next();
			long sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = next();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c-'0';
				c = next();
			} while (!isSpaceChar(c));
			return res*sgn;
		}

		public double nextDouble() {
			return Double.valueOf(nextToken());
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		//public interface SpaceCharFilter {
		//	public boolean isSpaceChar(int ch);
		//}
	}
	// template
	static int gcd(int n, int r) { return r == 0 ? n : gcd(r, n%r);  }
	static long gcd(long n, long r) { return r == 0 ? n : gcd(r, n%r);  }

	static <T> void swap(T[] x, int i, int j) { T t = x[i]; x[i] = x[j]; x[j] = t;  }
	static void swap(int[] x, int i, int j) { int t = x[i]; x[i] = x[j]; x[j] = t;  }
}
