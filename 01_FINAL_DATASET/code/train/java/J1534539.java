import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int MaxValue = Integer.MAX_VALUE / 1000;
    int AbcLen = 26;

    void solve() {
        char[] inputCharArray = in.nextToken().toCharArray();
        int inputLen =inputCharArray.length;
        int[] dp = new int[inputLen];
        int[] last = new int[AbcLen];
        int[] lastPos = new int[AbcLen];
        Arrays.fill(lastPos, inputLen);
        int[] resultCharIndex = new int[inputLen];
        int[] resultCharList = new int[inputLen];

        for (int inputIndex = inputLen - 1; inputIndex >= 0; inputIndex--) {
            int inputChar = inputCharArray[inputIndex] - 'a';
            dp[inputIndex] = MaxValue;
            for (int AbcIndex = 0; AbcIndex < AbcLen; AbcIndex++) {
                if (last[AbcIndex] + 1 < dp[inputIndex]) {
                    dp[inputIndex] = last[AbcIndex] + 1;
                    resultCharIndex[inputIndex] = lastPos[AbcIndex];
                    resultCharList[inputIndex] = AbcIndex;
                }
            }
            last[inputChar] = dp[inputIndex];
            lastPos[inputChar] = inputIndex;
        }

        int resultBegin = -1, addCharPos = -1;
        for (int i = 0; i < AbcLen; i++) {
            if (resultBegin == -1 || last[i] < last[resultBegin]) {
                resultBegin = i;
                addCharPos = lastPos[resultBegin];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char) (resultBegin + 'a'));
        while (addCharPos < inputLen) {
            sb.append((char) (resultCharList[addCharPos] + 'a'));
            addCharPos = resultCharIndex[addCharPos];
        }
        out.println(sb.toString());
    }

    FastScanner in;
    PrintWriter out;

    void run() {
        in = new FastScanner();
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

}