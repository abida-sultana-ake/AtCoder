import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    InputStream is;
    PrintWriter out;

    long nCr(int a , int b) {
        if (b > a) return 0;
        // out.println("a b " + a + " " + b);
        int[] cnt = new int[a + 1];
        for (int i = 1;i <= a - b;i++) {
            cnt[i] += 1;
        }
        for (int i = 1;i <= b;i++) {
            cnt[i] += 1;
        }
        // out.println("cnt[2] " + cnt[2]);
        long ans = 1;
        for (long i = a;i >= 1;i--) {
            ans *= i;
            // out.println("ans " + ans);
            for(int j = 1;j <= a;j++) {
                if (cnt[j] > 0 && ans % j == 0) {
                    // out.println("div " + j);
                    ans /= j;
                    cnt[j]--;
                }
            }
        }
        // out.println("ans " + ans);
        return ans;
    }
    
    void solve(){
        //Enter code here

        // for (int i = 1;i <= 50;i++) {
        //     for (int j = 1;j <= 50;j++) {
        //         if (nCr(i , j) < 0) {
        //             out.println("error");
        //         }
        //         out.println(nCr(i , j));
        //     }
        // }
        // if (true) return;
        
        int n = ni();
        int a = ni();
        int b = ni();
        long[] A = new long[n];
        for (int i = 0;i < n;i++) {
            A[i] = nl();
        }
        long sum = 0;
        Arrays.sort(A);
        for(int i = n - 1 , cnt = a;i >= 0 && cnt >= 0;i--) {
            cnt--;
            if (cnt < 0) break;
            sum += A[i];
        }
        int left = n - a;
        if (A[left] == A[n - 1]) {
            // out.println("here");
            //mean will not change after taking > a elements 
            int take = 0;
            for (int i = n - 1;i >= 0;i--) {
                if (A[i] != A[n - 1]) break;
                take++;
            }
            long ans = 0;
            for (int i = a;i <= b;i++) {
                ans += nCr(take , i);
            }
            double d = (double)A[n - 1];
            out.println(String.format( "%.9f", d ));
            out.println(ans);
        }
        else {
            // out.println("here");
            int available = 0 , required = 0;
            //must take only A elements
            for (int i = n - 1 ;i >= 0;i--) {
                if (A[i] == A[left]) {
                    available++;
                }
            }
            for(int i = n - 1 , cnt = a;i >= 0 && cnt >= 0;i--) {
                cnt--;
                if (cnt < 0) break;
                if (A[i] == A[left]) {
                    required++;
                }
            }
            // out.println("available " + available);
            // out.println("required " + required);
            long ans = nCr(available , required);
            double d = (double) sum;
            d /= a;
            out.println(String.format( "%.9f", d ));
            out.println(ans);
        }
    }

    public static void main(String[] args) {
        Main play = new Main();
        play.run();
    }
    public void run(){
        is = System.in;
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }
    
    byte input[] = new byte[1024];
    int len = 0,ptr = 0;
    int readByte() {
        if(ptr >= len){
            ptr = 0;
            try{
                len = is.read(input);
            } catch(IOException e){
                throw new InputMismatchException();
            }
            if(len <= 0){
                return -1;
            }
        }
        return input[ptr++];
    }
    boolean isSpaceChar(int c) {
        return !( c >= 33 && c <= 126 );
    }
    int skip(){
        int b = readByte();
        while(b != -1 && isSpaceChar(b)){
            b = readByte();
        }
        return b;
    }
    
    char nc() {
        return (char)skip();
    }
    String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!isSpaceChar(b)){
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    int ni() {
        int n = 0,b = readByte();
        boolean minus = false;
        while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')){
            b = readByte();
        }
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        while(b >= '0' && b <= '9'){
            n = n * 10 + (b - '0');
            b = readByte();
        }
        return minus ? -n : n;
    }
    long nl() {
        long n = 0L;
        int b = readByte();
        boolean minus = false;
        while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')){
            b = readByte();
        }
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        while(b>='0' && b<='9'){
            n = n * 10 + (b - '0');
            b = readByte();
        }
        return minus ? -n : n;
    }
    double nd() {
        return Double.parseDouble(ns());
    }
    float nf() {
        return Float.parseFloat(ns());
    }
    int[] na(int n){
        int a[] = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = ni();
        }
        return a;
    }
    char[] ns(int n) {
        char c[] = new char[n];
        int i , b = skip();
        for (i = 0;i < n;i++){
            if (isSpaceChar(b)){
                break;
            }
            c[i] = (char)b;
            b = readByte();
        }
        return i == n ? c : Arrays.copyOf(c , i);
    }
}
