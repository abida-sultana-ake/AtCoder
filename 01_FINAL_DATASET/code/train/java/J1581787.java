//package com.company;
//import javax.print.attribute.IntegerSyntax;
import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);


        int N = in.nextInt();
        int M = in.nextInt();
        int R = in.nextInt();

        int [] r1 = new int[R];

        for(int i=0; i<R; i++){
            r1[i] = in.nextInt();
        }

       int [][] b = new int[N+1][N+1];
        for(int i =0; i<=N; i++){
            for(int j =0; j<=N; j++){
                if(i==j) b[i][j] = 0;
                else b[i][j] = (int)1e9;
            }
        }

        for(int i = 0; i<M; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int c = in.nextInt();

            b[u][v]=c;
            b[v][u] = c;

        }


        for (int k=0; k <= N; ++k)
            for (int i=0; i<=N; ++i)
                for (int j=0; j<=N; ++j)
                    b[i][j] = Math.min(b[i][j], b[i][k] + b[k][j]);



        int ans = 0;
        Arrays.sort(r1);
        for(int i =0; i<R-1; i++){
            ans += b[r1[i]][r1[i+1]];
        }

        while(next_permutation(r1)){
            int ans1= 0;
            for(int i =0; i<R-1; i++){
                ans1 += b[r1[i]][r1[i+1]];
            }
            ans = Math.min(ans, ans1);
        }

        System.out.println(ans);



    }

    static boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1;; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
        return false;
    }
}