    import java.util.*;
    import java.io.*;
     
    public class Main{
    static PrintWriter out;
    static Scanner in;
    public static void main(String args[]){
    in = new Scanner(System.in);
    out = new PrintWriter(System.out);
    solve();
    in.close();
    out.close();
    }
     
    public static void solve(){
    int N = in.nextInt();
    int T = in.nextInt();
    int total = 0;
    int[] time = new int[N];
    for(int i=0;i<N;i++){
    time[i] = in.nextInt();
    }
    for(int i=0;i<N;i++){
    total += T;
    if(i>0){
    int sa = (time[i] - time[i-1]);
    if(sa<T){
    total-=(T-sa);
    }
    }
     
    }
    out.println(total);
    }
    }