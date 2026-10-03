import static java.lang.Math.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * http://arc060.contest.atcoder.jp/tasks/arc060_b
 *  f(b,n) は、n を b 進表記したときの各桁の和
 *  f(b,n)=s を満たすような 2 以上の整数 b が存在するか判定(存在する場合は最小のb)
 * 
 * @author Cummin
 */
/**
 *  例: b=10の場合、123=1*100+2*10+3 ⇒ 1*(99+1)+2(9+1)+3=9*(1*11+2*1)+(1+2+3)
 *      b進法の場合、ABC=A*b^2+B*b+C ⇒　ABC=(b-1)*x + y 
 *      ここで、ABC=n, y=sだから、(n-s)=(b-1)*x であり、(n-s)を素因数分解して一番小さい約数が(b-1)
*/
public class Main {

    public static void main(String[] args) {
        long N, S ;
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        S = sc.nextLong();
        
        long ans = -1 ;
        
        if (N==S) {
            ans = N+1 ;
        } else if (N<S) {
            ans = -1 ;
        } 
        else {
            long factors[][] ;  // 10^9 では、素因数の数は高々15個未満
            factors = prime_factors(N-S) ;
            long combi[] ;
            long list[] ={1};
            for (int i=0 ; factors[i][1]>0 ; i++){
                combi = expand(factors[i][0],factors[i][1]) ;
                list = direct_product(list, combi) ;
            }
            Arrays.sort(list) ;
            ans = -1 ;
            for (int i=0 ; i<list.length ; i++){
                if (f(list[i]+1,N)==S) {
                    ans = list[i]+1 ;
                    break ;
                }
            }
        }
        if (ans<2) ans = -1 ;
        System.out.println(ans) ;
    }
    static long[] expand(long a, long b) {  // a^b
        long ans[] = new long[(int)b+1] ;
        ans[0] = 1 ;
        for (int i=1 ; i<(b+1); i++){
            ans[i] = ans[i-1] * a ;
//            System.out.printf("%d ", ans[i]) ;
        }
//        System.out.println() ;
        return ans ;
    }
    static long[] direct_product(long[] A, long[] B) { // A × B
        long ans[] = new long[A.length * B.length] ;
        for (int i=0 ; i<B.length; i++) {
            for (int j=0 ; j<A.length; j++) {
                ans[i*A.length+j] = A[j] * B[i] ;
//                System.out.printf("%d ", ans[i*A.length+j]) ;
            }
        }
//        System.out.println() ;
        return ans ;
    }
        
    ////////////////// 素因数分解　/////////////////////
    static long[][] prime_factors(long N) {
        
        int M ;
        M = (int) Math.sqrt(N) + 1 ;
        if (M<30) M=30 ;
        int prime[] = new int[M / 2];
        int prime_cnt ;
        prime_cnt = get_prime_list(M, prime) ;

        long factors[][] =new long[15][2] ;  // 10^9 では、素因数の数は高々15個未満
        int fct_cnt = 0 ;
        
        for (int i= 1 ; i < prime_cnt ; i++) {
            if ((N % prime[i])==0) {
                factors[fct_cnt][0] = prime[i] ;
                factors[fct_cnt][1] = 1 ;
                fct_cnt ++ ;
                N = N / prime[i] ;
                while ((N % prime[i])==0) {
                    factors[fct_cnt-1][1] ++ ;
                    N = N / prime[i] ;
                }
            }
        }
        if (N!=1) {
            factors[fct_cnt][0] = N ;
            factors[fct_cnt][1] = 1 ;
            fct_cnt ++ ;
        }
        /** /
        for (int i= 0 ; i<fct_cnt ; i++) {
            System.out.printf("prime= %d, cnt=%d \n", factors[i][0], factors[i][1]) ;
        }
        System.out.println() ;
        /**/
        return factors ;
        
    }

    //////////////// Prime Listの生成 ////////////////////
    static int digit_2[] = {0x01, 0x02, 0x04, 0x08, 0x010, 0x020, 0x040, 0x080, 0x0100, 0x0200, 0x0400, 0x0800,
        0x01000, 0x02000, 0x04000, 0x08000, 0x010000, 0x020000, 0x040000, 0x080000, 0x0100000, 0x0200000, 0x0400000, 0x0800000,
        0x01000000, 0x02000000, 0x04000000, 0x08000000, 0x010000000, 0x020000000};
        
    static int get_prime_list(int N, int prime[]) {
        int Bit[] =  new int[N / 30 + 1] ;
        int _30m_d = 0x0efbaebbe;

        Arrays.fill(Bit, _30m_d);
        Bit[0] = Bit[0] & 0xFFFFFFE9; 

        int t_prime[] = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        
        int p_pos = 11;
        for (int i = 0; i < p_pos; i++) {
            prime[i] = t_prime[i];
        }

        int pos = 4;
        for (int ii = pos; ii < p_pos; ii++) {
            int p;
            p = prime[ii];
            for (int j = p * p; j <= N; j = j + 2 * p) {
                setBit(Bit, j);
            }

            for (int j = prime[ii - 1] * prime[ii - 1]; j < (prime[ii] * prime[ii]); j++) {
                if (j > N) {
                    break;
                }
                if (checkBit(Bit, j) == 0) {
                    prime[p_pos] = j;
//                    System.out.printf("prime_added %d\n", j) ;
                    p_pos++;
                }
            }
            if (p * p >= N) {
                break;
            }
        }
        /** /
        for (int i = 0; i < p_pos; i++) {
           System.out.printf("%d ", prime[i]);
       }
       System.out.printf("Prime count = %d \n", p_pos) ;
       /**/
        return p_pos ;
    }

    static void setBit(int[] array, int i) {
        int j, k;
        i--;
        j = i % 30;
        k = i / 30;
//       System.out.printf("setBit %d  %x  %x\n", i+1,array[k], array[k] | digit_2[j] ) ;
        array[k] = array[k] | digit_2[j];
    }

    static int checkBit(int[] array, int i) {
        int j, k;
        i--;
        j = i % 30;
        k = i / 30;
//        System.out.printf("checkBit %d  %x  %x\n", i+1,array[k], array[k] & digit_2[j] ) ;
        if ((array[k] & digit_2[j]) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
//////////////////////////////////////////////////////////
    /*
    関数 f(b,n) の定義
        •n<b のとき f(b,n)=n
        •n≥b のとき f(b,n)=f(b, floor(n⁄b))+(n mod b)
    */
    static long f(long b, long n) {
        //System.out.printf("F(%d,%d)", b, n) ;
        /*
        if (n<b) return n ;
        else return (f(b, (long) Math.floor(n/b)) + (n % b)) ;
        */
        long ans = 0 ;
        while (0<n){
            ans = ans + n % b ;
            n = (long) Math.floor(n/b) ;
        }
        //System.out.printf(" = %d\n",ans) ;
        return ans ;
    }
}
