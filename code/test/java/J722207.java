public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(), k = s.nextInt();
        long[] a = new long[k];

        long sum = 0, ssum = 0;

        for (int i = 0, j = 0; i < n; ++i, j = (j + 1) % k) {
            ssum = ssum - a[j] + (a[j] = Long.valueOf(s.nextInt()));
            if (i >= k - 1) {
                sum += ssum;
            }
        }
        System.out.println(sum);
    }

    static class Scanner {
        java.io.BufferedInputStream bis;

        public Scanner(java.io.InputStream is) {
            bis = new java.io.BufferedInputStream(is);
        }

        public String next() {
            StringBuilder sb = new StringBuilder();
            int b = ' ';
            try {
                for (; Character.isWhitespace(b); b = bis.read())
                    ;
                for (; !Character.isWhitespace(b); b = bis.read()) {
                    sb.append((char) b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        public int nextInt() {
            int r = 0, s = 1, b = ' ';
            try {
                for (; Character.isWhitespace(b); b = bis.read())
                    ;
                if ((s = b == '-' ? -1 : 1) < 0) {
                    b = bis.read();
                }
                for (; Character.isDigit(b); b = bis.read())
                    r = r * 10 + b - '0';
            } catch (Exception e) {
            }
            return s * r;
        }
    }
}
