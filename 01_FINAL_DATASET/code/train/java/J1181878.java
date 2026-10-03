import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static FastScanner in;

    List<Integer> list = new ArrayList<>();
    int min,y,n;

    private void permutations(int num){
        //out.println(num);
        if(cntDigits(num) == y){
            if(num >= n){
                min = Math.min(min,num);
                return;
            }
        }

        if(cntDigits(num) == y+1){
            if(num >= n){
                min = Math.min(min,num);
            }
            return;
        }

        for(int i:list){
            permutations(num*10+i);
        }
    }

    private int cntDigits(int x){
        int cnt = 0;
        while(x>0){
            x/=10;
            cnt++;
        }
        return cnt;
    }

    private void solve() {
        n = in.nextInt();
        int k = in.nextInt();

        y= cntDigits(n);

        boolean[] mrk = new boolean[11];
        Arrays.fill(mrk,false);
        for(int i=0;i<k;i++){
            mrk[in.nextInt()] = true;
        }
        min = 100000000;
        list = new ArrayList<>();
        for(int i=0;i<10;i++){
            if(!mrk[i]){
                list.add(i);
            }
        }
        Collections.sort(list);
        for (int idx:list){
            if(idx == 0) continue;
            permutations(idx);
        }
        out.print(min);
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
