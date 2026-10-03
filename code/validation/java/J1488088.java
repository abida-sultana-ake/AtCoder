import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int H = in.nextInt();
            int W = in.nextInt();
            int N = in.nextInt(); 
            int a[] = new int[N];
            for(int i=0; i<N; i++){
                a[i] = in.nextInt();
            }
            int c[][] = new int[H][W];
            int j=0;
            int i=0;
            int k=0;
            while(i<H){
                if(i%2==0){
                    c[i][j] = k;
                    a[k]--;
                    if(a[k]==0) k++;
                    j++;
                    if(j==W){
                        j--;
                        i++;
                    }
                }
                else if(i%2==1){
                    c[i][j] = k;
                    a[k]--;
                    if(a[k]==0) k++;
                    j--;
                    if(j==-1){
                        j++;
                        i++;
                    }
                }
            }
            for(int r=0; r<H; r++){
                for(int h=0; h<W; h++){
                    out.print((c[r][h]+1)+" ");
                }
                out.println();
            }
            
        }
    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}