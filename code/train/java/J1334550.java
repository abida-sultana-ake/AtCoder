import java.io.BufferedReader;
import java.io.InputStreamReader;



class Main{

	static long[] memo = new long[10000000+1];
	public static long tri(int n){
		if(n == 2 || n == 1){
			return memo[n] = 0;
		}else if(n == 3){
			return memo[n] = 1;
		}
		if(memo[n] != 0){
			return memo[n];
		}else{
			return memo[n] = (tri(n-1) + tri(n-2) + tri(n-3)) % 10007;
		}

	}

	public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
    	System.out.println(tri(n));
    }

}