import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve(args);
    }

    boolean[] check;
    boolean[] used;
    List<List<Integer> > list = new ArrayList<>();
    public void solve(String[] args) {
        MyScanner scanner = new MyScanner();
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            List<Integer> p = new ArrayList<>();
            p.add(scanner.nextInt() -1);
            p.add(scanner.nextInt() -1);
            list.add(p);
        }

        int ret = 0;
        for (int i = 0; i < M; i++) {
            check = new boolean[N];
            used = new boolean[M];
            dfs(0, i);
            boolean f = true;
            for (int j = 0; j < N; j++) {
                if (!check[j]) {
                    f = false;
                }
            }
            if (!f) {
                ret++;
            }
        }
        System.out.println(ret);
    }

    private void dfs(int index, int ignore) {
        check[index] = true;
        for (int i = 0; i < list.size(); i++) {
            if (i == ignore || used[i]) {
                continue;
            }
            List<Integer> p = list.get(i);
            if (p.get(0) == index) {
                used[i] = true;
                dfs(p.get(1), ignore);
            }
            if (p.get(1) == index) {
                used[i] = true;
                dfs(p.get(0), ignore);
            }
        }
    }

    private class MyScanner {
        String[] s;
        int i;
        BufferedReader br;
        String reg = " ";

        MyScanner () {
            s = new String[0];
            i = 0;
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                if (i < s.length) return s[i++];
                String line = br.readLine();
                while (line.equals("")) {
                    line = br.readLine();
                }
                s = line.split(reg, 0);
                i = 0;
                return s[i++];
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public int nextInt() {
            try {
                return Integer.parseInt(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }

        public double nextDouble() {
            try {
                return Double.parseDouble(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }

        public long nextLong()  {
            try {
                return Long.parseLong(next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }
    }
}
