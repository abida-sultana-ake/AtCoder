import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int [] h = new int [N];
        for(int i=0; i<N; i++){
            h[i] = sc.nextInt();
        }
        Arrays.sort(h);
        long min = 0;
        long max = 1000000000;
        long mid = 0;
        while(max-min>1){
            mid = max-(max-min)/2;
            if(judge(mid,h,N,B,A-B)){
                max = mid;
            }else{
                min = mid;
            }
        }
        if(!judge(mid,h,N,B,A-B))mid++;
        System.out.println(mid);
    }
    static boolean judge(long mid, int[]h, int N, int B, double C){
        long Z=0;
        for(int i=N-1; i>=0; i--){
            long tmp = h[i]-mid*B;
            if(tmp>0){
                Z+=((long)(Math.ceil(tmp/C)));
            }else{
                break;
            }
        }
        if(Z>mid)return false;
        return true;
    }
}
