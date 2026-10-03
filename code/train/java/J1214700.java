import java.io.*;
        import java.util.*;

public class Main {
    //-------------------------------------------------------------//
    public static final void main(String[] args) {
        new Main().solve();
    }
    //-------------------------------------------------------------//
    private final Scanner sc = new Scanner(System.in);
    void solve() {
        String O = sc.next();
        String E = sc.next();
        String ans = "";
        for (int i = 0; i < O.length() + E.length(); i++) {
            if ((i & 1) == 0) {
                ans += O.charAt(i / 2);
            }
            else {
                ans += E.charAt(i / 2);
            }
        }
        System.out.println(ans);
    }
}