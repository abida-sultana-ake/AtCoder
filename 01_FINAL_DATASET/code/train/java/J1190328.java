import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter out;
    public static FastScanner in;

    String s;
    int n;
    private void solve(){
        n = in.nextInt();
        s = in.nextLine();

        for(int i=0;i<=1;i++){
            for(int j=0;j<=1;j++){
                List<Integer> gt = check(i,j);
                if(gt.isEmpty()) continue;

                for(int k:gt){
                    if(k == 0){
                        out.print('S');
                    }else{
                        out.print('W');
                    }
                }
                return;
            }
        }
        out.print(-1);
        return;
    }

    private List<Integer> check(int a, int b){
        List<Integer> list = new ArrayList<>();
        list.add(a);list.add(b);

        for(int i=1;i<n-1;i++){
            if(list.get(i) == 1){
                if(s.charAt(i) == 'o'){
                    list.add(list.get(i-1)^1);
                }else{
                    list.add(list.get(i-1));
                }
            }else{
                if(s.charAt(i) == 'o'){
                    list.add(list.get(i-1));
                }else {
                    list.add(list.get(i-1)^1);
                }
            }
        }

        List<Integer> lt = new ArrayList<>();
        if(list.get(0) == 0){
            if(s.charAt(0) == 'o'){
                if(list.get(1) != list.get(n-1)) return lt;
            }else{
                if(list.get(1) == list.get(n-1)) return lt;
            }
        }
        if(list.get(0) == 1){
            if(s.charAt(0) == 'o'){
                if(list.get(1) == list.get(n-1)) return lt;
            }else{
                if(list.get(1) != list.get(n-1)) return lt;
            }
        }

        if(list.get(n-1) == 0){
            if(s.charAt(n-1) == 'o'){
                if(list.get(0) != list.get(n-2)) return lt;
            }else{
                if(list.get(0) == list.get(n-2)) return lt;
            }
        }
        if(list.get(n-1) == 1){
            if(s.charAt(n-1) == 'o'){
                if(list.get(0) == list.get(n-2)) return lt;
            }else{
                if(list.get(0) != list.get(n-2)) return lt;
            }
        }

        return list;

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
