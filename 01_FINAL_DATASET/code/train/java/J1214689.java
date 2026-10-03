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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (b - a == c - b) System.out.println("YES");
        else System.out.println("NO");

    }
}