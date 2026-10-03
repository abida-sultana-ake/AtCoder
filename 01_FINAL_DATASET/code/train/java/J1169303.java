import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        
        // He can go to X iff he can go farther than X
        // Ans. the minimum N s.t. 1+2+...+N >=X
        // N*(N+1) >= 2X  > N*(N-1)
        
        int N = (int)Math.sqrt(2*X);
        if(N*(N+1)<2*X) N++;
        System.out.println(N);
    }
}