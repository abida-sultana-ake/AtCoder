import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static FastScanner in;

    private void solve(){
        int[] count = new int[26];
        Arrays.fill(count,Integer.MAX_VALUE);

        int n = in.nextInt();
        for(int i=0;i<n;i++){
            String s = in.nextLine();
            int[] nC = new int[26];
            Arrays.fill(nC,0);
            for(int j=0;j<s.length();j++){
                nC[s.charAt(j)-'a']++;
            }

            for(int j=0;j<26;j++){
                count[j] = Math.min(count[j],nC[j]);
            }
        }

        for(int i=0;i<26;i++){
            char c = (char)('a'+i);
            while(count[i] > 0){
                out.print(c);
                count[i]--;
            }
        }
        out.print("");
    }

    private void runIO() {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        solve();
        out.close();
    }
    private static class FastScanner {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        private FastScanner() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            if (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private String nextLine() {
            String ret = "";
            try {
                ret = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        new Main().runIO();
    }
}
