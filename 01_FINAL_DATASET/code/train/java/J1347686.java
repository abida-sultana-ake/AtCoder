import java.util.Scanner;

public class Main {
	private static final int MOD_SEED = 1000000007;

	public static void main(String[] args){
		Scanner io = new Scanner(System.in);
		int N = io.nextInt();
		int M = io.nextInt();
		long[] x = new long[N-1];
		long[] y = new long[M-1];
		
		int pr = io.nextInt();
		int sum=0;
		for(int i=0;i<N-1;i++){
			int cr = io.nextInt();
			x[i] = cr-pr;
			sum += (cr-pr);
			pr = cr;
		}
		
		long pushX = foldin(x,sum);
		
		pr = io.nextInt();
		sum = 0;
		for(int i=0;i<M-1;i++){
			int cr = io.nextInt();
			y[i] = cr-pr;
			sum += cr-pr;
			pr = cr;
		}
				
		long pushY = foldin(y,sum);
		System.out.println(pushX*pushY%MOD_SEED);
	}
	
	public static long foldin(long[] belt,long sum){
		long ans = 0;
		for(int i=0;i<(belt.length+1)/2;i++){
			ans = (ans + sum*(belt.length-2*i))%MOD_SEED;
			sum -= belt[i];
			sum -= belt[belt.length-1-i];
		}
		return ans;
	}
}