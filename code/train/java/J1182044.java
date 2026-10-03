
import java.util.*;

/**
 * Created by Seiya on 2016/10/16.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        pair[] a = new pair[N];
        for (int i = 0; i < N; i++) {
            long tempa = scanner.nextLong();
            long tempb = scanner.nextLong();
            a[i] = new pair(tempa, tempb);
        }
        pair[] b = new pair[M];
        for (int i = 0; i < M; i++) {
            long tempa = scanner.nextLong();
            long tempb = scanner.nextLong();
            b[i] = new pair(tempa, tempb);
        }

        for (int i = 0; i < N; i++) {
            long min = 999999999;
            int minN = M - 1;
            for (int j = M - 1; j >= 0; j--) {
                long temp = Math.abs(a[i].a - b[j].a) + Math.abs(a[i].b - b[j].b);
                // System.out.println(j + "==" + temp);
                if(min >= temp){
                    min = temp;
                    minN = j + 1;
                }
            }
            System.out.println(minN);
        }


    } // mainMethod

    static class pair {
            public long a;
            public long b;

            pair(){
                this.a = 0;
                this.b = 0;
            }

            pair(long a, long b){
                this.a = a;
                this.b = b;
            }

            public void set(long a, long b) {
                this.a = a;
                this.b = b;
            }
        }



} // MainClass
