import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final long MOD = 1000000007;
    int n;
    char[] s1, s2;
    boolean[] isRow;

    public static void main(String[] args) {
        Main m = new Main();
        m.read();
        m.solve();
    }

    private void read() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        )) {
            n = Integer.parseInt(br.readLine());
            s1 = br.readLine().toCharArray();
            s2 = br.readLine().toCharArray();
            isRow = new boolean[n];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void solve() {
        int i = 0;
        while (i < n) {
            if (i+1 < n && s1[i] == s1[i+1]) {
                isRow[i] = true;
                isRow[i+1] = true;
                i += 2;
            }
            else if (s1[i] == s2[i]){
                isRow[i] = false;
                i++;
            }
            else {
                isRow[i] = true;
            }
        }
        long ans = 1L;
        if (isRow[0]) {
            ans = 6L;
            i = 2;
        }else {
            ans = 3L;
            i = 1;
        }
        while (i < n) {
            if (isRow[i]) {
                if(isRow[i-1])
                    ans = modCalc(ans, 3);
                else
                    ans = modCalc(ans, 2);
                i += 2;
            }
            else {
                if(!isRow[i-1])
                    ans = modCalc(ans, 2);
                i++;
            }
        }
        System.out.println(ans);
    }

    private long modCalc(long l1, long l2) {
        return (l1 * l2) % MOD;
    }
}
