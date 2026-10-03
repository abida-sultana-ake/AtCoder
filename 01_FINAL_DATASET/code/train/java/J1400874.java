import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	
	int n;
	long mod=1000000000+7;
	
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		int h=sc.nextInt();
		int w=sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		FermatCombination fc=new FermatCombination(h+w,mod);
		
		long sum=0;
		for(int i=0;i<h-a;i++){
			sum+=fc.combine(b-1+i, i)*fc.combine(w-b-1+h-1-i,w-b-1) %mod;
			sum%=mod;
		}
		System.out.println(sum);
		
	}
	class FermatCombination{
		
			long factrial[]; //階乗を保持 
			long inverse[];  //逆元を保持 
		    long MOD;
		    
		    FermatCombination(int size, long mod) { 
				 
	 		this.factrial = new long[size + 1]; 
		 		this.inverse = new long[size + 1]; 
		 		this.MOD = mod; 
		 		 
		 		this.factrial[0] = 1; 
		 		this.inverse[0] = 1; 
		 		 
		 		for (int i = 1; i <= size; i++) { 
		 			factrial[i] = (factrial[i - 1] * i) % MOD;  //階乗を求める 
		 			inverse[i] = pow(factrial[i], (int) MOD - 2) % MOD; // フェルマーの小定理で逆元を求める 
		 		} 
		 	} 

 	 
 	long combine(int n, int k) { 
 		
 		return ((factrial[n] * inverse[k]) % MOD * inverse[n - k] % MOD)%MOD;
 	} 
 	 
 	long pow(long x, int n) { //x^n 計算量O(logn) 
 		long ans = 1; 
 		while (n > 0) { 
 			if ((n & 1) == 1) { 
 				x %= MOD;
				ans = ans * x % MOD ; 
 			} 
 			x = x *  x % MOD; //一周する度にx, x^2, x^4, x^8となる 
 			x%=MOD;
 			n >>= 1; //桁をずらす n = n >> 1 
 		} 
 		return ans % MOD; 
 	} 
	}

}
